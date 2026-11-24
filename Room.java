package com.hotel.booking.model;
import java.math.BigDecimal;
public class Room {
 private int id; private String roomNumber,roomType,status; private BigDecimal pricePerNight;
 public Room(int id,String roomNumber,String roomType,BigDecimal pricePerNight,String status){this.id=id;this.roomNumber=roomNumber;this.roomType=roomType;this.pricePerNight=pricePerNight;this.status=status;}
 public Room(String roomNumber,String roomType,BigDecimal pricePerNight){this(0,roomNumber,roomType,pricePerNight,"AVAILABLE");}
 public int getId(){return id;} public String getRoomNumber(){return roomNumber;} public String getRoomType(){return roomType;} public BigDecimal getPricePerNight(){return pricePerNight;} public String getStatus(){return status;}
 @Override public String toString(){return "Room{id="+id+", number='"+roomNumber+"', type='"+roomType+"', price/night="+pricePerNight+", status='"+status+"'}";}
}
