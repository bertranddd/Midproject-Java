import java.util.Scanner;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

public class Main {
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	Vector<data> vecdata = new Vector<data>();
	Vector<Double> arraygajian = new Vector<Double>();
	Vector<String> arrayjabatan = new Vector<String>();

	public Main() {
		mainMenu();
	}

	private void mainMenu() {

		int menu = 0;
		do {
			System.out.println("Menu Data Karyawan PT.Mentol");
			System.out.println("----------------------------");
			System.out.println("1. Insert Data Karyawan");
			System.out.println("2. View Data Karyawan");
			System.out.println("3. Update Data Karyawan");
			System.out.println("4. Delete Data Karyawan");
			System.out.println("5. Exit menu");
			System.out.print("Select Menu >> ");
			menu = scan.nextInt();
			scan.nextLine();
			switch (menu) {

			case 1:
				InsertData();
				break;
			case 2:
				ViewData();
				break;
			case 3:
				ChangeData();
				break;
			case 4:
				DeleteData();
				break;
			}
            scan.nextLine();
			if (menu < 5) {
				Enter();
			}
		} while (menu != 5);

	}

	int countmanager = 0, countsupervisor = 0, countadmin = 0, count1 = 0, count2 = 0, count3 = 0, count11=0, count22=0, count33=0;
	double gaji = 0;
	String kode = "";
	int urutan=-1, geser=0;

	private void InsertData() {
		String nama;
		String jeniskelamin;
		String jabatan;
		double count = 0;
		String cek;

		do {
			System.out.print("Input nama karyawan [>=3]: ");
			nama = scan.nextLine();
		} while (nama.length() < 3);
		urutan++;
		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			jeniskelamin = scan.nextLine();
		} while (!jeniskelamin.equals("Laki-laki") && !jeniskelamin.equals("Perempuan"));

		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatan = scan.nextLine();
		} while (!jabatan.equals("Manager") && !jabatan.equals("Supervisor") && !jabatan.equals("Admin"));

		if (jabatan.equals("Manager")) {
			gaji = 8000000;
			arraygajian.add(gaji);
			arrayjabatan.add("a");
			countmanager++;
			count1++;
			
		}
		if (jabatan.equals("Supervisor")) {
			gaji = 6000000;
			arraygajian.add(gaji);
			arrayjabatan.add("b");
			countsupervisor++;
			count2++;
			
		}
		if (jabatan.equals("Admin")) {
			gaji = 4000000;
			arraygajian.add(gaji);
			arrayjabatan.add("c");
			countadmin++;
			count3++;
			
		}
		if (countmanager > 3) {
			System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id ");
			for (int j = 0; j < vecdata.size(); j++) {
				int penentu = vecdata.get(j).getUrutan();
				cek = arrayjabatan.get(penentu);
				if (cek.equals("a")) {
					System.out.printf("%s", vecdata.get(j).getKode());
					count11++;
					if (count11+1 == count1) {
						System.out.println("");
						count11 = 0;
					} else {
						System.out.print(", ");
					}
					geser = vecdata.get(j).getUrutan();
					count = arraygajian.get(geser);
					arraygajian.set(geser, (count + (count * 0.1)));
				}
			}
			countmanager = 1;

		}
		if (countsupervisor > 3) {
			System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id ");
			for (int j = 0; j < vecdata.size(); j++) {
				int penentu = vecdata.get(j).getUrutan();
				cek = arrayjabatan.get(penentu);
				if (cek.equals("b")) {
					System.out.printf("%s", vecdata.get(j).getKode());
					count22++;
					if (count22+1 == count2) {
						System.out.println("");
						count22 = 0;
					} else {
						System.out.print(", ");
					}
					geser = vecdata.get(j).getUrutan();
					count = arraygajian.get(geser);
					arraygajian.set(geser, (count + (count * 0.075)));
				}
			}
			countsupervisor = 1;
		}
		if (countadmin > 3) {
			System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id ");
			for (int j = 0; j < vecdata.size(); j++) {
				int penentu = vecdata.get(j).getUrutan();
				cek = arrayjabatan.get(penentu);
				if (cek.equals("c")) {
					System.out.printf("%s", vecdata.get(j).getKode());
					count33++;
					if (count33+1 >= count3) {
						System.out.println("");
						count33 = 0;
					} else {
						System.out.print(", ");
					}
					geser = vecdata.get(j).getUrutan();
					count = arraygajian.get(geser);
					arraygajian.set(geser, (count + (count * 0.05)));
				}
			}
			countadmin = 1;
		}
	
		kode = "";
		for (int j = 0; j < 2; j++) {
			kode += (char) (rand.nextInt(26) + 65);
		}
		kode = kode.concat("-");
		for (int i = 0; i < 4; i++) {
			kode += rand.nextInt(10);
		}

		System.out.printf("Berhasil menambahkan karyawan dengan id %s\n", kode);
		vecdata.add(new data(nama, jeniskelamin, jabatan, kode, urutan));
		
		
		//Collections.sort(vecdata, new Pengurutan());
	}
	
	private void ViewData() {
		Collections.sort(vecdata, new Pengurutan());
		System.out.println("|----|-----------|-----------------|---------------|------------|----------|");
		System.out.println("|No  |Kode       |Nama Karyawan    |Jenis Kelamin  |Jabatan     |gaji      |");
		System.out.println("|----|-----------|-----------------|---------------|------------|----------|");
		for (int j = 0; j < vecdata.size(); j++) {
			int urut = vecdata.get(j).getUrutan();
			System.out.printf("| %3s| %10s| %16s| %14s| %11s| %9.0f|\n", j + 1, vecdata.get(j).getKode(),
					vecdata.get(j).getNama(), vecdata.get(j).getJeniskelamin(), vecdata.get(j).getJabatan(),
					arraygajian.get(urut));

		}
		System.out.println("|----|-----------|-----------------|---------------|------------|----------|");
	}

	private void ChangeData() {
		String nama;
		String jeniskelamin;
		String jabatan;
		double count = 0;
		String cek;
		String kode;
		Double gaji;
		int nomor = 0;
		ViewData();
		System.out.println("Masukkan nomor data karyawan yang ingin diupdate");
		nomor = scan.nextInt();
		scan.nextLine();
		do {
			System.out.print("Input kode karyawan baru [EX: AB-1234]: ");
			kode = scan.nextLine();
		} while (kode.length() != 7);

		vecdata.get(nomor - 1).setKode(kode);

		do {
			System.out.print("Input nama baru [>=3]: ");
			nama = scan.nextLine();
			vecdata.get(nomor - 1).setNama(nama);

		} while (nama.length() < 2);

		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			jeniskelamin = scan.nextLine();
			vecdata.get(nomor - 1).setJeniskelamin(jeniskelamin);
		} while (!jeniskelamin.equals("Laki-laki") && !jeniskelamin.equals("Perempuan"));

		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatan = scan.nextLine();
			vecdata.get(nomor - 1).setJabatan(jabatan);
		} while (!jabatan.equals("Manager") && !jabatan.equals("Supervisor") && !jabatan.equals("Admin"));

		System.out.print("Input gaji karyawan baru : ");
		gaji = scan.nextDouble();
		int penentu = vecdata.get(nomor-1).getUrutan();
		arraygajian.set(penentu, gaji);

		if (jabatan.equals("Manager")) {
			penentu = vecdata.get(nomor-1).getUrutan();
			arrayjabatan.set(penentu-1, "a");
			countmanager++;
			count1++;
		}
		if (jabatan.equals("Supervisor")) {
			penentu = vecdata.get(nomor-1).getUrutan();
			arrayjabatan.set(penentu - 1, "b");
			countsupervisor++;
			count2++;
		}
		if (jabatan.equals("Admin")) {
			penentu = vecdata.get(nomor-1).getUrutan();
			arrayjabatan.set(penentu - 1, "c");
			countadmin++;
			count3++;
		}
		if (countmanager > 3) {
			System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id ");
			for (int j = 0; j < vecdata.size(); j++) {
				penentu = vecdata.get(j).getUrutan();
				cek = arrayjabatan.get(penentu);
				if (cek.equals("a")) {
					System.out.printf("%s", vecdata.get(j).getKode());
					count11++;
					if (count11+1 == count1) {
						System.out.println("");
						count11=0;
					} else {
						System.out.print(", ");
					}
					geser = vecdata.get(j).getUrutan();
					count = arraygajian.get(geser);
					arraygajian.set(geser, (count + (count * 0.1)));
				}
			}
			countmanager = 1;

		}
		if (countsupervisor > 3) {
			System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id ");
			for (int j = 0; j < vecdata.size(); j++) {
				penentu = vecdata.get(j).getUrutan();
				cek = arrayjabatan.get(penentu);
				if (cek.equals("b")) {
					System.out.printf("%s", vecdata.get(j).getKode());
					count22++;
					if (count22+1 == count2) {
						System.out.println("");
						count22 = 0;
					} else {
						System.out.print(", ");
					}
					geser = vecdata.get(j).getUrutan();
					count = arraygajian.get(geser);
					arraygajian.set(geser, (count + (count * 0.075)));
				}
			}
			countsupervisor = 1;
		}
		if (countadmin > 3) {
			System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id ");
			for (int j = 0; j < vecdata.size(); j++) {
				penentu = vecdata.get(j).getUrutan();
				cek = arrayjabatan.get(penentu);
				if (cek.equals("c")) {
					System.out.printf("%s", vecdata.get(j).getKode());
					count33++;
					if (count33+1 == count3) {
						System.out.println("");
						count33 = 0;
					} else {
						System.out.print(", ");
					}
					geser = vecdata.get(j).getUrutan();
					count = arraygajian.get(geser);
					arraygajian.set(geser, (count + (count * 0.05)));
				}
			}
			countadmin = 1;
		}
		//Collections.sort(vecdata, new Pengurutan());

		System.out.println("Data berhasil diupdate");

	}

	private void DeleteData() {
		ViewData();
		int nomor = 0;
		System.out.print("Pilih nomor data karyawan yang ingin dihapus: ");
		nomor = scan.nextInt();
		int geser = vecdata.get(nomor-1).getUrutan();
		if(arrayjabatan.get(geser).equals("a")) {
			count1-=1;
		}
		if(arrayjabatan.get(geser).equals("b")) {
			count2-=1;
		}
		if(arrayjabatan.get(geser).equals("c")) {
			count3-=1;
		}
		
		vecdata.remove(nomor - 1);
		
		
		System.out.println("Data tersebut berhasil dihapus.");
	}

	private void Enter() {
		System.out.println("Enter to back");
		scan.nextLine();
	}

	public static void main(String[] args) {
		new Main();
	}
}
