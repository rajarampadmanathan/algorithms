package random.programs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TowersOfHanoi {

	static int count=0;
   public void solve(int n, List<Integer> start, List<Integer> auxiliary, List<Integer> end) {
       if (n == 1) {
           end.add(start.get(start.size()-1));
           start.remove(start.size()-1);
           count+=1;
       } else {
           solve(n - 1, start, end, auxiliary);
           end.add(start.get(start.size()-1));
           start.remove(start.size()-1);
           count+=1;
           solve(n - 1, auxiliary, start, end);
       }
   }

   public static void main(String[] args) {
       TowersOfHanoi towersOfHanoi = new TowersOfHanoi();
       System.out.print("Enter number of discs: ");
       Scanner scanner = new Scanner(System.in);
       int discs = scanner.nextInt();
       ArrayList<Integer> source=new ArrayList<>(discs);
       for(int i=1;i<=discs;i++) {
    	   source.add(i);
    	   
       }
       ArrayList<Integer> dest=new ArrayList<>(discs);
       ArrayList<Integer> temp=new ArrayList<>(discs);
       towersOfHanoi.solve(discs, source, temp, dest);
       System.out.println(source);
       System.out.println(dest);
       System.out.println(temp);
       System.out.println(count);
       scanner.close();
   }
}