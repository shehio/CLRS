import java.util.Arrays;
import java.util.Collections;

public class fractionalKnapSack {
	public static class Pair {
		double price, weight;

		public Pair(double price, double weight) {
			this.price = price;
			this.weight = weight;
		}
	}

	public static double run(double[] prices, double[] weights, double bag) {
		if (prices == null || weights == null || prices.length != weights.length)
			return 0;
		double ret = 0;
		Pair[] pairs = new Pair[prices.length];
		for (int i = 0; i < prices.length; i++)
			pairs[i] = new Pair(prices[i], weights[i]);
		Arrays.sort(pairs, (p1, p2) -> (int) (p2.price / p2.weight - p1.price / p1.weight));
		int j = 0;
		while (bag > 0) {
			if (bag > pairs[j].weight) {
				ret += pairs[j].price;
				bag -= pairs[j].weight;
			} else {
				ret += bag * pairs[j].price / pairs[j].weight;
				bag = 0;
			}
			j++;
		}
		return ret;
	}

	public static void main(String[] args) {

		double bag = 20;
		double[] prices = new double[] { 25, 24, 15 }; // price as a whole!
		double[] weights = new double[] { 18, 15, 10 };
		System.out.println(run(prices, weights, bag));
	}

}
