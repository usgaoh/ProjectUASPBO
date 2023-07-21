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
    // Revisi penambahan Overloading pada method Sepeda
    // Karena seperti yang saya baca - baca bahwa parameter yang berbeda namun satu method dapat dikatakan Overloading
    public Sepeda(){
        this.id = null;
        this.nama = null;
    }
    // Revisi penambahan setter pada kelas Main, pada method initRental diinisiasi
    public void setId(String id){
        this.id = id;
    }
    public void setNama(String nama){
        this.nama = nama;
    }

}