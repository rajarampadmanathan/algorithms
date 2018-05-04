package random.programs;

public class CoinTower {
	public static void main(String[] args) {
	System.out.println("Tower Height of 12 coins:"+coinTomer(12));
	System.out.println("Tower Height of 0 coins:"+coinTomer(0));
	System.out.println("Tower Height of 1 coins:"+coinTomer(1));
	System.out.println("Tower Height of 3 coins:"+coinTomer(3));
	System.out.println("Tower Height of 6 coins:"+coinTomer(6));
	System.out.println("Tower Height of 14 coins:"+coinTomer(14));
	System.out.println("Tower Height of 15 coins:"+coinTomer(15));
	System.out.println("Tower Height of 16 coins:"+coinTomer(16));
	System.out.println("Tower Height of 17 coins:"+coinTomer(17));
	System.out.println("Tower Height of 18 coins:"+coinTomer(18));
	System.out.println("Tower Height of 19 coins:"+coinTomer(19));
	System.out.println("Tower Height of 20 coins:"+coinTomer(20));
	System.out.println("Tower Height of 21 coins:"+coinTomer(21));
	}
	
	public static long coinTomer(int n) {
		//System.out.println(SquareRoot.babylonian(1+(8* n)));
		return (long) (-1f +(SquareRoot.babylonian(1+(8* n))* 1.00001))/2;
	}
}
