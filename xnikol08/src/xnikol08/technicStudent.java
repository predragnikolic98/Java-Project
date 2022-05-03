package xnikol08;

import java.util.ArrayList;


public class technicStudent extends student {

	static int technicStudents;
	static ArrayList<Integer> technicalMarks = new ArrayList<Integer>();

	public technicStudent(int id, String name, String surname, int day, int month, int year) {
		super(name, surname, day, month, year);
		technicStudents++;
	}

	@Override
	void studentType() {
		System.out.println("Jsem student techniky");
	}


	public void mark(int addMark) {
		super.mark(addMark);
		technicalMarks.add(addMark);
	}

	public static float getTechnicMean() {
		total = 0;
		for (float addMark : technicalMarks)
			total += addMark;
		return total / (float) technicalMarks.size();
	}
}
