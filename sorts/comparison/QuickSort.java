import java.util.Arrays;

public class QuickSort {

	public static void quickSort(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
	}

	public static void quickSort(int[] nums, int left, int right) {
		if (!(left < right))
			return;
		int pivot = partition(nums, left, right, null);
		quickSort(nums, left, pivot - 1);
		quickSort(nums, pivot + 1, right);

	}

	public static int partition(int[] nums, int left, int right, Integer pivot) {
		if (pivot == null)
			pivot = nums[right];
		int j = left - 1;
		for (int i = left; i < right; i++)
			if (nums[i] < pivot)
				swap(nums, ++j, i);
		swap(nums, right, ++j);
		return j;
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
		quickSort(nums);
		System.out.println(Arrays.toString(nums));

		System.out.println();

		// random
		nums = new int[] { 2, 3, 1, 5, 8, 7, 9, 4, 6 };
		System.out.println(Arrays.toString(nums));
		quickSort(nums);
		System.out.println(Arrays.toString(nums));

		System.out.println();

		// reversed
		nums = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println(Arrays.toString(nums));
		quickSort(nums);
		System.out.println(Arrays.toString(nums));
	}

}
