package com.example.firebasedatabaseexample;

public class employee {

    String ename;
    String eid;
    String eSalary;

    public employee() {
    }

    public employee(String ename, String eid, String eSalary) {
        this.ename = ename;
        this.eid = eid;
        this.eSalary = eSalary;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String geteSalary() {
        return eSalary;
    }

    public void seteSalary(String eSalary) {
        this.eSalary = eSalary;
    }
}
