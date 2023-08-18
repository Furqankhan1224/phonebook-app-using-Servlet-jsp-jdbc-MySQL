package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDao {
	private Connection conn;

	public UserDao(Connection connection) {
		super();
		this.conn=connection;
	}
     public boolean userRegister(User u) {
    	 boolean f = false;
    	 try {
    		 String sql ="insert into user2(name,email,password) values (?,?,?)";
    		 PreparedStatement prepareStatement = conn.prepareStatement(sql);
    		 prepareStatement.setString(1, u.getName());
    		 prepareStatement.setString(2, u.getEmail());
    		 prepareStatement.setString(3, u.getPassword());
    		 int i =prepareStatement.executeUpdate();
    		 if(i>0) {
    			 System.out.println("doneee");
    		 }
    	 }catch (Exception e) {
			e.printStackTrace();
		}
		return f;
     }
     public User LoginUser(String e,String p) {
    	 User user = null;
    	 try {
			String sql="select * from user2 where email=? and password=?";
			PreparedStatement prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, e);
			prepareStatement.setString(2, p);
			ResultSet executeQuery = prepareStatement.executeQuery();
			while (executeQuery.next()) {
				user =new User();
				user.setId(executeQuery.getInt(1));
				user.setName(executeQuery.getString(2));
				user.setEmail(executeQuery.getString(3));
				user.setPassword(executeQuery.getString(4));
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return user;
    	 
     }

}
