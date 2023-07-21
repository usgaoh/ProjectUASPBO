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
    public Sepeda(){
        this.id = null;
        this.nama = null;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setNama(String nama){
        this.nama = nama;
    }

}