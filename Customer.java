package com.hotel.booking.model;
public class Customer {
 private int id; private String name, phone, email;
 public Customer(int id,String name,String phone,String email){this.id=id;this.name=name;this.phone=phone;this.email=email;}
 public Customer(String name,String phone,String email){this(0,name,phone,email);}
 public int getId(){return id;} public String getName(){return name;} public String getPhone(){return phone;} public String getEmail(){return email;}
 public void setId(int id){this.id=id;}
 @Override public String toString(){return "Customer{id="+id+", name='"+name+"', phone='"+phone+"', email='"+email+"'}";}
}
