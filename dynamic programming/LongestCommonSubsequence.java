
public class LongestCommonSubsequence {

	public static int run(String s, String t) {
		if (s == null || t == null || s.length() == 0 || t.length() == 0)
			return 0;
		int[][] dp = new int[s.length() + 1][t.length() + 1];
		char[][] directions = new char[s.length() + 1][t.length() + 1];
		char cs = '0', ct = '0';
		for (int i = 1; i <= s.length(); i++)
			for (int j = 1; j <= t.length(); j++) {
				cs = s.charAt(i - 1);
				ct = t.charAt(j - 1);
				if (cs == ct) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					directions[i][j] = 'c';
				} else if (dp[i - 1][j] > dp[i][j - 1]) {
					dp[i][j] = dp[i - 1][j];
					directions[i][j] = 'u';
				} else {
					dp[i][j] = dp[i][j - 1];
					directions[i][j] = 'l';
				}
			}
		return dp[s.length()][t.length()];
	}

	public static void main(String[] args) {
		System.out.println(run("AGGTAB", "GXTXAYB"));
		System.out.println(run("ABCDGH", "AEDFHR"));

	}

}
