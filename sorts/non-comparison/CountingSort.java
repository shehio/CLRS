import java.util.Arrays;

public class CountingSort {

	public static int[] countingSort(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		int max = 0;
		for (int i = 0; i < nums.length; i++)
			max = Math.max(max, nums[i]);
		int[] counts = new int[max + 1];
		for (int i = 0; i < nums.length; i++)
			counts[nums[i]]++;
		for (int i = 1; i < counts.length; i++)
			counts[i] += counts[i - 1];
		int[] ret = new int[nums.length];
		for (int i = nums.length - 1; i >= 0; i--)
			ret[--counts[nums[i]]] = nums[i];
		return ret;
	}

	public static void main(String[] args) {
		// sorted
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(Arrays.toString(nums));
		nums = countingSort(nums);
		System.out.println(Arrays.toString(nums));

		System.out.println();

		// random
		nums = new int[] { 2, 3, 1, 5, 8, 7, 9, 4, 6 };
		System.out.println(Arrays.toString(nums));
		nums = countingSort(nums);
		System.out.println(Arrays.toString(nums));

		System.out.println();

		// reversed
		nums = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println(Arrays.toString(nums));
		nums = countingSort(nums);
		System.out.println(Arrays.toString(nums));
	}

}
