package com.company;

import java.util.Scanner;

public class ClassManagment {
    public ClassManagment()

    {
        Scanner scanner = new Scanner(System.in);


        menouOfSchool();
        System.out.println("pleas inter your number : ");
        int choosenumberformenou = scanner.nextInt();
        switch (choosenumberformenou) {
            case 1:
                new TeacherManagment(scanner);
                break;
            case 2:
                new StudentManagment(scanner);
                break;
            case 3:
                new LessonManagment(scanner);
                break;
        }

    }

    public void menouOfSchool() {
        System.out.println("1)Teacher Management\n2)Student Management \n3)Lesson Management ");
    }
}


