import java.util.ArrayList;
import java.util.List;

public class ActivitySelection {
	public static class Activity {
		int start, finish;

		public Activity(int start, int finish) {
			this.start = start;
			this.finish = finish;
		}

		public String toString() {
			return "(" + start + ", " + finish + ")";
		}
	}

	public static int run(Activity[] activities) {
		if (activities == null || activities.length == 0)
			return 0;
		double start = 0;
		int count = 0;
		List<Activity> chosen = new ArrayList<Activity>();
		for (int i = 0; i < activities.length; i++)
			if (activities[i].start >= start) {
				count++;
				start = activities[i].finish;
				chosen.add(activities[i]);
			}
		return count; // or chosen if required.

	}

	public static void main(String[] args) {
		int starts[] = { 1, 3, 0, 5, 8, 5 };
		int finishes[] = { 2, 4, 6, 7, 9, 9 };
		int n = starts.length;
		Activity[] activities = new Activity[n];
		for (int i = 0; i < n; i++)
			activities[i] = new Activity(starts[i], finishes[i]);
		System.out.println(run(activities));
	}

}
