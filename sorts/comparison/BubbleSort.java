import java.util.Arrays;

public class BubbleSort {
	public static void bubbleSort(int[] nums) {
		if (nums == null || nums.length == 0)
			return;
		for (int i = 0; i < nums.length; i++)
			for (int j = nums.length - 1; j > i; j--)
				if (nums[j] < nums[j - 1])
					swap(nums, j, j - 1);
	}

	public static void swap(int[] nums, int i, int j) {
		if (i == j)
			return;
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		// sorted
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(Arrays.toString(nums));
		bubbleSort(nums);
		System.out.println(Arrays.toString(nums));

		System.out.println();

		// random
		nums = new int[] { 2, 3, 1, 5, 8, 7, 9, 4, 6 };
		System.out.println(Arrays.toString(nums));
		bubbleSort(nums);
		System.out.println(Arrays.toString(nums));

		System.out.println();

		// reversed
		nums = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println(Arrays.toString(nums));
		bubbleSort(nums);
		System.out.println(Arrays.toString(nums));

	}

}
