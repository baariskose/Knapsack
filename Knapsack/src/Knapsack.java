import java.util.Arrays;
import java.util.Scanner;

public class Knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner scan = new Scanner(System.in);
			int geciciValue;
			int geciciAgırlık;
			int Value[] = new int[5];
		    int Weight[] = new int[5];
		    System.out.println("Maksimum taşıma kapasitesini giriniz");
	        int W = scan.nextInt();
			for (int i = 0; i < 5; i++) {
				System.out.println((i+1)+ ". Nesnenin ağırlığını giriniz.");
				geciciAgırlık=scan.nextInt();			
				System.out.println((i+1)+ ". Nesnenin değerini giriniz.");
				geciciValue = scan.nextInt();
				if(geciciAgırlık>=1 &&geciciAgırlık < W && geciciValue>=1 && geciciValue <= Math.pow(5, 2)) {
							Weight[i] = geciciAgırlık;
							Value[i] =geciciValue;
				}
				else {
					System.out.println("Kurallar Dahilinde değerler giriniz");
					i--;
				}
				
			}
			
	        int n = Value.length;
	        int bestValue = 0;
	        int bestWeight = 0;
	        int[] bestChoice= new int[] {0,0,0,0,0};
	        int A[] = new int [] {0,0,0,0,0};
	        
	        
	        for (int i = 1; i < Math.pow(2, Weight.length); i++) {
				int j = Weight.length-1;
				int tempWeight = 0;
				int tempValue = 0;
				while(A[j] != 0 && j >0) {
					A[j] =0;
					j = j -1;
				}
				A[j] = 1;
				int sayac = 1;
				int kontrolAgırlık = 0;
						for (int k = 0; k < Weight.length; k++) {
							
							if(A[k]==1) {
								tempWeight  = tempWeight+ Weight[k];
								tempValue = tempValue +Value[k];
								System.out.println("İhtimal " +(sayac) +": "+ "Value: " + tempValue + " Weight: " + tempWeight);
								sayac++;
							}
						}
						System.out.println("");
				if(tempValue > bestValue && tempWeight <= W ) {
					
					for (int m = 0 ; m< A.length ; m++)  {
						bestChoice[m] =A[m];
					}
					
					bestValue = tempValue;
					bestWeight = tempWeight;
				}
				
				
			}
	      
	        System.out.println("Alınan max değerler");
	        System.out.println("------------------------");
	        for (int i = 0; i < bestChoice.length; i++) {
				if(bestChoice[i] == 1) {
					System.out.println("Weight:"+ Weight[i] );
					System.out.println("Value:"+ Value[i] );
					System.out.println("------------------------");
				}
			}
	        System.out.println("Sonuc " + Arrays.toString(bestChoice) + "Best Value "+ bestValue);
	}
	

}
