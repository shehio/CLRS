import java.util.Arrays;

public class SearchNLogN {
	private final String[] suffixes;

	public SearchNLogN(String haystack) {
		suffixes = new String[haystack.length()];
		for (int i = 0; i < haystack.length(); i++)
			suffixes[i] = haystack.substring(i);
		Arrays.sort(suffixes);
	}

	public boolean search(final String pattern) {
		int index = Arrays.binarySearch(suffixes, pattern);
		if (index > 0)
			return true;
		index = -(index + 1);
		return (index < suffixes.length && suffixes[index].startsWith(pattern));
	}

	public static void main(String[] args) {
		SearchNLogN instance = new SearchNLogN("Hilary Clinton");
		System.out.println(instance.search("Hilary"));
		System.out.println(instance.search(" "));
		System.out.println(instance.search("Clinton"));
		System.out.println(instance.search("Bill"));

	}

}
