package com.company;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class TeacherList implements Serializable {
    public  void teacherList(HashMap teachers){
        String file="E:/univer/teacherslist.txt";
        FileOutputStream fileOutputStream=null;
        ObjectOutputStream objectOutputStream=null;
        try {


            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(teachers);

            objectOutputStream.close();


        }catch (Exception ex){ex.printStackTrace();}

    }
}
