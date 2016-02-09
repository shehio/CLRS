import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class StackArray<T> {

	T[] arr;
	int total, first, size;

	public StackArray() {
		size = 4;
		arr = (T[]) new Object[size]; // you can't initiate an array of a
										// generic!
		total = 0;
		first = 0;
	}

	public void push(T pushed) {
		if (total == arr.length)
			resize(total * 2);
		arr[(first++) % arr.length] = pushed;
		total++;
	}

	public T pop() {
		if (total <= 0)
			return null;
		T ret = arr[--first % arr.length];
		if (--total < arr.length / 4)
			resize(arr.length / 2);
		return ret;
	}

	public T top() {
		return (total <= 0) ? null : arr[first - 1];
	}

	private void resize(int newSize) {
		T[] newArr = (T[]) new Object[newSize];
		for (int i = 0; i < first; i++)
			newArr[i] = arr[i];
		arr = newArr;

	}

	public static void main(String[] args) {
		StackArray<Integer> stack = new StackArray<>();
		for (int i = 0; i < 100; i++) {
			if ((new Random()).nextDouble() < 0.5)
				stack.push(i);
			else
				System.out.println(stack.pop());
		}

	}

}
