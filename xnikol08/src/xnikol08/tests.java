package xnikol08;

import java.util.InputMismatchException;
import java.util.Scanner;

public class tests {
	
	static int number(Scanner sc) {
		int number = 0;
		try {
			number = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.print("Nezadal jsi cislo! ");
			sc.nextLine();
			number = number(sc);
		}
		return number;
	}

	
	static boolean date(int day, int month, int year) {
		if ((day >= 32 || day <= 0) && month == 1)
			return false;
		else if (day == 29 && month == 2 && year % 4 == 0)
			return true;
		else if ((day >= 29 || day <= 0) && month == 2)
			return false;
		else if ((day >= 32 || day <= 0) && month == 3)
			return false;
		else if ((day >= 31 || day <= 0) && month == 4)
			return false;
		else if ((day >= 32 || day <= 0) && month == 5)
			return false;
		else if ((day >= 31 || day <= 0) && month == 6)
			return false;
		else if ((day >= 32 || day <= 0) && month == 7)
			return false;
		else if ((day >= 32 || day <= 0) && month == 8)
			return false;
		else if ((day >= 31 || day <= 0) && month == 9)
			return false;
		else if ((day >= 32 || day <= 0) && month == 10)
			return false;
		else if ((day >= 31 || day <= 0) && month == 11)
			return false;
		else if ((day >= 32 || day <= 0) && month == 12)
			return false;
		else if (month >= 13 || month <= 0)
			return false;
		else if (year <= 1 || year >= 2020)
			return false;
		return true;
	}

	
	public static void deleteStudent(student student) {
		if (student instanceof technicStudent) {
			technicStudent.technicStudents--;
			System.out.println("Student propusten z univerzity\n");
		} else if (student instanceof humanitStudent) {
			humanitStudent.humanitStudents--;
			System.out.println("Student propusten z univerzity\n");
		} else if (student instanceof combinStudent) {
			combinStudent.combinStudents--;
			System.out.println("Student propusten z univerzity\n");
		}

	}

	
	public static void leapYear(int year) {
		if (year % 4 == 0) {
			System.out.println("Rok narozeni je prestupny");
		} else {
			System.out.println("Rok narozeni neni prestupny");
		}
	}

	
	public static void zodiac(int month, int day) {
		if ((month == 12 && day >= 22) || (month == 1 && day <= 20)) {
			System.out.println("Narozen ve znameni: KOZOROH ");
		} else if ((month == 1 && day >= 21) || (month == 2 && day <= 20)) {
			System.out.println("Narozen ve znameni: VODNAR ");
		} else if ((month == 2 && day >= 21) || (month == 3 && day <= 20)) {
			System.out.println("Narozen ve znameni: RYBY ");
		} else if ((month == 3 && day >= 21) || (month == 4 && day <= 20)) {
			System.out.println("Narozen ve znameni: BERAN ");
		} else if ((month == 4 && day >= 21) || (month == 5 && day <= 21)) {
			System.out.println("Narozen ve znameni: BYK ");
		} else if ((month == 5 && day >= 22) || (month == 6 && day <= 21)) {
			System.out.println("Narozen ve znameni: BLIZENCI ");
		} else if ((month == 6 && day >= 22) || (month == 7 && day <= 22)) {
			System.out.println("Narozen ve znameni: RAK ");
		} else if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) {
			System.out.println("Narozen ve znameni: LEV ");
		} else if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) {
			System.out.println("Narozen ve znameni: PANNA ");
		} else if ((month == 9 && day >= 23) || (month == 10 && day <= 23)) {
			System.out.println("Narozen ve znameni: VAHY ");
		} else if ((month == 10 && day >= 24) || (month == 11 && day <= 22)) {
			System.out.println("Narozen ve znameni: STIR ");
		} else if ((month == 11 && day >= 23) || (month == 12 && day <= 21)) {
			System.out.println("Narozen ve znameni: STRELEC ");
		} else {
			System.out.println("Nema znameni");
		}
	}
}
