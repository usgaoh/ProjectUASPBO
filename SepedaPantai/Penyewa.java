package SepedaPantai;
import java.util.ArrayList;

abstract class Penyewa {
  private String id;
  private String nama;
  public ArrayList<Sepeda> pinjamSepedas = new ArrayList<Sepeda>();
  
    public String getId(){
        return id;
    }
    public String getNama(){
        return nama;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
   public void terimaSepeda(Sepeda sepeda) {
    this.pinjamSepedas.add(sepeda);
  }
    public void hapusPenyewa(Sepeda sepeda) {
    this.pinjamSepedas.remove(sepeda);
  }
}