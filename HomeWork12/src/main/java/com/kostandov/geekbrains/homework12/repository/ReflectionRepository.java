package com.kostandov.geekbrains.homework12.repository;

import com.kostandov.geekbrains.homework12.annotations.DbColumn;
import com.kostandov.geekbrains.homework12.annotations.DbId;
import com.kostandov.geekbrains.homework12.annotations.DbTable;
import com.kostandov.geekbrains.homework12.exceptions.NoDbIdAnnotationException;
import com.kostandov.geekbrains.homework12.exceptions.NoDbTableAnnotationException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReflectionRepository<T> {
    private static Connection connection;
    private static Statement stmt;
    private Class<T> myClass;

    public ReflectionRepository(Class<T> myClass){
        this.myClass = myClass;
    }

    private void connect(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    public static void disconnect() {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String getTableName(){
        if(myClass.isAnnotationPresent(DbTable.class)) {
            return myClass.getAnnotation(DbTable.class).name();
        }else {
            throw new NoDbTableAnnotationException("Class not marked with DbTable Annotation!");
        }
    }
    private Field getDbId(){

        Optional<Field> fieldWithId=Arrays.stream(myClass.getDeclaredFields()).
                filter(f->f.isAnnotationPresent(DbId.class)).findAny();
        if(fieldWithId.isEmpty()){
            throw new NoDbIdAnnotationException("No field marked with DbId Annotation!");
        }else{
            return fieldWithId.get();
        }
    }

    private List<Field> getDbColumnFields(){
        Field[] fieldsOfClass=myClass.getDeclaredFields();
        return Arrays.stream(fieldsOfClass).
                filter(f->f.isAnnotationPresent(DbColumn.class)).
                collect(Collectors.toCollection(ArrayList::new));

    }

    public T save(T obj){
        connect();
        getDbId();
        StringBuilder sqlSentence=new StringBuilder("INSERT INTO ");
        StringBuilder valueSentence=new StringBuilder("(");
        sqlSentence.append(getTableName()).append(" (");

        for(Field field: getDbColumnFields()){
            field.setAccessible(true);
            sqlSentence.append(field.getName()).append(",");
            try {
                valueSentence.append("'").append(field.get(obj)).append("'").append(",");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        sqlSentence.setLength(sqlSentence.length()-1);
        valueSentence.setLength(valueSentence.length()-1);
        sqlSentence.append(") VALUES ").append(valueSentence).append(");");
        try {
            stmt.executeUpdate(sqlSentence.toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        disconnect();
        return getObjectWithId(obj);
    }

    // Задание со звездочкой
    private T getObjectWithId(T obj){
        List<T> objectsWithSameFields;
        StringBuilder sqlSentenceForId=new StringBuilder("SELECT * FROM ");
        sqlSentenceForId.append(getTableName()).append(" WHERE ");
        for(Field field: getDbColumnFields()) {
            field.setAccessible(true);
            try {
                if(field.getType().toString().equals("class java.lang.String")) {
                    sqlSentenceForId.append(field.getName()).append("=").append("'").append(field.get(obj)).append("'").append(" AND ");
                }else{
                    sqlSentenceForId.append(field.getName()).append("=").append(field.get(obj)).append(" AND ");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        sqlSentenceForId.setLength(sqlSentenceForId.length()-5);
        sqlSentenceForId.append(";");
        objectsWithSameFields=getObjectsFromDb(sqlSentenceForId.toString());

        return  objectsWithSameFields.get(objectsWithSameFields.size()-1);
    }

    public void deleteAll(){

        connect();
        StringBuilder sqlSentence=new StringBuilder("DELETE FROM ");
        sqlSentence.append(getTableName()).append(";");
        try {
            stmt.executeUpdate(sqlSentence.toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        disconnect();
    }
    public void deleteById(Long id){

        connect();
        StringBuilder sqlSentence=new StringBuilder("DELETE FROM ");
        sqlSentence.append(getTableName()).append(" WHERE ID=").append(id);
        try {
            stmt.executeUpdate(sqlSentence.toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        disconnect();
    }

    public List<T> findAll(){
        StringBuilder sqlSentence=new StringBuilder("SELECT * FROM ");
        sqlSentence.append(getTableName()).append(";");

        return getObjectsFromDb(sqlSentence.toString());
    }

    public T findById(Long id){
        StringBuilder sqlSentence=new StringBuilder("SELECT * FROM ");
        sqlSentence.append(getTableName()).append(" WHERE id=").append(id).append(";");

        return getObjectsFromDb(sqlSentence.toString()).get(0);
    }

    private List<T> getObjectsFromDb(String sqlSentence){
        connect();
        Field idField;
        List<T> resultListOfObjects=new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery(sqlSentence)) {
            while (rs.next()){
                Object currentObj=myClass.getConstructor().newInstance();
                for(Field field:getDbColumnFields()){
                    field.setAccessible(true);
                    if(field.getType().toString().equals("class java.lang.String")){
                        field.set(currentObj,rs.getString(field.getName()));
                    }else{
                        field.set(currentObj,rs.getInt(field.getName()));
                    }
                }
                idField=getDbId();
                idField.setAccessible(true);
                idField.set(currentObj,rs.getLong(idField.getName()));
                resultListOfObjects.add((T)currentObj);
            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        disconnect();
        return resultListOfObjects;
    }
}
