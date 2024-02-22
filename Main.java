import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String[] globalIdArr = {"doe5j", "johnson1d", "jones2a", "brady3t", "mahom1d"};
		String[] classArr = {"SR", "JR", "SR", "FM", "SM"};
		double[] assignOneArr = {95.2, 87.1, 66.8, 55.3, 75.4};
		double[] assignTwoArr = {91.2, 78.4, 75.1, 68.7, 77.0};
		double[] assignThreeArr = {90.2, 66.9, 88.2, 77.4, 82.3};
		
		Scanner sc = new Scanner(System.in);
		
		int option = 0;
		int totalCount, minScoreIndex, maxScoreIndex;
		double maxScore, minScore;
		boolean found;
		final int SIZE = globalIdArr.length; 
		
		
		String globalId;
		
		while (option != 5) {

			System.out.println("\n\n1) Update Class Standing");
			System.out.println("2) Total Assignments Passed");
			System.out.println("3) Best & Worst Student");
			System.out.println("4) Display Student Roster");
			System.out.println("5) Exit ");
			System.out.print("\nSelect one of the above options: ");

			option = sc.nextInt();

			System.out.println("\n");


			switch (option) {

			case 1:
				System.out.print("Global ID: ");
				globalId = sc.next();
				System.out.print("Class Standing: ");
				String classStanding = sc.next();
				found = false;

				for (int i = 0; i < SIZE; i++) {
					if (globalIdArr[i].equals(globalId)) {
						classArr[i] = classStanding;
						found = true;
						System.out.println("\n" + globalIdArr[i] + " has been successfully updated to " + classStanding);
						break;
					}
				}

				if (!found) {
					System.out.println("\nID " + globalId + " does not exist.");
				
				}
				break;
			case 2: 
				System.out.print("Global ID: ");
				globalId = sc.next();
				
				totalCount = 0;
				found = false;
				
				for (int i = 0; i < SIZE; i++) {
					if (globalIdArr[i].equals(globalId)) {
						if (assignOneArr[i] > 70) {
							totalCount++;
						}
						if (assignTwoArr[i] > 70) {
							totalCount++;
						}
						if (assignThreeArr[i] > 70) {
							totalCount++;
						}
						found = true;
						System.out.println(globalId + " passed " + totalCount + " assignments.");
					}
				}
					if (!found) {
						System.out.println("\nID " + globalId + " does not exist.");	
				}
				
	
				break;
			case 3:	
				minScore = assignOneArr[0];
				minScoreIndex = 0;
				maxScore = assignOneArr[0];
				maxScoreIndex = 0;

				for (int i = 1; i < globalIdArr.length; i++) {
					
					double overall =  (assignOneArr[i] + assignTwoArr[i] + assignThreeArr[i]) / 3;
				

					if (overall < minScore) {
						minScore = overall;
						minScoreIndex = i;
					}

					if (overall > maxScore) {
						maxScore = overall;
						maxScoreIndex = i;
					}
				}

				System.out.println("The best student is " + globalIdArr[maxScoreIndex] + " with an overall grade of " + maxScore);
				System.out.println("The worst student is " + globalIdArr[minScoreIndex] + " with an overall grade of " + minScore);

				
				break;
			case 4:
				for (int i = 0; i < SIZE; i++) {
					System.out.printf("ID: %-15s A1: %-15.2f A2: %-15.2f A3: %-15.2f Overall: %-15.2f\n", globalIdArr[i], assignOneArr[i], assignTwoArr[i], assignThreeArr[i], (assignOneArr[i] + assignTwoArr[i] + assignThreeArr[i]) / 3);
				}
				break;

			case 5:
				System.out.println("Terminated");
				break;

			default:
				System.out.println("Invalid option. Please try again.");

			}
			
			System.out.println("\n----------------------------------------------");

				
			}

	}

}
