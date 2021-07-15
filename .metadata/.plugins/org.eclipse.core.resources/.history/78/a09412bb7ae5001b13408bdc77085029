package com.vti.entity;

import java.time.LocalDate;

public class Account {
    int AccountID;
    public String Email;
    public String Username;
    public String FullName;
    public Department Department;
    public Position Position;
    public LocalDate CreateDate;
    public Group[] groups;

    public Account(){
        super();
    }

    public Account(int accountID, String email, String username, String fullName, com.vti.entity.Department department, com.vti.entity.Position position, LocalDate createDate, Group[] groups) {
        AccountID = accountID;
        Email = email;
        Username = username;
        FullName = fullName;
        Department = department;
        Position = position;
        CreateDate = createDate;
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Account{" +
                "AccountID=" + AccountID +
                ", Email='" + Email + '\'' +
                ", Username='" + Username + '\'' +
                ", FullName='" + FullName + '\'' +
                '}';
    }
}
