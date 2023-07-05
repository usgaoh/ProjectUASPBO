package SepedaPantai;
import java.util.Scanner;

class Main{

  static Scanner scan = new Scanner(System.in);
  static Rental rental = new Rental();
  
  public static void main(String[] args){
    initRental();
    
    String isContinue = "y";

    while (isContinue.equals("y")){
      showMenu();
      int selectedMenu = pilihMenu();
      if (selectedMenu == 1){
        listSepeda();
      } else if (selectedMenu == 2){
        listPenyewa();
      } else if (selectedMenu == 3){
        tambahPenyewa();
      } else if (selectedMenu == 4){
        hapusPenyewa();
      } else if (selectedMenu == 5){
        pinjamSepeda();
      } else if (selectedMenu == 6){
        kembalikanSepeda();
      } else{
        System.out.println("Inputan yang anda masukan salah!");
      }
      System.out.print("Lanjut? ");
      isContinue = scan.next();
    }
  }

  public static void showMenu(){
    System.out.println(" ==========Menu Rental=========== ");
    System.out.println("|                                |");
    System.out.println("|       1. List Sepeda           |");
    System.out.println("|       2. List Penyewa          |");
    System.out.println("|       3. Tambah Penyewa        |");
    System.out.println("|       4. Hapus Penyewa         |");
    System.out.println("|       5. Pinjam Sepeda         |");
    System.out.println("|       6. Kembalikan Sepeda     |");
    System.out.println(" ================================");
  }

  public static void initRental(){
    Sepeda sepeda1= new Sepeda("1", ". Sepeda Keranjang");
    Sepeda sepeda2= new Sepeda("2", ". Sepeda Lipat");
    Sepeda sepeda3= new Sepeda("3", ". Sepeda Listrik");
    
    rental.sepedas.add(sepeda1);
    rental.sepedas.add(sepeda2);
    rental.sepedas.add(sepeda3);
  }

  public static int pilihMenu(){
		System.out.print("Pilih Menu : ");
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
      System.out.println(sepeda.getId()+""+sepeda.getNama());
    }
  }

  public static void pinjamSepeda(){
    System.out.print("Id Penyewa : ");
    String penyewaId = scan.next();

    System.out.print("Id Sepeda : ");
    String sepedaId = scan.next();
    
    rental.bawaSepeda(penyewaId, sepedaId);
  }

  public static void kembalikanSepeda(){
    System.out.print("Id Penyewa : ");
    String penyewaId = scan.next();

    System.out.print("Id Sepeda : ");
    String sepedaId = scan.next();

    rental.terimaSepeda(penyewaId, sepedaId);
  }

  public static void hapusPenyewa() {
        System.out.print("Id Penyewa : ");
        String id = scan.nextLine();

        Penyewa penyewa = rental.getPenyewaById(id);

        if (penyewa != null) {
            rental.penyewas.remove(penyewa);
            System.out.println("Penyewa dengan ID " + id + " berhasil dihapus");
        } else {
            System.out.println("Penyewa dengan ID " + id + " tidak ditemukan");
        }
    }
}