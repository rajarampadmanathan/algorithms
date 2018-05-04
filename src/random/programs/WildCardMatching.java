package random.programs;

public class WildCardMatching {

	public static void main(String[] args) {
		String s = "axycddeekm";
		String p = "a?y*******************************m";
		System.out.println(matchWildCard(s.toCharArray(), p.toCharArray()));
		System.out.println(matchWildCard("xxyz".toCharArray(), "x?y*z".toCharArray()));
	}

	private static boolean matchWildCard(char[] s, char[] p) {
		int writeIndex=0;boolean isFirst=true;
		for(char c:p) {
			if((c == '*' && isFirst)) {
				isFirst=false;
				p[writeIndex++]=c;	
			}else if(c !='*') {
				p[writeIndex++]=c;
				isFirst=true;
			}
			
		}
		System.out.println(writeIndex);
		boolean []result[] = new boolean[s.length + 1][writeIndex + 1];
		result[0][0] = true;
		if (p[0] == '*')
			result[0][1] = true;
		for (int i = 1; i <= s.length; i++) {
			for (int j = 1; j <= writeIndex; j++) {
				if (s[i - 1] == p[j - 1] || p[j - 1] == '?')
					result[i][j] = result[i - 1][j - 1];
				else if (p[j - 1] == '*')
					result[i][j] = (result[i][j - 1] || result[i - 1][j]);
			}
		}
		return result[s.length][writeIndex];
	}
}
