package xnikol08;

import java.util.ArrayList;


public class humanitStudent extends student {

	static ArrayList<Integer> humanitMarks = new ArrayList<Integer>();
	static int humanitStudents;

	public humanitStudent(int id, String name, String surname, int day, int month, int year) {
		super(name, surname, day, month, year);
		humanitStudents++;
	}

	@Override
	void studentType() {
		System.out.println("Jsem student humanitního oboru");
	}

	public void Mark(int addMark) {
		super.mark(addMark);
		humanitMarks.add(addMark);
	}

	public static float getHumanitMean() {
		total = 0;
		for (float addMark : humanitMarks)
			total += addMark;
		return total / (float) humanitMarks.size();
	}
}
