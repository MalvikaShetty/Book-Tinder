package com.example.booktinder.viewmodels;

/***
 Project Name: BloodBank
 Project Date: 10/12/18
 Created by: imshakil
 Email: mhshakil_ice_iu@yahoo.com
 ***/

public class PostData {

    private String location, book;
    private int phone;

    public PostData() {

    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer ph) {
        phone = ph;
    }

    public String getLoc() {
        return location;
    }

    public void setLoc(String loc) {
        location = loc;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String bk) {
        book = bk;
    }


    public String toStringg() {
        return this.book + "." + location + "-" + phone;
    }
}