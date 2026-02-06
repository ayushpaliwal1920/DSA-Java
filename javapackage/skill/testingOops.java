package javapackage.skill;

import Oops.Oops_01.Student;

// Accessing class in different package : need import statment to access file 

public class testingOops {
    public static void main(String[] args) {
        
        Student s1 = new Student();

        s1.name = "Abhimanyu";

        System.out.println(s1.name);

    }
}
