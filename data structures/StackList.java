import java.util.Random;

public class StackList<T> {

	private static class Node<T>{
		T val;
		Node next;
		Node(T val){
			this.val = val;
			this.next = null;
		}
	}
	Node head, tail;
	public StackList() {
		head = tail = null;
	}
	public void push(T pushed){
		Node n = new Node(pushed);
		if(head == null) // stack is empty
			head = tail = n;
		else{
			n.next = head;
			head = n;
		}
	}
	public T pop(){
		if(head == null) return null;
		T ret = (T) head.val; // object
		if(head == tail)
			head = tail = null;
		else head = head.next;
		return ret;
	}
	public T top(){
		if(head == null)
			return null;
		return (T) head.val;
	}
	
	public static void main(String[] args) {
		StackList<Integer> stack = new StackList<>();
		for (int i = 0; i < 100; i++) {
			if ((new Random()).nextDouble() < 0.5)
				stack.push(i);
			else
				System.out.println(stack.pop());
		}
	}

}
