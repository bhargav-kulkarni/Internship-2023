package com.jdbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.model.Employee;
import com.jdbc.util.DatabaseUtil;
import com.jdbc.util.QueryUtil;


public class DatabaseService {
    DatabaseUtil databaseUtil=new DatabaseUtil();
    public void insertEmployee(Employee employee) throws SQLException
    {

        try
        {
            Connection connection=databaseUtil.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(QueryUtil.insertEmployeeQuery());
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeAddress());
            preparedStatement.setDouble(3,employee.getEmployeeSalary());
            int rows=preparedStatement.executeUpdate();
            if(rows>0)
            {
                System.out.println("Record Created successfully");
            }
            else{
                System.out.println("Record failed");

            }
        }
        catch (Exception e){System.out.println("Exception is :"+e);}

    }
    public void getAllEmployees ()throws SQLException
    {
        try(Connection connection=databaseUtil.getConnection();
            Statement statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery(QueryUtil.selectAllEmployeeQuery()))
        {
           while (resultSet.next())
           {
               printEmployee(new Employee(resultSet.getInt("Employee_ID"),
                       resultSet.getString("Employee Name:"),
                       resultSet.getString("Employee Address"),
                       resultSet.getDouble("Employee Salary:")
                 ));

           }

        }
    }
    private void printEmployee(Employee employee){
         System.out.println("Employee id "+ employee.getEmployeeId());
         System.out.println("Employee Name"+ employee.getEmployeeName());
         System.out.println("Employee Address "+ employee.getEmployeeAddress());
         System.out.println("Employee Salary"+ employee.getEmployeeAddress());
         System.out.println("------------------------------------------------");

    }
    public boolean getEmployeeById(int id) throws SQLException
    {
        boolean isFound=false;
        try(Connection connection=databaseUtil.getConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet =statement.executeQuery(QueryUtil.SelectEmployeeById(id))
        ){
           if(resultSet.next()){
               isFound=true;
               printEmployee( new Employee (resultSet.getInt("Employee_ID"),
                       resultSet.getString("Employee Name:"),
                       resultSet.getString("Employee Address"),
                       resultSet.getDouble("Employee Salary:")));

           }else{
               System.out.println("record not found For id"+id);

           }
        }
        return isFound;
    }
    public void deleteEmployeeById(int employeeId) throws SQLException
    {
        try(Connection connection=databaseUtil.getConnection();
        Statement statement=connection.createStatement())
        {
           int rows=statement.executeUpdate(QueryUtil.deleteEmployeeById(employeeId));
           if(rows>0)
           {
                System.out.println("record deleted successfully");
           }
           else{
               System.out.println("Something went wrong");
           }
        }
    }
    public void updateEmployee(Employee employee) throws SQLException
    {
        try(Connection connection=databaseUtil.getConnection();
       PreparedStatement preparedStatement= connection.prepareStatement(QueryUtil.updateEmployeeById(employee.getEmployeeId()))){
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeAddress());
            preparedStatement.setDouble(3, employee.getEmployeeSalary());
            int rows=preparedStatement.executeUpdate();
            if(rows>0){
                System.out.println("Record update successfully");
            }else{
                System.out.println("Record failed");

            }

        }
    }






}
