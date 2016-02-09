import java.util.HashMap;

public class Zellar {

	private static HashMap<Integer, String> map = new HashMap<Integer, String>();
	private int day;
	private int month;
	private int year;

	public Zellar(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
		if(month <= 2){
			this.month +=12;
			this.year -=1;
		}
	}

	public String calculate() {
		int k = year % 100;
		int j = year / 100;
		int ret = day + 13 * (month + 1) / 5 + k + k / 4 + j / 4 - 2 * j;
		return map.get(ret % 7);
	}

	public static void main(String[] args) {
		map.put(0, "Saturday");
		map.put(1, "Sunday");
		map.put(2, "Monday");
		map.put(3, "Tuesday");
		map.put(4, "Wednesday");
		map.put(5, "Thursday");
		map.put(6, "Friday");
		System.out.println((new Zellar(11, 9, 2001)).calculate());
	}

}
