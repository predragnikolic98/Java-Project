package xnikol08;

import java.io.*;
import java.sql.*;
import java.util.*;

public class databaze {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<student> sortedList = null;
	static TreeMap<Integer, student> databaze = new TreeMap<Integer, student>();
	static String name = null;
	static String surname = null;
	static int mark;
	static int day = 0;
	static int month = 0;
	static int year = 0;
	static int choise;
	static int id = 1;
	static int newid = 1;
	static boolean run = true;
	static student temp = null;
	
	
	
	static Statement stmnt;
	static PreparedStatement pstmnt = null;
	static ResultSet rs = null;
	

	public static void main(String[] args) {

		while (run) {
			System.out.println(" 1| Novy student");
			System.out.println(" 2| Zadat znamku");
			System.out.println(" 3| Propusteni studenta");
			System.out.println(" 4| Vypis informaci dle ID");
			System.out.println(" 5| Dovednosti dle ID");
			System.out.println(" 6| Abecedni výpis");
			System.out.println(" 7| Prumer vsech studentu dle oboru");
			System.out.println(" 8| Vypis poctu studentu dle skupiny");
			System.out.println(" 9| Nacteni z souboru");
			System.out.println("10| Ulozeni do souboru");
			choise = tests.number(sc);

			switch (choise) {
			case 1:
				System.out.println(" |Novy student");
				System.out.println(
						"1|Technicki obor\n2|Humanitni obor\n3|kombinovani studium");
				choise = tests.number(sc);

				if (choise == 1) {
					System.out.println(" |Jmeno: ");
					name = sc.next();
					System.out.println(" |Prijmeni: ");
					surname = sc.next();
					System.out.println(" |Datum narozeni DD ");
					day = tests.number(sc);
					System.out.println(" |Datum narozeni MM ");
					month = tests.number(sc);
					System.out.println(" |Datum narozeni RRRR ");
					year = tests.number(sc);
					if (tests.date(day, month, year) != true) {
						System.out.println("Neni spravne!");
						continue;
					}
					databaze.put(newid++, new technicStudent(id, name, surname, day, month, year));
					break;

				} else if (choise == 2) {
					System.out.println(" |Jmeno: ");
					name = sc.next();
					System.out.println(" |Prijmeni: ");
					surname = sc.next();
					System.out.println(" |Datum narozeni DD ");
					day = tests.number(sc);
					System.out.println(" |Datum narozeni MM ");
					month = tests.number(sc);
					System.out.println(" |Datum narozeni RRRR ");
					year = tests.number(sc);
					if (tests.date(day, month, year) != true) {
						System.out.println("Neni spravne!");
						continue;
					}
					databaze.put(newid++, new humanitStudent(id, name, surname, day, month, year));
					break;

				} else if (choise == 3) {
					System.out.println(" |Jmeno: ");
					name = sc.next();
					System.out.println(" |Prijmeni: ");
					surname = sc.next();
					System.out.println(" |Datum narozeni DD ");
					day = tests.number(sc);
					System.out.println(" |Datum narozeni MM ");
					month = tests.number(sc);
					System.out.println(" |Datum narozeni RRRR ");
					year = tests.number(sc);
					if (tests.date(day, month, year) != true) {
						System.out.println("Neni spravne!");
						continue;
					}
					databaze.put(newid++, new combinStudent(id, name, surname, day, month, year));
					break;
				} else {
					System.out.println("Nevybral jsi studijni skupinu");
				}
				break;

			case 2:
				try {
					System.out.println(" |Zadat studentovi znamku\n");
					System.out.println(" |ID? ");
					id = tests.number(sc);
					System.out.println(" |Znamka? ");
					mark = tests.number(sc);
					if (mark < 1 || mark > 5) {
						System.out.println("1 - 5!");
						break;
					}
					temp = databaze.get(id);
					temp.mark(mark);
				} catch (NullPointerException e) {
					System.out.println("Student neexistuje!");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 3:
				System.out.println(" |Propusteni studenta");
				System.out.println(" ID? ");
				id = tests.number(sc);
				tests.deleteStudent(databaze.get(id));
				databaze.remove(id);
				break;

			case 4:
				System.out.println(" |Informace dle ID\n");
				System.out.println(" |ID? ");
				id = tests.number(sc);
				try {
					temp = databaze.get(id);
					System.out.println("Jmeno: " + temp.getSurname() + " " + temp.getName() + "\nRok narozeni: "
							+ temp.getYear() + " \n |Studijni prumer: " + temp.getMean() + " \n");
				} catch (NullPointerException e) {
					System.out.println("Student neexistuje!");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 5:
				System.out.println(" |Dovednosti dle ID\n");
				System.out.println(" |ID? ");
				id = tests.number(sc);
				try {
					temp = databaze.get(id);
					if (temp instanceof technicStudent) {
						System.out.println("Jmeno: " + temp.getName() + " " + temp.getSurname() + " - "
								+ "Technicka fakulta\nNarozen: " + temp.getDay() + "." + temp.getMonth() + "."
								+ temp.getYear());
						tests.leapYear(year);
					} else if (temp instanceof humanitStudent) {
						System.out.println("Jmeno: " + temp.getName() + " " + temp.getSurname() + " - "
								+ "Humanitní fakulta\nNarozen: " + temp.getDay() + "." + temp.getMonth() + "."
								+ temp.getYear());
						tests.zodiac(month, day);
					} else {
						System.out.println("Jmeno: " + temp.getName() + " " + temp.getSurname() + " - "
								+ "Kombinovaný student\nNarozen: " + temp.getDay() + "." + temp.getMonth() + "."
								+ temp.getYear());
						tests.leapYear(year);
						tests.zodiac(month, day);
					}
				} catch (NullPointerException e) {
					System.out.println("Student neexistuje!");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 6:
				System.out.println(" |Vypis studentu dle prijmeni");
				try {
					sortedList = new ArrayList<student>(databaze.values());
					Collections.sort(sortedList, new surname());
					System.out.println("\nStudenti technicke falukty: ");
					for (student student : sortedList)
						if (student instanceof technicStudent)
							System.out.println("ID: " + student.getId() + ". " + student.getName() + " "
									+ student.getSurname() + " narozen: " + student.getYear() + " prumer: "
									+ student.getMean());
					System.out.println("\nStudenti humanitni fakulty: ");
					for (student student : sortedList)
						if (student instanceof humanitStudent)
							System.out.println("ID: " + student.getId() + ". " + student.getName() + " "
									+ student.getSurname() + " narozen: " + student.getYear() + " prumer: "
									+ student.getMean());
					System.out.println("\nStudenti kombinovaneho studia: ");
					for (student student : sortedList)
						if (student instanceof combinStudent)
							System.out.println("ID: " + student.getId() + ". " + student.getName() + " "
									+ student.getSurname() + " narozen: " + student.getYear() + " prumer: "
									+ student.getMean());
				} catch (NullPointerException e) {
					System.out.println("Neni zadny student!\n");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 7:
				System.out.println(" |Spolecny prumerS studentu dle oboru\n");
				System.out.println(
						"1|Fakulta techniky \n2|Fakulta humanitni");
				choise = tests.number(sc);
				switch (choise) {
				case 1:
					System.out.println("Prumer na technickem oboru: " + technicStudent.getTechnicMean() + "\n");
					break;
				case 2:
					System.out.println("Prumer na humanitnim oboru: " + humanitStudent.getHumanitMean() + "\n");
					break;
				default:
					System.out.println("Vybral jsi spatne!\n");
					break;
				}
				break;

			case 8:
				System.out.println(" |Celkovéi pocet studentu dle skupiny\n");
				System.out.println(
						"1|Fakulta techniky \n2|Fakulta humanitni \n3|Kombinovana skupina");
				choise = tests.number(sc);
				switch (choise) {
				case 1:
					System.out.println("Fakulta techniky: " + technicStudent.technicStudents + " studentu \n");
					break;
				case 2:
					System.out.println("Fakulta humanitni: " + humanitStudent.humanitStudents + " studentu \n");
					break;
				case 3:
					System.out.println("Kombinovana skupina: " + combinStudent.combinStudents + " studentu \n");
					break;
				default:
					System.out.println("Vybral jsi spatne \n");
					break;
				}
				break;
				
			case 9:
				System.out.println(" |Nacteni vsech udaju z souboru\n");
				System.out.println("Jmeno souboru? ");
				FileReader fr=null;
				BufferedReader in=null;
				try {
					fr = new FileReader(sc.next());
					in = new BufferedReader(fr);
					String radek=in.readLine();
					String oddelovac = "[ ]+";
					String[] castiTextu = radek.split(oddelovac);
					if (castiTextu.length!=2)
						break;
					int pocetPrvku=Integer.parseInt(castiTextu[1]);
					for (int i = 0; i < pocetPrvku; i++)
					{
						radek=in.readLine();
						castiTextu = radek.split(oddelovac);
						if (castiTextu.length==9)
						{
							if (castiTextu[1] == "TECHNIC")
								databaze.put(newid++, new technicStudent(id, castiTextu[3], castiTextu[4], Integer.parseInt(castiTextu[5]), Integer.parseInt(castiTextu[6]), Integer.parseInt(castiTextu[7])));
							else if (castiTextu[1] == "HUMANIT")
								databaze.put(newid++, new humanitStudent(id, castiTextu[3], castiTextu[4], Integer.parseInt(castiTextu[5]), Integer.parseInt(castiTextu[6]), Integer.parseInt(castiTextu[7])));
							else
								databaze.put(newid++, new combinStudent(id, castiTextu[3], castiTextu[4], Integer.parseInt(castiTextu[5]), Integer.parseInt(castiTextu[6]), Integer.parseInt(castiTextu[7])));
						}
					}
				}
				catch (IOException e) {
					System.out.println("Soubor  nelze otevøít");
					break;
				} 
				catch (NumberFormatException e) {
					System.out.println("Chyba integrity dat v souboru");
					break;
				}
				finally
				{
					try
					{	if (in!=null)
						{
							in.close();
							fr.close();
						}
					}
					catch (IOException e) {
						System.out.println("Soubor  nelze zavrit");
						break;
					} 
				}
				
				break;			

			case 10:
				System.out.println("Vybral jsi moznost: 11) Ulozeni vsech udaju do souboru\n");
				System.out.println("Zadejte jmeno souboru");
				
				try {
					FileWriter fw = new FileWriter(sc.next());
					BufferedWriter out = new BufferedWriter(fw);
					int rez = technicStudent.technicStudents + humanitStudent.humanitStudents + combinStudent.combinStudents;
					out.write(new String("Pocet " + rez));
					out.newLine();
					for (Map.Entry<Integer, student> entry : databaze.entrySet()) {
						temp = entry.getValue();
						String student = null;
						if (temp instanceof technicStudent)
							student = "TECHNIC STUDENT";
						else if (temp instanceof humanitStudent)
							student = "HUMANIT STUDENT";
						else
							student = "COMBIN STUDENT";
						out.write(temp.getId()+" "+student+" "+temp.getName()+" "+temp.getSurname()+" "+temp.getDay()+" "+temp.getMonth()+" "+temp.getYear()+" "+temp.getMean());
						out.newLine();
					}
					out.close();
					fw.close();
				}
				catch (IOException e) {
					System.out.println("Soubor nelze vytvorit");
					
				}
				break;
			}
		}
	}
}
