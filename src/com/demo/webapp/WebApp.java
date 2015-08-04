package com.demo.webapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.webapp.dao.DbServices;
import com.demo.webapp.dao.TestInsert;
import com.demo.webapp.model.Employee;

@WebServlet("/WebApp")
public class WebApp extends HttpServlet {

	private String name;
	private int id;
	private String designation;
	private String location;

	public WebApp() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Into DoGet Method");
		id = Integer.parseInt(request.getParameter("id"));
		Employee employee = new Employee();
		employee.setId(id);
		DbServices dbServices = new DbServices();
		String mode = request.getParameter("mode"); 
		//String select = request.getParameter("select");
		if(mode.equalsIgnoreCase("delete")){
			response = dbServices.deleteFromDB(response, request, employee);
		}else{
			response = dbServices.getValueFromDB(response, request,employee);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Into DoPost Method");
		name = request.getParameter("name");
		id = Integer.parseInt(request.getParameter("id"));
		designation = request.getParameter("designation");
		location = request.getParameter("location");
		Employee employee = new Employee(name, id, designation, location);
		DbServices dbServices = new DbServices();
		response = dbServices.insertIntoDB(response, request, employee);
	}

}
