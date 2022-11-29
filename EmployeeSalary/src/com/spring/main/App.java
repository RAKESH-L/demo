package com.spring.main;

import com.spring.model.Employee;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee e1 = new Employee(1,"Rakesh", 10000);
		double HRA, DA, TA;
		
//		System.out.println(e1);
		
//		System.out.println(e1.getId());
		
		HRA = 0.075 * e1.getBasic();
		DA = 0.09 * e1.getBasic();
		TA = 0.12 * e1.getBasic();
		
		double totalSalary;
		totalSalary = e1.getBasic() + HRA + DA + TA;
		
		System.out.println(totalSalary);

	}

}
