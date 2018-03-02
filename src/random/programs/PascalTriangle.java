package random.programs;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class PascalTriangle {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		System.out.print("Number of Objects:");
		while(true) {
			int count=sc.nextInt();
		System.out.println();
		System.out.print("Number of pickets objects:");
		int picked=sc.nextInt();
		int[][] pascalTriangle=buildPascalTriangle(count);
		for(int i=0;i<pascalTriangle.length;i++) {
			for(int j=0;j<pascalTriangle[i].length;j++) {
				System.out.print(pascalTriangle[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println(pascalTriangle[count][picked]);
	}
	}

	private static int[][] buildPascalTriangle(int count) {
		// TODO Auto-generated method stub
		int[][] pascal=new int[count+1][count+1];
		for(int i=0;i<=count;i++) {
			for(int j=0;j<=i;j++) {
					if(i==j  || j==0) {
						//"i:"+i+" j:"+j +" ->"+
			//			System.out.print(1 +"\t");
						pascal[i][j]=1;
					}else {
						pascal[i][j]=pascal[i-1][j-1]+pascal[i-1][j];
				//		System.out.print((pascal[i-1][j-1]+pascal[i-1][j]) +"\t");
					}
			}
			System.out.println();
		}
		return pascal;
	}
}
