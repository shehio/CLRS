import java.util.Arrays;

public class SelectionSort {

	public static void selectionSort(int[] nums) {
		if (nums == null || nums.length == 0)
			return;
		int min = 0, index = 0;
		for (int i = 0; i < nums.length; i++) {
			min = nums[i];
			index = i;
			for (int j = i + 1; j < nums.length; j++)
				if (nums[j] < min) {
					min = nums[j];
					index = j;
				}
			swap(nums, i, index);
		}
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
		selectionSort(nums);
		System.out.println(Arrays.toString(nums));

		System.out.println();

		// random
		nums = new int[] { 2, 3, 1, 5, 8, 7, 9, 4, 6 };
		System.out.println(Arrays.toString(nums));
		selectionSort(nums);
		System.out.println(Arrays.toString(nums));

		System.out.println();

		// reversed
		nums = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println(Arrays.toString(nums));
		selectionSort(nums);
		System.out.println(Arrays.toString(nums));

	}

}
