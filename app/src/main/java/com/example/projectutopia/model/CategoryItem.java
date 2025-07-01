package com.example.projectutopia.model;

public class CategoryItem {
    private String name;
    private String address;
    private String contact;
    private String schedule;

    public CategoryItem(String name, String address, String contact, String schedule){
        this.name =  name;
        this.address = address;
        this.schedule = schedule;
        this.contact = contact;

    }

    public String getName() {return name;}
    public String getAddress() {return  address;}
    public String getContact() {return contact;}
    public String getSchedule() {return schedule;}

}
