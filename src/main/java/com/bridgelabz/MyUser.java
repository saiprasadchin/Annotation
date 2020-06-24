package com.bridgelabz;

public class MyUser {
    private String name;
    private String email;
    private String phoneNo;
    private String country;
    public MyUser() {

    }
    public MyUser(String name, String email, String phoneNo, String country) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.country = country;
    }
    public String toString(){
        return this.name+" "+this.email+" "+this.phoneNo+" "+this.country;
    }
}
