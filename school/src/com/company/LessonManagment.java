package com.company;

import java.awt.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Scanner;
import java.io.Serializable;

public class LessonManagment implements Serializable {

    Scanner scanner;
  static HashMap <String,String>lessons=new HashMap<>();
  LessonList lessonList=new LessonList();

    public LessonManagment(Scanner scanner)  {




        this.scanner = scanner;

        menouOflesson();
        internumberforlessonmenou();
    }public void lessonlist(){
    }


    public void menouOflesson() {
        Lesson lesson=new Lesson();
        String file="E:/univer/lessonlist.txt";
        FileInputStream fileInputStream=null;
        ObjectInputStream objectInputStream=null;
try {fileInputStream=new FileInputStream(file);
    objectInputStream=new ObjectInputStream(fileInputStream);
  lessons=(HashMap<String, String>) objectInputStream.readObject();
    lessons.forEach((key, value) -> {

        System.out.println("codemelly : " + key + "  name&family:  " + value);});



}catch (Exception ex){
    ex.printStackTrace();
}






        System.out.println("1)add lesson \n2)delete lesson  \n3)edit lesson \n4)search\n5)exit ");

    }

    public void internumberforlessonmenou() {
        System.out.println("choose number :");
        int choosenumber = scanner.nextInt();
        switch (choosenumber) {
            case 1:addLesson();
                break;
            case 2:deletelesson();
                break;
            case 3:editlesson();
                break;
            case 4:searchlesson();
                break;
            case 5:new ClassManagment();
                break;
        }
    }
    public void addLesson(){
        System.out.println("Name of Lesson: ");
        String name=scanner.next();
        System.out.println("code of lesson:  ");
        String code=scanner.next();
        if(lessons.containsKey(name)){
            System.out.println("this lesson is already exist");
        }else {
            lessons.put(name, code);
            lessonList.lessonslist(lessons);
            System.out.println("add was successful");
        }

menouOflesson();
internumberforlessonmenou();
    }
    public void deletelesson(){
        System.out.println("pleas insert the name of book: ");
        String deletename=scanner.next();
       if(lessons.containsKey(deletename)){
                lessons.remove(deletename);
           lessonList.lessonslist(lessons);
                System.out.println("delete was successful");}
       else {
           System.out.println("this lesson is not exist");
       }

menouOflesson();
internumberforlessonmenou();
    }
    public void editlesson(){
        System.out.println("insert the name of book : ");
        String editname=scanner.next();
        lessons.forEach((key,value)->{
            if(key.equals(editname)){
                System.out.println("pleas insert new name: ");
                String newname=scanner.next();

              lessons.replace(newname,value);
                lessonList.lessonslist(lessons);
                System.out.println("edit was successful");
            }else {
                System.out.println("this lesson is not exist");
            }
        });menouOflesson();
        internumberforlessonmenou();



    }
    public void searchlesson(){
        System.out.println("pleas inter name of book: ");
        String searchname=scanner.next();
        lessons.forEach((key,value)->{
            if(key.equals(searchname)){
                System.out.println("name: "+key+"  code: "+value);}else {
                System.out.println("this lesson is not exist");
            }
        });
       menouOflesson();
       internumberforlessonmenou();
    }
}
