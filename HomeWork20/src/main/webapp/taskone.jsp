<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=utf-8" %>
<head>
    <meta charset="UTF-8">
    <title>TaskOne</title>
</head>
<body>

<form action="/homeworkapp/taskoneresult.html" method="get">
    <div><label> Имя пользователя : <input type="text" name="firstName"/> </label></div>
    <div><label> Фамилия пользователя : <input type="text" name="secondName"/> </label></div>
    <div><label> Отчество пользователя : <input type="text" name="patronymic"/> </label></div>
    <div><label> Дата рождения : <input type="text" name="birthday"/> </label></div>
    <div><label> Город проживания : <input type="text" name="city"/> </label></div>
    <div><input type="submit" value="Отправить данные"/></div>
</form>

</body>
</html>