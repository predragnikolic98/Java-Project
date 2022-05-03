package xnikol08;

import java.util.ArrayList;


public class combinStudent extends student {

	static ArrayList<Integer> combinMarks = new ArrayList<Integer>();
	static int combinStudents;

	public combinStudent(int id, String name, String surname, int day, int month, int year) {
		super(name, surname, day, month, year);
		combinStudents++;
	}

	@Override
	void studentType() {
		System.out.println("Jsem student kombinovaneho studia");
	}

	public void mark(int addMark) {
		super.mark(addMark);
		combinMarks.add(addMark);
	}
}
