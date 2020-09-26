package com.company;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StudentManagment implements Serializable {
    StudentList studentList=new StudentList();
    Scanner scanner;
    static HashMap students = new HashMap();

    public StudentManagment(Scanner scanner) {
        this.scanner = scanner;

        menouOfstudent();
        internumberforstudentmenou();
    }

    public void menouOfstudent() {
        String file="E:/univer/studentlist.txt";
        FileInputStream fileInputStream=null;
        ObjectInputStream objectInputStream=null;
        try {
            fileInputStream=new FileInputStream(file);
            objectInputStream=new ObjectInputStream(fileInputStream);
            students=(HashMap<String, String>) objectInputStream.readObject();

            students.forEach((key, value) -> {

                    System.out.println("codemelly : " + key + "  name&family:  " + value);});


        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("1)add student \n2)delete student  \n3)edit student \n4)search \n5)exit ");
    }

    public void internumberforstudentmenou() {
        System.out.println("choose number : ");
        int choosenumber = scanner.nextInt();
        switch (choosenumber) {
            case 1:
                addstudent();
                break;
            case 2:
                deletestudent();
                break;
            case 3:
                editstudent();
                break;
            case 4:
                searchstudent();

                break;
            case 5:
                new ClassManagment();
                break;
        }
    }

    public void addstudent() {
        System.out.println("name :");
        String name = scanner.next();
        System.out.println("family :");
        String family = scanner.next();
        System.out.println("codemelly  :");
        String codemelly = scanner.next();


if(students.containsKey(codemelly)){


    System.out.println("this student is already exist ");
}else {
    students.put(codemelly, name + " " + family);
    System.out.println("add was success");
    studentList.studentList(students);
}


        menouOfstudent();
        internumberforstudentmenou();

    }

    public void deletestudent() {
        System.out.println("pleas inter codemelly of student: ");
        String deletecodemelly = scanner.next();
if(students.containsKey(deletecodemelly)) {
    students.remove(deletecodemelly);
studentList.studentList(students);
    System.out.println("delete was successful");
}else {
    System.out.println("this student is not exist ");
}



        menouOfstudent();
        internumberforstudentmenou();
    }

    public void editstudent() {
        System.out.println("pleas inter codemelly of student :");
        String editcodemelly = scanner.next();
        students.forEach((key, value) -> {
            if (key.equals(editcodemelly)) {
                System.out.println("pleas inter new name: ");
                String newname = scanner.next();
                System.out.println("pleas inter new family: ");
                String newfamily = scanner.next();
                students.replace(editcodemelly, value, newname + " " + newfamily);
                studentList.studentList(students);
                System.out.println("edit was successful");
            }else {
                System.out.println("this student is not exist ");
            }

        });
        menouOfstudent();
        internumberforstudentmenou();
    }

    public void searchstudent() {
        System.out.println("pleas inter codemelly of student: ");
        String searchcodemelly = scanner.next();
        students.forEach((key, value) -> {
            if (key.equals(searchcodemelly))
                System.out.println("codemelly : " + key + "  name&family:  " + value);
else {
                System.out.println("this student is not exist ");
            }
        });
        menouOfstudent();
        internumberforstudentmenou();
    }
}
