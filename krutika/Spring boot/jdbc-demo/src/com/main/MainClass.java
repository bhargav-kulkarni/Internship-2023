package com.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.jdbc.model.Employee;
import com.jdbc.service.DatabaseService;

public class MainClass {
    public static void main(String[] args)
    {
        DatabaseService databaseservice=new DatabaseService();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            boolean isRunning = true;
            while (isRunning)
            {
                System.out.println("Enter Choice");
                System.out.println("1.Insert");
                System.out.println("2.Select All");
                System.out.println("3.Select by employeeId");
                System.out.println("4.Delete employee");
                System.out.println("5.update employee");
                System.out.println("6.exit");
                int choice = Integer.parseInt(br.readLine());
                switch (choice)
                {
                    case 1:
                        System.out.println("Employee name, address, salary");
                        System.out.println("\nEnter name of employee\n");
                        String name = br.readLine();
                        System.out.println("\nEnter address of employee\n");
                        String address = br.readLine();
                        System.out.println("\nEnter salary of employee\n");
                        double salary = Double.parseDouble(br.readLine());
                        databaseservice.insertEmployee(new Employee(name,address,salary));
                        break;
                    case 2:
                        databaseservice.getAllEmployees();
                        System.out. println(choice);

                        break;
                    case 3:
                        System.out.println("Enter Employee by id:");
                        databaseservice.getEmployeeById(Integer.parseInt(br.readLine()));
                        break;
                    case 4:
                        System.out.println("Enter Employee by id:");
                        databaseservice.deleteEmployeeById(Integer.parseInt(br.readLine()));
                        break;
                    case 5:
                        System.out.println("Enter Employee by id:");
                        int updateId=Integer.parseInt(br.readLine());
                        boolean isFound=databaseservice.getEmployeeById(updateId);
                        if(isFound){
                            System.out.println("Enter name,address,salary");
                            Employee employee=new Employee(updateId,br.readLine(),br.readLine(),Double.parseDouble(br.readLine()));
                            databaseservice.updateEmployee(employee);
                        }
                        break;

                    case 6:
                        isRunning = false;
                        break;
                    default:
                        System.out.println("incorrect choice");
                        break;
                }
            }
        }catch(Exception e)
        {
            throw new RuntimeException("Something went wrong");
        }
    }

}
