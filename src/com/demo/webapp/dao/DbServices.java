package com.demo.webapp.dao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.webapp.model.Employee;

public class DbServices {

	public HttpServletResponse getValueFromDB(HttpServletResponse response,
			HttpServletRequest request, Employee employee) {
		TestInsert testInsert = new TestInsert();
		try {
			testInsert.selectFromTableUsingId(employee);
		} catch (SQLException e) {
			System.out.println("Insertion Failed");
		}

		try {
			if (employee.getName() != null && employee.getDesignation() != null && employee.getLocation() != null){
			response.getWriter().print("<h1>Name : " + employee.getName() + " </h1>");
			response.getWriter().print("<h1>ID   : " + employee.getId() + "</h1>");
			response.getWriter().print("<h1>Designation : " + employee.getDesignation() + "</h1>");
			response.getWriter().print("<h1>Location : " + employee.getLocation() + "</h1>");
			}else{
					response.getWriter().print("<h1>Kindly check your ID</h1>");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;

	}
	
	public HttpServletResponse insertIntoDB(HttpServletResponse response, HttpServletRequest request, Employee employee){
				
		try {
			TestInsert testInsert = new TestInsert();
			testInsert.insertIntoDo(employee);
		} catch (SQLException e) {
			System.out.println("Insertion Failed");
		}

		try {
			if (employee.getName() != null && employee.getDesignation() != null && employee.getLocation() != null && employee.getId()!=0){
				response.getWriter().print("<h1>Name : " + employee.getName() + " </h1>");
				response.getWriter().print("<h1>ID   : " + employee.getId() + "</h1>");
				response.getWriter().print("<h1>Designation : " + employee.getDesignation() + "</h1>");
				response.getWriter().print("<h1>Location : " + employee.getLocation() + "</h1>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
		
	}
	
	public HttpServletResponse deleteFromDB(HttpServletResponse response, HttpServletRequest request, Employee employee){
		
		TestInsert testInsert = new TestInsert();
		try {
			testInsert.deletFromTableUsingId(employee);
		} catch (SQLException e) {
			System.out.println("Deletion Failed");
		}

		try {
			if (employee.getName() != null && employee.getDesignation() != null && employee.getLocation() != null){
			
				response.getWriter().print("<h1>Name : " + employee.getName() + " </h1>");
				response.getWriter().print("<h1>ID   : " + employee.getId() + "</h1>");
				response.getWriter().print("<h1>Designation : " + employee.getDesignation() + "</h1>");
				response.getWriter().print("<h1>Location : " + employee.getLocation() + "</h1>");
			}else{
			
				response.getWriter().print("<h1>Kindly check your ID</h1>");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}
	

}
