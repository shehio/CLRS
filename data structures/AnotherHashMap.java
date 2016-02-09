public class AnotherHashMap<k, v> {
	private class Entry<k, v> {
		k key;
		v value;

		public Entry(k key, v value) {
			this.key = key;
			this.value = value;
		}
	}

	Entry<k, v>[] table;
	int size;
	int capacity;

	public AnotherHashMap(int size) {
		this.size = size;
		this.capacity = 0;
		table = (Entry<k, v>[]) new Entry[size];
	}

	public boolean put(k key, v value) {
		if (capacity == size)
			return false;
		Entry entry = new Entry(key, value);
		int place = key.hashCode() % size;
		if (place < 0)
			place = -place;
		while (table[place] != null && table[place].key != key)
			place = (place + 1) % size;
		table[place] = entry;
		capacity++;
		return true;
	}

	public v get(k key) {
		int place = key.hashCode() % size;
		if (place < 0)
			place = -place;
		int trials = 0;
		while (table[place] != null && table[place].key != key && trials < size) {
			place = (place + 1) % size;
			trials++;
		}
		return (trials == size) ? null : (v) table[place].value; // maybe null
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0; i < table.length; i++)
			if (table[i] != null)
				sb.append("{" + table[i].key + "=" + table[i].value + "} ");
		sb.append("}");
		return sb.toString();
	}

	public static void main(String[] args) {
		int size = 4;
		AnotherHashMap<String, Integer> map = new AnotherHashMap<>(size);
		map.put("apples", 5);
		map.put("bananas", 3);
		map.put("oranges", 7);
		map.put("kiwis", 9);
		System.out.println(map);
		System.out.println(map.get("pinapples"));
		System.out.println(map.get("apples") + map.get("bananas") + map.get("oranges") + map.get("kiwis"));
	}

}
