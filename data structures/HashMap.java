
public class HashMap<k, v> {
	private class Entry<k, v> {
		k key;
		v value;
		Entry<k, v> next;

		public Entry(k key, v value) {
			this.key = key;
			this.value = value;
		}

		public String toString() {
			return "{" + key + "=" + value + "}";
		}
	}

	Entry<k, v>[] Table;
	int size;

	public HashMap(int size) {
		this.size = size;
		Table = (Entry<k, v>[]) new Entry[size];
	}

	public void put(k key, v value) {
		Entry<k, v> entry = new Entry<k, v>(key, value);
		int place = (int) key.hashCode() % size;
		if (place < 0)
			place = -place;
		if (Table[place] == null)
			Table[place] = entry;
		else {
			Entry itr = Table[place];
			while (itr.key != key && itr.next != null)
				itr = itr.next;
			if (itr.key == key)
				itr.value = value;
			else
				itr.next = entry;
		}

	}

	public v get(k key) {
		if (key == null)
			return null;
		int place = (int) key.hashCode() % size;
		if (place < 0)
			place = -place;
		if (Table[place] == null)
			return null;
		Entry itr = Table[place];
		while (itr != null && itr.key != key)
			itr = itr.next;
		if (itr == null)
			return null;
		return (v) itr.value;
	}

	public void remove(k key) {
		if (key == null)
			return;
		int place = (int) key.hashCode() % size;
		if (place < 0)
			place = -place;
		if (Table[place] == null)
			return;
		if (Table[place].key == key)
			Table[place] = Table[place].next;
		else {
			Entry itr = Table[place];
			while (itr.next != null && itr.next.key != key)
				itr = itr.next;
			if (itr.next.key == key)
				itr.next = itr.next.next;
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Table.length; i++) {
			sb.append("{" + i + "}: ");
			Entry itr = Table[i];
			while (itr != null) {
				sb.append(itr.toString());
				itr = itr.next;
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int size = 4;
		HashMap<String, Integer> map = new HashMap<String, Integer>(size);
		map.put("apples", 5);
		map.put("bananas", 3);
		map.put("oranges", 7);
		map.put("kiwis", 9);
		map.put("pinapples", 1);
		System.out.println(map);
		map.remove("pinapples");
		System.out.println(map.get("pinapples"));
		System.out.println(map.get("apples") + map.get("bananas") + map.get("oranges") + map.get("kiwis"));

	}

}
