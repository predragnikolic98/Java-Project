package xnikol08;

import java.util.Comparator;


public class surname implements Comparator<student> {

	public int compare(student one, student two) {
		String Sur1 = one.getSurname();
		String Sur2 = two.getSurname();
		return Sur1.compareToIgnoreCase(Sur2);
	}
}
