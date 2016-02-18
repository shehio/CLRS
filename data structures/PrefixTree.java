
import java.util.HashMap;

public class PrefixTree {
	private static class Node extends HashMap<Character, Node> {
		boolean leaf;

		Node() {
			leaf = false;
		}

		Node getOrPut(char c) {
			Node child = this.get(c);
			if (child == null) {
				this.put(c, child = new Node());
			}
			return child;
		}
	}

	Node root;

	PrefixTree() {
		root = new Node();
	}

	public void add(CharSequence word) {
		Node n = root;
		for (int i = 0; i < word.length(); i++)
			n = n.getOrPut(word.charAt(i));
		n.leaf = true;
	}

	public Node search(CharSequence word) {
		Node n = root;
		for (int i = 0; i < word.length(); i++) {
			n = n.get(word.charAt(i));
			if (n == null)
				break;
		}
		return n;
	}

	public boolean contains(CharSequence word) {
		Node n = search(word);
		return (n != null && n.leaf);
	}

	public boolean startsWith(CharSequence word) {
		Node n = search(word);
		return (n != null);
	}

	public static void main(String[] args) {
		PrefixTree trie = new PrefixTree();
		trie.add("go");
		trie.add("gooo");
		System.out.println(trie.contains("go"));
		System.out.println(trie.startsWith("go"));
		System.out.println(trie.contains("goo"));
		System.out.println(trie.startsWith("goo"));
	}

}
