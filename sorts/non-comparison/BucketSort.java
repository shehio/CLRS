import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class BucketSort {

	public static void bucketSort(int[] nums) {
		if (nums == null || nums.length == 0)
			return;
		int buckets = nums.length / 10 + 1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, index = 0, i = 0, j = 0;
		LinkedList<Integer>[] lists = (LinkedList<Integer>[]) new LinkedList[buckets];
		for (i = 0; i < nums.length; i++) {
			max = Math.max(nums[i], max);
			min = Math.min(nums[i], min);
		}
		double interval = (double) (buckets - 1) / (max - min);
		for (i = 0; i < nums.length; i++) {
			index = (int) (interval * (nums[i] - min));
			if (lists[index] == null) {
				lists[index] = new LinkedList<Integer>();
				lists[index].add(nums[i]);
			} else {
				j = 0;
				while (j < lists[index].size() && nums[i] > lists[index].get(j))
					j++;
				lists[index].add(j, nums[i]);
			}
		}
		ListIterator<Integer> itr = null;
		j = 0;
		for (i = 0; i < lists.length; i++) {
			itr = lists[i].listIterator();
			while (itr.hasNext())
				nums[j++] = itr.next();
		}
	}

	public static void main(String[] args) {
		// sorted
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		System.out.println(Arrays.toString(nums));
		bucketSort(nums);
		System.out.println(Arrays.toString(nums));

		System.out.println();

		// random
		nums = new int[] { 2, 3, 1, 5, 8, 7, 9, 4, 6 };
		System.out.println(Arrays.toString(nums));
		bucketSort(nums);
		System.out.println(Arrays.toString(nums));

		System.out.println();

		// reversed
		nums = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println(Arrays.toString(nums));
		bucketSort(nums);
		System.out.println(Arrays.toString(nums));
	}

}
