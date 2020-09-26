package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.io.Serializable;

public class LessonList implements Serializable {
        Scanner scanner;

public static void lessonslist(HashMap lessons){
        String file="E:/univer/lessonlist.txt";
        FileOutputStream fileOutputStream=null;
        ObjectOutputStream objectOutputStream=null;
        try {


                 fileOutputStream = new FileOutputStream(file);
                 objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(lessons);

                objectOutputStream.close();


        }catch (Exception ex){ex.printStackTrace();}

}



}
