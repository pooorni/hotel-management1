package com.hotel.booking.model;
import java.math.BigDecimal; import java.time.LocalDate;
public class Booking {
 private int id,customerId,roomId; private LocalDate checkIn,checkOut; private BigDecimal totalAmount; private String status;
 public Booking(int id,int customerId,int roomId,LocalDate checkIn,LocalDate checkOut,BigDecimal totalAmount,String status){this.id=id;this.customerId=customerId;this.roomId=roomId;this.checkIn=checkIn;this.checkOut=checkOut;this.totalAmount=totalAmount;this.status=status;}
 public Booking(int customerId,int roomId,LocalDate checkIn,LocalDate checkOut,BigDecimal totalAmount){this(0,customerId,roomId,checkIn,checkOut,totalAmount,"CONFIRMED");}
 public int getId(){return id;} public int getCustomerId(){return customerId;} public int getRoomId(){return roomId;} public LocalDate getCheckIn(){return checkIn;} public LocalDate getCheckOut(){return checkOut;} public BigDecimal getTotalAmount(){return totalAmount;} public String getStatus(){return status;}
 @Override public String toString(){return "Booking{id="+id+", customer="+customerId+", room="+roomId+", dates="+checkIn+" to "+checkOut+", total="+totalAmount+", status="+status+"}";}
}
