package com.cognixia.jump.employeeDBProject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws invalidNameException {

        System.out.println("Welcome to my EmployeeDB UI" +"\n");

        List<Department> deptList = new ArrayList<>();
        //Create departments
        Department itDept = new Department("IT-0", 3_000_000, 600_800_500);
        Department membershipDept = new Department("Membership-1", 1_000_000, 600_800_555);
        Department visitorServicesDept = new Department( "Visitor Services-2", 2_000_000, 600_800_580);
        Department securityDept = new Department( "Security-3", 3_500_000, 600_800_590);
        Department payrollDept = new Department( "Payroll-4", 500_000, 600_800_595);

        deptList.add(itDept);
        deptList.add(membershipDept);
        deptList.add(visitorServicesDept);
        deptList.add(securityDept);
        deptList.add(payrollDept);

        System.out.println("These are the departments in this company: ");

        deptList.stream().map(e -> e.getName()).forEach(System.out::println );
        System.out.println("\n"+ "Please enter employee information below: ");
        List<Employee> employees = new ArrayList<>();
        Scanner reader = new Scanner(System.in);

        //Setting up the menu
        char option = 'Y';
        String fname,lname;
        int dayReg = 0, monthReg = 0, yearReg = 0, salReg = 0;
        int dept = 0;

        while(option == 'Y'){

            System.out.println("Enter Employee's First Name: "); //check for proper name
            try {
                fname = reader.next();
            } catch (InputMismatchException e){
                throw new invalidNameException();
            }

            System.out.println("Enter Employee's Last Name: "); //check for proper last name
            try{
                lname = reader.next();
            } catch (InputMismatchException e) {
                throw new invalidNameException();
            }

            System.out.println("What year did the Employee join: "); //check for proper year
            try{
                yearReg = reader.nextInt();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("What month did the Employee join: "); //check for proper month
            try {
                monthReg = reader.nextInt();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("What day did the Employee join: "); //check for proper day
            try {
                dayReg = reader.nextInt();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Enter the Employee's Salary: "); //check for proper salary amount
            try {
                salReg = reader.nextInt();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Enter the department the Employee is working at by typing the number that's associated with the department: ");
            try {
                dept = reader.nextInt();
            } catch (Exception e) {
                e.printStackTrace();
            }


            employees.add(new Employee(fname,lname,dayReg,monthReg,yearReg,salReg, deptList.get(dept)));

            System.out.println("Employee added.");
            System.out.println("Would you like to add another employee? (Y/N): ");
            String input = reader.next(); //user might input YES,Yes, or yes
            input = input.toUpperCase(); //make it uppercase
            option = input.charAt(0); //grab the first character
        }

        employees.stream().map(e -> e.toString()).forEach(System.out::println);

        //update employee
        String up_fname,up_lname;
        int up_dayReg = 0, up_monthReg = 0, up_yearReg = 0, up_salReg = 0, idNum;
        int up_dept = 0;
        System.out.println("Update employee data..");
        char option2 = 'Y';
        while(option2 == 'Y'){
            System.out.println("Do you want to update Employee data? (Y/N): ");
            String input2 = reader.next(); //user might input YES,Yes, or yes
            input2 = input2.toUpperCase(); //make it uppercase
            option2 = input2.charAt(0);

            System.out.println("These are the current Employees : ");
            employees.stream().map(e -> " ID: " + e.getId() + " -> Name: " + e.getFirstName() + " " + e.getLastName()).forEach(System.out::println);

            System.out.println("Enter ID number associated with Employee to modify data: ");
            idNum = reader.nextInt();

            System.out.println("Update First name of " + employees.get(idNum-1).getFirstName() + " " + employees.get(idNum-1).getLastName() + " : " );
            up_fname = reader.next();
            employees.get(idNum-1).setFirstName(up_fname);

            System.out.println("Update Last name of " + employees.get(idNum-1).getFirstName() + " " + employees.get(idNum-1).getLastName() + " : " );
            up_lname = reader.next();
            employees.get(idNum-1).setLastName(up_lname);

            System.out.println("Update " + employees.get(idNum-1).getFirstName() + " " + employees.get(idNum-1).getLastName() +"'s employment date:");
            System.out.println("Year employee joined: ");
            up_yearReg = reader.nextInt();
            employees.get(idNum-1).setYearDateOfEmployment(up_yearReg);
            System.out.println("Month employee joined: ");
            up_monthReg = reader.nextInt();
            employees.get(idNum-1).setMonthDateOfEmployment(up_monthReg);
            System.out.println("Day employee joined: ");
            up_dayReg = reader.nextInt();
            employees.get(idNum-1).setDayDateOfEmployment(up_dayReg);

            System.out.println("Update " + employees.get(idNum-1).getFirstName() + " " + employees.get(idNum-1).getLastName() + "'s salary: ");
            up_salReg = reader.nextInt();
            employees.get(idNum-1).setSalary(up_salReg);

            System.out.println("Update " + employees.get(idNum-1).getFirstName() + " " + employees.get(idNum-1).getLastName() + " department: ");
            up_dept = reader.nextInt();
            employees.get(idNum-1).setDepartment(deptList.get(up_dept));


            System.out.println("Do you want to update the data of another employee? (Y/N): ");
            String input3 = reader.next();
            input3 =  input3.toUpperCase();
            option2 = input3.charAt(0);

        }
        //delete employee
        employees.stream().map(e -> e.toString()).forEach(System.out::println);


        int idDel;
        String input4;
        char option3 = 'Y';
        while(option3 == 'Y'){
            System.out.println("Do you want to delete Employees off the system? (Y/N) ");

            input4 = reader.next(); //user might input YES,Yes, or yes
            input4 = input4.toUpperCase(); //make it uppercase
            option3 = input4.charAt(0);

            employees.stream().map(e -> " ID: " + e.getId() + " -> Name: " + e.getFirstName() + " " + e.getLastName()).forEach(System.out::println);
            System.out.println("Select Employee via their associated ID number: ");
            idDel = reader.nextInt();
            employees.remove(idDel -1);
            System.out.println("Employee was removed");
            System.out.println("These are the employees that remain");

            employees.stream().map(e -> " ID: " + e.getId() + " -> Name: " + e.getFirstName() + " " + e.getLastName()).forEach(System.out::println);

        }

        System.out.println("Current list of employees");
        employees.stream().map(e -> " ID: " + e.getId() + " -> Name: " + e.getFirstName() + " " + e.getLastName()).forEach(System.out::println);

    }
}
