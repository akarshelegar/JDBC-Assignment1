package com.techpalle.jdbcassignment;

import java.sql.*;

public class MyProgram {

	public static void main(String[] args) {
		A a1 = new A();
		a1.create();
		a1.insert("Sudeep", 400000);
		a1.insert("Akarsh", 500000);
		a1.insert("Sandeep", 500000);

	}

}
class A
{
	private Connection cn = null;
	private Statement stm = null;
	
	private final String dbUrl = "jdbc:mysql://localhost:3306/palle";
	private final String dbUsername = "root";
	private final String dbPassword = "7259";
	
	private  String createQuery = ("create table employee(eid int primary key auto_increment, ename varchar(20) not null, esalary int)");
	
	public void create()
	{
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			cn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			
			stm = cn.createStatement();
			
			 //final String createQuery = ("create table employee(eid int primary key, ename varchar(20) not null, esalary int)");
			stm.executeUpdate(createQuery);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			if(stm!=null)
			{
				try {
					stm.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if(cn!=null)
			{
				try {
					cn.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			}
		}
	}
	
	public void insert(String ename, int esalary )
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			cn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			
			stm = cn.createStatement();
			
			String qry = ("insert into employee(ename, esalary) values('"+ename+"', "+esalary+")");
			stm.executeUpdate(qry);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch(SQLException e)
		{
			e.printStackTrace();
		} finally {
			if(stm!=null)
			{
				try {
					stm.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if(cn!=null)
			{
				try {
					cn.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			}
		}
		
	}
}
