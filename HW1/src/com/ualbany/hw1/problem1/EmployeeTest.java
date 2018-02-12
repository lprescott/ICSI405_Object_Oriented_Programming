package com.ualbany.hw1.problem1;

/**
 * @author Luke R. Prescott
 * Student ID: 001252879
 * 
 * Start Date: Feb 11, 2018
 *
 * Project Name: HW1
 * Package Name: com.ualbany.hw1.problem1
 * 
 * This class is the driver to test the Employee object and its methods for accuracy by the below procedure.
 * 	Created two Employee objects and displayed the yearly salary for each Employee.
 * 	Give each Employee a 10% raise and display each Employee’s yearly salary again:
 * 
 * The output is as follows (dashes not included):
 * ----------------------------------------------------
 * 	The yearly salary for Luke Prescott is: $30001.20.
 *  The yearly salary for Jane Doe is: $39011.40.
 * 
 *  After each Employee received a 10% raise: 
 *  The yearly salary for Luke Prescott is: $33001.32.
 *  The yearly salary for Jane Doe is: $42912.54.
 * ----------------------------------------------------
 */
public class EmployeeTest {

	/**
	 * @param args none accepted
	 */
	public static void main(String[] args) {
		//Create two Employee objects and display the yearly salary for each Employee:
		Employee employee1 = new Employee("Luke", "Prescott", 2500.10);
		Employee employee2 = new Employee("Jane", "Doe", 3250.95);
		
		System.out.println(employee1.toString());
		System.out.println(employee2.toString());

		//Give each Employee a 10% raise and display each Employee’s yearly salary again:
		employee1.giveRaise(.10);
		employee2.giveRaise(.10);

		System.out.println("\nAfter each Employee received a 10% raise: ");
		
		System.out.println(employee1.toString());
		System.out.println(employee2.toString());

	}

}
