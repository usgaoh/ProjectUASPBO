package SepedaPantai;
import java.util.Scanner;

class Main{

  static Scanner scan = new Scanner(System.in);
  static Rental rental = new Rental();

  public static void main(String[] args) {
    initRental();

    String isContinue = "y";

    while (isContinue.equals("y")) {
      showMenu();
      int selectedMenu = pilihMenu();
      if (selectedMenu == 1) {
        listSepeda();
      } else if (selectedMenu == 2) {
        listPenyewa();
      } else if (selectedMenu == 3) {
        tambahPenyewa();
      } else if (selectedMenu == 4) {
        pinjamSepeda();
      } else if (selectedMenu == 5) {
        kembalikanSepeda();
      } else if (selectedMenu == 6) {
        // hapusPenyewa();
      } else {
        System.out.println("Inputan yang anda masukan salah!");
      }
      System.out.print("Lanjut? ");
      isContinue = scan.next();
    }
  }

  public static void showMenu() {
    System.out.println(" ================================");
    System.out.println("|          Menu Rental           |");
    System.out.println("|================================|");
    System.out.println("|       1. List Sepeda           |");
    System.out.println("|       2. List Penyewa          |");
    System.out.println("|       3. Tambah Penyewa        |");
    System.out.println("|       4. Pinjam Sepeda         |");
    System.out.println("|       5. Kembalikan Sepeda     |");
    System.out.println("|       6. Hapus Penyewa         |");
    System.out.println(" ================================");
  }

  public static void initRental(){
    Sepeda sepeda1 = new Sepeda();
    sepeda1.setId("1.");
    sepeda1.setNama(" Sepeda Keranjang");

    Sepeda sepeda2 = new Sepeda();
    sepeda2.setId("2.");
    sepeda2.setNama(" Sepeda Listrik");

    Sepeda sepeda3 = new Sepeda();
    sepeda3.setId("3.");
    sepeda3.setNama(" Sepeda Lipat");

    rental.sepedas.add(sepeda1);
    rental.sepedas.add(sepeda2);
    rental.sepedas.add(sepeda3);
  }

  public static int pilihMenu() {
		System.out.print("pilih menu : ");
		int pilihan = scan.nextInt();
		scan.nextLine();
		return pilihan;
	}

  public static void tambahPenyewa(){
    Penyewa penyewa = new Rental();

    System.out.print("Id : ");
    String id = scan.nextLine();
    penyewa.setId(id);

    System.out.print("Nama : ");
    String nama = scan.nextLine();
    penyewa.setNama(nama);

    rental.tambahPenyewa(penyewa);
  }
  public static void listPenyewa(){
    for(Penyewa penyewa : rental.penyewas){
      System.out.println(penyewa.getId()+". "+penyewa.getNama());
    }
  }

  public static void listSepeda(){
    for(Sepeda sepeda : rental.sepedas){
      System.out.println(""+sepeda.getId()+""+sepeda.getNama());
    }
  }

  public static void pinjamSepeda(){
    System.out.print("Id penyewa : ");
    String penyewaId = scan.next();

    System.out.print("Id sepeda : ");
    String sepedaId = scan.next();
    
    rental.bawaSepeda(penyewaId, sepedaId);
  }
  public static void kembalikanSepeda() {
    System.out.print("id penyewa : ");
    String penyewaId = scan.next();

    System.out.print("id sepeda : ");
    String sepedaId = scan.next();

    rental.terimaSepeda(penyewaId, sepedaId);
  }
  public void hapusPenyewa(){
    System.out.println("hapus penyewa");
    int penyewaId = scan.nextInt();
    
    Penyewa.remove(penyewaId-1);
  }
}