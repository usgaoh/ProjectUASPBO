package SepedaPantai;
import java.util.ArrayList;

// Inheritance
public class Rental extends Penyewa{
public ArrayList<Sepeda> sepedas = new ArrayList<Sepeda>();
public ArrayList<Penyewa> penyewas = new ArrayList<Penyewa>();

  public void tambahPenyewa (Penyewa penyewa){
    if (!isPenyewaIdExist(penyewa.getId())){
        this.penyewas.add(penyewa);
        System.out.println("Berhasil menambahkan");
    } else {
      System.out.println("Id : "+penyewa.getId()+" Sudah ada!");
    }
  }

  public Boolean isPenyewaIdExist(String id){
    Boolean isExist = false;
    for (Penyewa penyewa : this.penyewas){
      if (penyewa.getId().equals(id)){
        isExist = true;
      }
    }
    return isExist;
  }

  public Boolean isSepedaIdExist(String id){
    Boolean isExist = false;
    for (Sepeda sepeda : this.sepedas){
      if (sepeda.getId().equals(id)){
        isExist = true;
      }
    }
    return isExist;
  }

  // Unsur Polymorphism pada Method bawaSepeda
  public void bawaSepeda(String penyewaId, String sepedaId){
    Sepeda sepeda = this.getSepedaById(sepedaId, sepedas);
    this.sepedas.remove(sepeda);

    Penyewa penyewa = this.getPenyewaById(penyewaId);
    int penyewaIndex = this.getPenyewaIndex(penyewa);
    this.penyewas.get(penyewaIndex).terimaSepeda(sepeda);
  }

  private int getPenyewaIndex(Penyewa penyewa){
    return this.penyewas.indexOf(penyewa);
  }

  Penyewa getPenyewaById(String id){
    for (Penyewa penyewa : this.penyewas){
      if (penyewa.getId().equals(id)){
        return penyewa;
      }
    }
    return null;
  }

  private Sepeda getSepedaById(String id, ArrayList<Sepeda> List){
    for (Sepeda sepeda : List){
      if (sepeda.getId().equals(id)){
        return sepeda;
      }
    }
    return null;
  }
  public void terimaSepeda(String penyewaId, String sepedaId) {
    Penyewa penyewa = this.getPenyewaById(penyewaId);
    int penyewaIndex = this.getPenyewaIndex(penyewa);
    
    Sepeda sepeda = this.getSepedaById(sepedaId, penyewa.pinjamSepedas);
    this.sepedas.add(sepeda);
    this.penyewas.get(penyewaIndex).bawaSepeda(sepeda);
  }
}