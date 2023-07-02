package SepedaPantai;

// Encapsulation
class Sepeda{
    private String id;
    private String nama;

    public Sepeda(String id, String nama){
      this.id = id;
      this.nama = nama;
    }
    public String getId(){
        return id;
    }
    public String getNama(){
        return nama;
    }
}