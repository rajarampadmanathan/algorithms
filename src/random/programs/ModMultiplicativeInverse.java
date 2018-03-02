package random.programs;

public class ModMultiplicativeInverse {
	
	public static void main(String[] args) {
		int t = 0,     newt = 1, r = 120, newr = 7;
		int n=120;
	    while (newr != 0) {
	        int quotient = (r/newr);
	        t=newt;
	        r=newr;
	        newt=t - quotient * newt;
	        newr=r - quotient * newr;
	        
	    
	    
	}
	    if (t < 0 ) {t = t + n;
	    System.out.println(t);
	}
	}

}
