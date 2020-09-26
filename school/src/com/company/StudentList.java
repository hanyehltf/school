package com.company;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class StudentList implements Serializable {
    public  void studentList(HashMap students){
        String file="E:/univer/studentlist.txt";
        FileOutputStream fileOutputStream=null;
        ObjectOutputStream objectOutputStream=null;
        try {


            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(students);

            objectOutputStream.close();


        }catch (Exception ex){ex.printStackTrace();}

    }
}
