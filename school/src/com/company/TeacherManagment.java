package com.company;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TeacherManagment implements Serializable {
    TeacherList teacherList=new TeacherList();
    Scanner scanner;
    static HashMap teachers=new HashMap();

    public TeacherManagment(Scanner scanner) {
        this.scanner = scanner;

        menouOfteacher();
        internumberforteacherlist();

    }

    public void menouOfteacher() {
        String file="E:/univer/teacherslist.txt";
        FileInputStream fileInputStream=null;
        ObjectInputStream objectInputStream=null;
        try {
            fileInputStream=new FileInputStream(file);
            objectInputStream=new ObjectInputStream(fileInputStream);
            teachers=(HashMap<String, String>) objectInputStream.readObject();

            teachers.forEach((key, value) -> {

                System.out.println("codemelly : " + key + "  name&family:  " + value);});


        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("1)add teacher \n2)delete teacher  \n3)edit teacher \n4)search \n5)exit ");
    }

    public void internumberforteacherlist() {
        System.out.println("inter your choose number :");
        int choosenumber = scanner.nextInt();
        switch (choosenumber) {
            case 1:addteacher();
                break;
            case 2:deleteteacher();
                break;
            case 3:editteacher();
                break;
            case 4:searchteacher();
                new ClassManagment();
                break;
            case 5:new ClassManagment();
                break;
        }
    }
    public void addteacher() {
        System.out.println("name :");
        String name = scanner.next();
        System.out.println("family :");
        String family = scanner.next();
        System.out.println("codemelly  :");
        String codemelly = scanner.next();


        if(teachers.containsKey(codemelly)){
            System.out.println("this teacher is already exist ");
        }else {
            teachers.put(codemelly, name + " " + family);
            teacherList.teacherList(teachers);
            System.out.println("add was success");
        }


        menouOfteacher();
       internumberforteacherlist();

    }

    public void deleteteacher() {
        System.out.println("pleas inter codemelly of teacher: ");
        String deletecodemelly = scanner.next();
        if(teachers.containsKey(deletecodemelly)) {
            teachers.remove(deletecodemelly);
teacherList.teacherList(teachers);
            System.out.println("delete was successful");
        }else {
            System.out.println("this teacher is not exist ");
        }



        menouOfteacher();
        internumberforteacherlist();
    }

    public void editteacher() {
        System.out.println("pleas inter codemelly of student :");
        String editcodemelly = scanner.next();
        teachers.forEach((key, value) -> {
            if (key.equals(editcodemelly)) {
                System.out.println("pleas inter new name: ");
                String newname = scanner.next();
                System.out.println("pleas inter new family: ");
                String newfamily = scanner.next();
                teachers.replace(editcodemelly, value, newname + " " + newfamily);
                teacherList.teacherList(teachers);
                System.out.println("edit was successful");
            }else {
                System.out.println("this student is not exist ");
            }

        });
        menouOfteacher();
        internumberforteacherlist();
    }

    public void searchteacher() {
        System.out.println("pleas inter codemelly of student: ");
        String searchcodemelly = scanner.next();
        teachers.forEach((key, value) -> {
            if (key.equals(searchcodemelly))
                System.out.println("codemelly : " + key + "  name&family:  " + value);
            else {
                System.out.println("this student is not exist ");
            }
        });
        menouOfteacher();
        internumberforteacherlist();
    }
}

