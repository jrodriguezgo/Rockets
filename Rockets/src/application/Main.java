package application;

import Keyboard.Keyboard;
import domain.Rocket;

public class Main {

	public static void main(String[] args) throws Exception {
		startGame(20, 1400);
	}

	public static void startGame(int time, int distance) throws Exception {
		boolean out = false;
		int startTime = 0;
		Rocket c = new Rocket("Souvlaki");
		System.out.printf("Rocket: " + c.getName() + "\n");
		System.out.print("Starting competition. Circuit length: " + distance + ". Max time: " + time + "\n");
		while (!out && startTime < time && c.getFuel() > 0) {
			System.out.print("Please, enter acceleration:\n");
			int speedUp = Keyboard.readInt();
			int set, currentDistance = 0;
			set = c.calculateSpeedDistance(speedUp, 2);
			set = (int) c.calculateFuel();
			startTime = timeController(set, startTime);
			currentTimeToString(startTime, c, distance);
			currentDistance += c.getDistance();
			out = fuel(distance, c, currentDistance);
		}
		score(out, startTime, c);
	}

	private static int timeController(int set, int startTime) {
		if (set == 0) {
			return startTime += 2;

		} else {
			return startTime += set;
		}
	}

	private static void currentTimeToString(int startTime, Rocket c, int distance) {
		System.out.print("Current time: " + startTime + " Acceleration: " + c.getAcceleration() + " Speed: "
				+ c.getSpeed() + " Distance: " + c.getDistance() + " Circuit: " + distance);
	}

	private static boolean fuel(int distance, Rocket coet, int currentDistance) {
		if (coet.getFuel() <= 0) {
			System.out.print(" Fuel: 0\n");
		} else {
			System.out.print(" Fuel: " + coet.getFuel() + "\n");
		}
		if (currentDistance >= distance && coet.getFuel() >= 0) {
			return true;
		}
		return false;
	}

	public static void score(boolean end, int time, Rocket coet) {
		if (end) {
			System.out.print("And the winner is: " + coet.getName() + " with a time of " + time);
		} else {
			System.out.print("There is no winner, sorry!");
		}
	}
}
