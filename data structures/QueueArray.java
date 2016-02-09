import java.util.Arrays;
import java.util.Random;

public class QueueArray<T> {
	private int first, total, size;
	private T[] arr;

	public QueueArray() {
		size = 2;
		arr = (T[]) new Object[size];
		first = 0;
		total = 0;
	}

	public void enqueue(T element) {
		if (total == arr.length)
			resize(total * 2);
		arr[(first + total++) % arr.length] = element;
	}

	public T dequeue() {
		T ret = null;
		if (total >= 1) {
			ret = arr[first];
			first = (first + 1) % size;
			total--;
		}
		if (total <= arr.length / 4 && arr.length > 2)
			resize(arr.length / 2);
		return ret;
	}

	private void resize(int newSize) {
		T[] newArr = (T[]) new Object[newSize];
		for (int i = 0; i < total; i++)
			newArr[i] = arr[(first + i) % arr.length];
		arr = newArr;
		size = newSize;
		first = 0;
	}

	public String toString() {
		return Arrays.toString(arr);
	}

	public static void main(String[] args) {
		QueueArray<Integer> queue = new QueueArray<>();
		for (int i = 0; i < 100; i++) {
			if ((new Random()).nextDouble() < 0.5)
				queue.enqueue(i);
			else
				System.out.println(queue.dequeue());
		}

	}

}
