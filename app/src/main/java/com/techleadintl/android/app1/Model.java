package com.techleadintl.android.app1;

public class Model {

    String email,name,age,note;


    public Model(String email, String name, String age, String note) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Model{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
