package com.cognixia.jump.employeeDBProject;

public class invalidDepartmentNumException extends Exception{
    invalidDepartmentNumException(){
        System.out.println("Please enter the correct department number");
    }
}
