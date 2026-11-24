package com.hotel.booking.dao;
import com.hotel.booking.config.DBConnection; import com.hotel.booking.model.Customer; import java.sql.*; import java.util.*;
public class CustomerDAO {
 public Customer add(Customer c)throws SQLException {String q="INSERT INTO customers(name,phone,email) VALUES(?,?,?)";try(Connection con=DBConnection.getConnection();PreparedStatement p=con.prepareStatement(q,Statement.RETURN_GENERATED_KEYS)){p.setString(1,c.getName());p.setString(2,c.getPhone());p.setString(3,c.getEmail());p.executeUpdate();try(ResultSet k=p.getGeneratedKeys()){if(k.next())c.setId(k.getInt(1));}return c;}}
 public List<Customer> all()throws SQLException {List<Customer> out=new ArrayList<>();try(Connection c=DBConnection.getConnection();Statement s=c.createStatement();ResultSet r=s.executeQuery("SELECT * FROM customers ORDER BY id")){while(r.next())out.add(map(r));}return out;}
 public List<Customer> search(String term)throws SQLException {List<Customer> out=new ArrayList<>();try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement("SELECT * FROM customers WHERE name LIKE ? OR phone LIKE ? ORDER BY id")){p.setString(1,"%"+term+"%");p.setString(2,"%"+term+"%");try(ResultSet r=p.executeQuery()){while(r.next())out.add(map(r));}}return out;}
 private Customer map(ResultSet r)throws SQLException{return new Customer(r.getInt("id"),r.getString("name"),r.getString("phone"),r.getString("email"));}
}
