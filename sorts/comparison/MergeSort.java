import java.util.Arrays;

public class MergeSort {

	public static void mergeSort(int[] nums) {
		mergeSort(nums, 0, nums.length - 1);
	}

	public static void mergeSort(int[] nums, int left, int right) {
		if (!(left < right))
			return;
		int mid = left + (right - left) / 2;
		mergeSort(nums, left, mid);
		mergeSort(nums, mid + 1, right);
		merge(nums, left, right);
	}

	public static void merge(int[] nums, int left, int right) {
		int mid = left + (right - left) / 2;
		int[] lefty = new int[mid - left + 1];
		int[] righty = new int[right - mid];
		lefty = Arrays.copyOfRange(nums, left, mid + 1);
		righty = Arrays.copyOfRange(nums, mid + 1, right + 1);
		int i = 0, j = 0, k = left;
		while (k <= right) {
			if (i < lefty.length && j < righty.length)
				nums[k++] = (lefty[i] < righty[j]) ? lefty[i++] : righty[j++];
			else if (i < lefty.length)
				nums[k++] = lefty[i++];
			else
				nums[k++] = righty[j++];
		}
	}

	public static void main(String[] args) {
		// sorted
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(Arrays.toString(nums));
		mergeSort(nums);
		System.out.println(Arrays.toString(nums));

		System.out.println();

		// random
		nums = new int[] { 2, 3, 1, 5, 8, 7, 9, 4, 6 };
		System.out.println(Arrays.toString(nums));
		mergeSort(nums);
		System.out.println(Arrays.toString(nums));

		System.out.println();

		// reversed
		nums = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println(Arrays.toString(nums));
		mergeSort(nums);
		System.out.println(Arrays.toString(nums));

	}

}
