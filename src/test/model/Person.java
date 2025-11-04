package com.example.scraper.model;

public class Person {
    public String name;
    public String title;
    public String position;
    public String party;
    public String address;
    public String phone;
    public String email;
    public String url;

    public Person() {}

    public Person(String name, String title, String position, String party,
                  String address, String phone, String email, String url) {
        this.name = name;
        this.title = title;
        this.position = position;
        this.party = party;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.url = url;
    }
}
