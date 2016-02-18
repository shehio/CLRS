import java.util.HashMap;

public class SuffixTree {
	private static class Node extends HashMap<Character, Node> {

		Node getOrPut(char c) {
			Node child = this.get(c);
			if (child == null) {
				this.put(c, child = new Node());
			}
			return child;
		}
	}

	Node root;

	SuffixTree() {
		root = new Node();
	}

	public void add(CharSequence source) {
		Node n;
		for (int i = 0; i < source.length(); i++) {
			n = root.getOrPut(source.charAt(i));
			for (int j = i + 1; j < source.length(); j++)
				n = n.getOrPut(source.charAt(j));
		}
	}

	public boolean contains(CharSequence word) {
		Node n = root;
		for (int i = 0; i < word.length(); i++) {
			n = n.get(word.charAt(i));
			if (n == null)
				return false;
		}
		return true;
	}

	public static void main (String [] args){
		SuffixTree tree = new SuffixTree();
		tree.add("Hilary Clinton");
		System.out.println(tree.contains("Hilary"));
		System.out.println(tree.contains(" "));
		System.out.println(tree.contains("Clinton"));
		System.out.println(tree.contains("Bill"));
	}
}
