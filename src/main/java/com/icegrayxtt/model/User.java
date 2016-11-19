package com.icegrayxtt.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Валерий on 14.11.2016.
 */

@Entity
@Table(name = "user")
public class User implements Serializable{

    private static final long serialVersionUID = 3121L;

    @Id
    @Column
    @GeneratedValue
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private int age;

    @Column(name = "IS_ADMIN")
    private boolean Admin;

    @Column(name = "CREATED_DATE")
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdmin() {
        return Admin;
    }

    public void setAdmin(boolean admin) {
        Admin = admin;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
