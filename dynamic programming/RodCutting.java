import java.util.Arrays;

public class RodCutting {
	public static int run(int[] prices) {
		int[] dp = new int[prices.length + 1];
		int[] cuts = new int[prices.length + 1];
		int index = 0;
		dp[0] = 0;
		for (int i = 1; i < dp.length; i++) {
			dp[i] = prices[i - 1];
			index = i;
			for (int j = i - 1; j >= i / 2; j--) {
				if (dp[j] + dp[i - j] > dp[i]) {
					index = j;
					dp[i] = dp[j] + dp[i - j];
				}
			}
			cuts[i] = (index == i) ? 0 : cuts[index] + 1;
		}
		return dp[cuts.length - 1]; // or number of cuts if you want to.

	}

	public static void main(String[] args) {
		int prices[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
		System.out.println(run(prices));
	}

}
