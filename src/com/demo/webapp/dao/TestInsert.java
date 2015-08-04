package com.demo.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.demo.webapp.model.Employee;

public class TestInsert {

	Connection connection;
	PreparedStatement preparedStatement;
	Statement statement;
	ResultSet resultSet;

	public void insertIntoDo(Employee employee) throws SQLException {
		connection = DBConnection.getConnection();
		statement = connection.createStatement();
		// SQL query to insert a row in table with the specified values
		String query = "insert into EMPLOYEE (name,id,designation,location) values (?,?,?,?)";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, employee.getName());
		preparedStatement.setInt(2, employee.getId());
		preparedStatement.setString(3, employee.getDesignation());
		preparedStatement.setString(4, employee.getLocation());
		int rslt = preparedStatement.executeUpdate();
		connection.close();
	}

	public void selectFromTableUsingId(Employee employee) throws SQLException {
		connection = DBConnection.getConnection();
		int id = employee.getId();
		String query = "select * FROM EMPLOYEE WHERE id = ?";
		//statement = connection.createStatement();
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()){
			employee.setName(resultSet.getString("name"));
			employee.setId(resultSet.getInt("id"));
			employee.setDesignation(resultSet.getString("designation"));
			employee.setLocation(resultSet.getString("location"));
		}
		connection.close();
	}

	public void deletFromTableUsingId(Employee employee) throws SQLException {
		
		connection = DBConnection.getConnection();
		int id = employee.getId();
		String deleteSQL = "DELETE employee WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
		preparedStatement.setInt(1, id);
		// execute delete SQL stetement
		preparedStatement.executeUpdate();
		
	}
}
