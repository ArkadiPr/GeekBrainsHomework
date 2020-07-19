package com.kostandov.geekbrains.homework14.main;

import com.kostandov.geekbrains.homework14.exception.MyFileException;

import java.io.*;

public class Main {

    public static String readFile(File file){
        StringBuilder text=new StringBuilder("");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String str;
            while ((str = reader.readLine()) != null) {
                text.append(str);
            }
        } catch (IOException ioException) {
            throw new MyFileException("Please check if file is correct and exist!");
        }
        return text.toString();
    }

    public static int countWordInFile(File file, String word){
        int count=0;
        String text=readFile(file);
        int lastIndex = 0;

        while(lastIndex != -1){

            lastIndex = text.indexOf(word,lastIndex);

            if(lastIndex != -1){
                count ++;
                lastIndex += word.length();
            }
        }
        return count;
    }

    public static File mergeAllFilesInDirectory(File directory) throws IOException {

        File file=new File("output.txt");

        PrintWriter pw = new PrintWriter(file);

        String[] fileNames = directory.list();
        if(directory.isFile()){
            return file;
        }

        for (String fileName : fileNames) {

            File f = new File(directory, fileName);
            if(f.isDirectory()){
                continue;
            }

            BufferedReader br = new BufferedReader(new FileReader(f));

            pw.println("Contents of file " + fileName);

            String line = br.readLine();
            while (line != null) {

                pw.println(line);
                line = br.readLine();
            }
            pw.flush();
        }
        return file;
    }

    public static void deleteFolder(File file){
        if(!file.exists()){
            return;
        }
        for (File subFile : file.listFiles()) {
            if(subFile.isDirectory()) {
                deleteFolder(subFile);
            } else {
                subFile.delete();
            }
        }
        file.delete();
    }

    public static void main(String[] args) {

        File file=new File("test.txt");
        String word="been";
        System.out.println(countWordInFile(file,word));

        try {
            mergeAllFilesInDirectory(new File("C:/IntellijIdea Projects/GeekBrains Homeworks/HomeWork14/TestDirectory"));
        } catch (IOException ioException) {
            throw new MyFileException("Check if the directory and output file are valid.");
        }

        deleteFolder(new File("C:/IntellijIdea Projects/GeekBrains Homeworks/HomeWork14/TestDirectory2"));

    }
}
