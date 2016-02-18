import java.util.Arrays;

public class InsertionSort {

	public static void insertionSort(int[] nums) {
		if (nums == null || nums.length == 0)
			return;
		int current = 0, j = 0;
		for (int i = 0; i < nums.length; i++) {
			current = nums[i];
			j = i - 1;
			while (j >= 0 && nums[j] > current)
				nums[j + 1] = nums[j--];
			nums[j + 1] = current;
		}
	}

	public static void main(String[] args) {

		// sorted
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(Arrays.toString(nums));
		insertionSort(nums);
		System.out.println(Arrays.toString(nums));

		System.out.println();

		// random
		nums = new int[] { 2, 3, 1, 5, 8, 7, 9, 4, 6 };
		System.out.println(Arrays.toString(nums));
		insertionSort(nums);
		System.out.println(Arrays.toString(nums));

		System.out.println();

		// reversed
		nums = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println(Arrays.toString(nums));
		insertionSort(nums);
		System.out.println(Arrays.toString(nums));
	}

}
