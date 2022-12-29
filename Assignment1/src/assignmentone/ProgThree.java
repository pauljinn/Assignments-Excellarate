package assignmentone;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Game Of Billiards.
 * @author amans
 *
 */
public class ProgThree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Number of rounds.
		int rounds = sc.nextInt();
		sc.nextLine();
		//A 2D array to store the scores of 2 players in each round.
		int[][] scores = new int[rounds][2];
		for(int i=0;i<rounds;i++) {
			//Taking input of scores of two players in each round.
			scores[i][0] = sc.nextInt();
			scores[i][1] = sc.nextInt();
		}
		int[] result = findWinnerAndLead(scores);
		System.out.println("Output");
		System.out.println(result[0] + " " + result[1]);

	}
	
	/**
	 * 
	 * @param scores
	 * @return an array of size 2 in which first element is the player number
	 * and second is the player highest lead.
	 */
	public static int[] findWinnerAndLead(int[][] scores) {
		int[] res = new int[2];
		//Looping through each round scores.
		for(int i=0;i<scores.length;i++) {
			//2 players hence only 2 scores for each round.
			for(int j=0;j<2;j++) {
				int lead = Math.abs(scores[i][0]-scores[i][1]);
				//Checking if the lead is greater than max lead.
				if(lead>res[1]) {
					int comp = Integer.compare(scores[i][0], scores[i][1]);
					if(comp==1) {
						res[0] = 1;
					}
					else {
						res[0] = 2;
					}
					res[1] = lead;
					
				}
			}
		}
		return res;
	}

}
