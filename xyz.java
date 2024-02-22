import java.util.InputMismatchException;
import java.util.Scanner;

public class xyz {
	public static void main(String[] args) throws ArithmeticException, InputMismatchException, ArrayIndexOutOfBoundsException, IllegalArgumentException
	{
		String employeeName, employeeDesignation, Head, CEO, Manager, AccountManager, SalesRepresentative, DepartmentName;
		int employeeId, yearsExperience, Employees, turnOver, sales, citiesTravelled;
		try
		{

			Scanner scnr = new Scanner(System.in);
			System.out.println("Enter the employee name: ");
			employeeName = scnr.next();
			System.out.println("Enter the employee ID: ");
			employeeId = scnr.nextInt();
			System.out.println("Enter the employee designation: ");
			employeeDesignation = scnr.next();
			if (employeeDesignation.equalsIgnoreCase("Head") || employeeDesignation.equalsIgnoreCase("CEO"))
			{ System.out.println("Enter the number of years of experience: ");
				yearsExperience = scnr.nextInt();

			if (yearsExperience < 5) {
				throw new ArithmeticException("Years of experience is < 5");
			}
			
			}else if (employeeDesignation.equalsIgnoreCase("Manager")) {
				System.out.println("Enter the manager's department: ");
				DepartmentName = scnr.next();
				System.out.println("Enter the number of employee's in the department: ");
				Employees = scnr.nextInt();
			
			if (Employees > 100)
			{
				throw new ArrayIndexOutOfBoundsException("number of employees > 100");
			}
			} else if (employeeDesignation.equalsIgnoreCase("AccountManager")) {
				System.out.println("Enter the yearly turn-over of the organization during the previous year: ");
				turnOver = scnr.nextInt();
			
			if (turnOver == 0) {
				throw new InputMismatchException("Turn-over of the organization during the previous fiscal year is equal to zero");
			}
			} else if (employeeDesignation.equalsIgnoreCase("SalesRepresentative")) {
				System.out.println("Enter number of sales completed for the previous month: ");
				sales = scnr.nextInt();
				System.out.println("Enter the total number of cities travelled during the previous month: ");
				citiesTravelled = scnr.nextInt();
			
			if (citiesTravelled == 0) {
				throw new IllegalArgumentException("total number of cities travelled is equal to zero");
			}
			}else {
				System.out.println("Invalid designation");
			}
		}
	
	catch (ArithmeticException e) {
		System.out.println("Exception caught: " + e);
		System.out.println("Exception message: " + e.getMessage());
	}	
	catch (InputMismatchException e) {
		System.out.println("Exception caught: " + e);
		System.out.println("Exception message: " + e.getMessage());
	}
	catch (ArrayIndexOutOfBoundsException e) {
		System.out.println("Exception caught: " + e);
		System.out.println("Exception message: " + e);
	}
	catch (IllegalArgumentException e) {
		System.out.println("Exception caught: " + e);
		System.out.println("Exception message: " + e);
	}
}
}

