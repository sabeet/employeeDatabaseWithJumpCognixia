package com.cognixia.jump.employeeDBProject;

public class Employee {

    private static int idCounter = 1;

    private int id;
    private String firstName;
    private String lastName;

    private int monthDateOfEmployment;
    private int dayDateOfEmployment;
    private int yearDateOfEmployment;

    private int salary;
    private Department department;

    public Employee(String firstName, String lastName, int monthDateOfEmployment, int dayDateOfEmployment, int yearDateOfEmployment, int salary, Department department) {
        super();
        this.id = idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthDateOfEmployment = monthDateOfEmployment;
        this.dayDateOfEmployment = dayDateOfEmployment;
        this.yearDateOfEmployment = yearDateOfEmployment;
        this.salary = salary;
        this.department = department;
    }

    public int getId() { return id; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getMonthDateOfEmployment() { return monthDateOfEmployment; }

    public void setMonthDateOfEmployment(int monthDateOfEmployment) { this.monthDateOfEmployment = monthDateOfEmployment; }

    public int getDayDateOfEmployment() { return dayDateOfEmployment; }

    public void setDayDateOfEmployment(int dayDateOfEmployment) { this.dayDateOfEmployment = dayDateOfEmployment; }

    public int getYearDateOfEmployment() { return yearDateOfEmployment; }

    public void setYearDateOfEmployment(int yearDateOfEmployment) { this.yearDateOfEmployment = yearDateOfEmployment; }

    public int getSalary() { return salary; }

    public void setSalary(int salary) { this.salary = salary; }

    public Department getDepartment() { return department; }

    public void setDepartment(Department department) { this.department = department; }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfEmployment=" + monthDateOfEmployment + "/" + dayDateOfEmployment + "/" + yearDateOfEmployment +
                ", salary=" + salary +
                ", department=" + department.getName() +
                '}';
    }
}
