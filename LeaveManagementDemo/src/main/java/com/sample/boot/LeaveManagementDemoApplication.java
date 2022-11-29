package com.sample.boot;

import java.awt.SystemTray;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sample.boot.entity.BalanceLeave;
import com.sample.boot.entity.Employee;
import com.sample.boot.entity.Leave;
import com.sample.boot.repository.BalanceLeaveRepository;
import com.sample.boot.repository.EmployeeRepository;
import com.sample.boot.repository.LeaveRepository;

@SpringBootApplication
public class LeaveManagementDemoApplication {

	public static void main(String[] args) {
		Employee employee = new Employee();
		BalanceLeave balanceLeave = new BalanceLeave();
		Scanner sc = new Scanner(System.in);
		ApplicationContext ctx = SpringApplication.run(LeaveManagementDemoApplication.class, args);
		
		
		System.out.println("1. Add a Employee");
		System.out.println("2. Add a Manager");
		System.out.println("3. Existing Employee");
		System.out.println("4. Existing Manager");
		System.out.println("5. Exit");
        System.out.print("Your Choice? ");
        int ch = sc.nextInt();
        
        switch(ch) {
        case 1:
        	EmployeeRepository empRepo = ctx.getBean(EmployeeRepository.class);
        	System.out.println("1. Add Employee: ");
        	System.out.println("2. List all Employees: ");
        	System.out.println("3. Exit");
            System.out.print("Your Choice? ");
            int ch1 = sc.nextInt();
            
            switch(ch1) {
            case 1:
            	System.out.println("Enter Employee Name: ");
            	String name = sc.next();
            	System.out.println("Enter Employee Email: ");
            	String email = sc.next();
            	System.out.println("Enter Employee Contact: ");
            	String contact = sc.next();
            	System.out.println("Enter Employee Data of Joining: ");
            	String doj = sc.next();
            	
            	employee.setEmpId(1);
            	employee.setEmpName(name);
            	employee.setEmail(email);
            	employee.setContact(contact);
            	employee.setDoj(doj);
            	
            	empRepo.save(employee);
            	break;
            case 2:
            	List<Employee> list = empRepo.getAllEmployee();
            	for(Employee e: list) {
            		System.out.println(e.toString());
            	}
            	break;
            case 3:
	            sc.close();
	            System.exit(0);
	        default:
	            System.out.println("Wrong choice");
            }
            break;
        case 2:
        	System.out.println("In Progress");
        	break;
        case 3:
        	System.out.println("1. Apply Leave: ");
        	System.out.println("2. Cancel Leave: ");
        	System.out.println("3. Check Leave Balence: ");
        	System.out.println("4. Exit");
            System.out.print("Your Choice? ");
            int ch2 = sc.nextInt();
            Leave leave = new Leave();
            LeaveRepository leaveRepo = ctx.getBean(LeaveRepository.class);
            
            switch(ch2) {
            case 1:
            	System.out.println("Emter start date of leave: ");
            	String start = sc.next();
            	System.out.println("Enter end date od leave: ");
            	String end = sc.next();
            	System.out.println("Enter leave Type: ");
            	String type = sc.next();
            	System.out.println("Enter No. of Days: ");
            	int no = sc.nextInt();
            	System.out.println("Enter Employee ID: ");
            	int id = sc.nextInt();
            	
            	leave.setLeaveId(1);
            	leave.setStartDate(start);
            	leave.setEndDate(end);
            	leave.setLeaveType(type);
            	leave.setEmployeeid(id);
            	
            	leaveRepo.save(leave);
            	break;
            case 2:
            	System.out.println("Enter Employee ID: ");
            	int id1 = sc.nextInt();
            	
            	Leave lc = leaveRepo.cancelLeave(id1);
            	System.out.println(lc.toString());
            	break;
            case 3:
            	BalanceLeaveRepository blRepo = ctx.getBean(BalanceLeaveRepository.class);
            	System.out.println("Enter Employee ID: ");
            	int id4 = sc.nextInt();
            	
            	BalanceLeave bbl = blRepo.getBalanceById(id4);
            	System.out.println(bbl.toString());
            	break;
            case 4:
	            sc.close();
	            System.exit(0);
	        default:
	            System.out.println("Wrong choice"); 
            }
            break;
        case 4:
        	System.out.println("1. List All Leaves: ");
        	System.out.println("2. Accept Leave: ");
        	System.out.println("3. Enter Leave balance: ");
        	System.out.println("3. Exit");
            System.out.print("Your Choice? ");
            int ch3 = sc.nextInt();
            
            switch(ch3) {
            case 1:
            	LeaveRepository leaveRepo1 = ctx.getBean(LeaveRepository.class);
                
            	List<Leave> list = leaveRepo1.getAllLeave();
            	for(Leave l: list) {
            		System.out.println(l.toString());
            	}
            	break;
            case 2:
            	System.out.println("....");
            	break;
            case 3:
            	BalanceLeaveRepository blRepo = ctx.getBean(BalanceLeaveRepository.class);
            	System.out.println("Enter Leave Balance: ");
            	int days = sc.nextInt();
            	System.out.println("Enter Employee ID: ");
            	int id2 = sc.nextInt();
            	
            	balanceLeave.setBalId(1);
            	balanceLeave.setLeavebalance(days);
            	balanceLeave.setEmpId(id2);
            	
            	blRepo.save(balanceLeave);
            	break;
            }
        }
	}

}
