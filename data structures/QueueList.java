import java.util.Random;

public class QueueList<T> {
	class Node<T> {
		T val;
		Node next;

		Node(T val) {
			this.val = val;
			this.next = null;

		}
	}

	int total;
	Node head, tail;

	public QueueList() {
		total = 0;
		head = tail = null;
	}

	public void enqueue(T pushed) {
		if (total == 0) {
			tail = new Node(pushed);
			head = tail;
			total++;
			return;
		}
		tail.next = new Node(pushed);
		tail = tail.next;
		total++;
	}

	public T dequeue() {
		if (head == null) // equivalent to tail == null || total == 0
			return null;
		T ret = (T) head.val;
		head = head.next;
		if (--total == 0)
			tail = null;
		return ret;
	}

	public static void main(String[] args) {
		QueueList<Integer> queue = new QueueList<>();
		for (int i = 0; i < 100; i++) {
			if ((new Random()).nextDouble() < 0.5)
				queue.enqueue(i);
			else
				System.out.println(queue.dequeue());
		}

	}

}
