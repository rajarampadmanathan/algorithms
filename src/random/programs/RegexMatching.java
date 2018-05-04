package random.programs;

public class RegexMatching {

	public static void main(String[] args) {
		System.out.println(matchRegex("aaaabbbbccc".toCharArray(),"a*ab*bbbbc*".toCharArray()));
	}

	private static boolean matchRegex(char[] data, char[] regex) {
		boolean [][]result=new boolean[data.length+1][regex.length+1];
		result[0][0]=true;
		for(int i=1;i<result[0].length;i++) {
			if(regex[i-1]=='*')
				result[0][i]=result[0][i-2];
		}
		for(int i=1;i<result.length;i++) {
			for(int j=1;j<result[0].length;j++) {
				if(data[i-1]==regex[j-1] || regex[j-1] =='.')
					result[i][j]=result[i-1][j-1];
				else if(regex[j-1]=='*') {
					result[i][j]=result[i][j-2];
					if(regex[j-2]=='.' || regex[j-2]==data[i-1]) {
						result[i][j]=result[i][j] || result[i-1][j];
					}
				}
			}
		}
		return result[data.length][regex.length];
	}
}
