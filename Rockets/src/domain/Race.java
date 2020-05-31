package domain;

public class Race {
	int time;
	int distance;
	public Race(int time, int distance) throws Exception {
		if (time <= 0) {
			throw new Exception("Incorrect time");
		}
		if (distance <= 0) {
			throw new Exception("Incorrect distance");
		}
		this.time = time;
		this.distance = distance;
	}
}
