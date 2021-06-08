package com.cognixia.jump.employeeDBProject;

public class Department {

    private int idCounter = 100;

    private int id;
    private String name;
    private int budget;
    private int phone;

    public int getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getBudget() { return budget; }

    public void setBudget(int budget) { this.budget = budget; }

    public int getPhone() { return phone; }

    public void setPhone(int phone) { this.phone = phone; }

    public Department(String name, int budget, int phone) {
        super();
        this.id = idCounter + 10;
        this.name = name;
        this.budget = budget;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Department{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", budget=" + budget +
                ", phone=" + phone +
                '}';
    }


}
