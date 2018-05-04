package random.programs;


public class Knapsack {
public static void main(String[] args) {
	 int val[] = {22, 20, 15, 30, 24, 54, 21, 32, 18, 25};
     int wt[] =  {4,   2, 3,   5,  5,  6,  9,  7,  8, 10};
     System.out.println(kanpsack(val,wt,30));
}

private static int kanpsack(int[] val, int[] wt, int totalWt) {
	int[][] result=new int[val.length+1][totalWt+1];
	for(int i=0;i<=val.length;i++) {
	for(int j=0;j<=totalWt;j++) {
		if(i==0 || j==0) {
			result[i][j]=0;
			continue;
		} 
		if(wt[i-1] >j) {
			result[i][j]=result[i-1][j];
		}else {
			result[i][j]=Math.max(result[i-1][j], val[i-1]+result[i-1][j-wt[i-1]]);
			
		}
	}
	}
	int i=val.length;
	int j=totalWt;
	while((i>=0 && j>=0) && result[i][j] !=0) {
		if(result[i][j] !=result[i-1][j]) {
			System.out.println("Wt: "+wt[i-1]+" Val:"+val[i-1]);
			j=j-wt[i-1];
		}	
		i--;
	}
	for(i=-1;i<=totalWt;i++)
		System.out.print(i+"\t");
	System.out.println();
	for(i=0;i<result.length;i++) {
		if(i>0)
		System.out.print(val[i-1]+"-"+wt[i-1]+"\t");
		else
			System.out.print(i+"\t");
		for(j=0;j<result[i].length;j++) {
			System.out.print(result[i][j]+"\t");
		}
		System.out.println();
	}
	return result[val.length][totalWt];
}
}
