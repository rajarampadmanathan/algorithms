package algorithms;

import java.util.UUID;

public class TSSolver {
	
	public static void main(String[] args) {
		
		//int distance[][]=defineInput();
		for(int i=0;i<8;i++) {
		System.out.println(UUID.randomUUID().toString().replace("-", ""));
		//fcbe933c-586e-4236-b0e7-3e4ee2d122a4
		}
		
		/*for(int i=0;i<distance.length;i++) {
			for(int j=0;j<distance[i].length ;j++) {
				System.out.print(distance[i][j]+"\t");
			}
			System.out.println("\n");
		}*/
	}

	private static int[][] defineInput() {
		int [][]distance=new int[6][6];
		distance[0][0]=-1;
		distance[0][1]=35;
		distance[0][2]=30;
		distance[0][3]=30;
		distance[0][4]=37;
		distance[0][5]=35;
		distance[1][0]=25;
		distance[1][1]=-1;
		distance[1][2]=20;
		distance[1][3]=21;
		distance[1][4]=25;
		distance[1][5]=40;
		distance[2][0]=15;
		distance[2][1]=40;
		distance[2][2]=-1;
		distance[2][3]=25;
		distance[2][4]=30;
		distance[2][5]=29;
		
		distance[3][0]=30;
		distance[3][1]=35;
		distance[3][2]=25;
		distance[3][3]=-1;
		distance[3][4]=35;
		distance[3][5]=20;
		distance[4][0]=20;
		distance[4][1]=30;
		distance[4][2]=17;
		distance[4][3]=25;
		distance[4][4]=-1;
		distance[4][5]=25;
		distance[5][0]=25;
		distance[5][1]=35;
		distance[5][2]=29;
		distance[5][3]=20;
		distance[5][4]=30;
		distance[5][5]=-1;
		return distance;
	}

}
