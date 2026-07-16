package model;

public class Transaksi {

    private String tanggal;
    private String keterangan;
    private double jumlah;

    public Transaksi() {

    }

    public Transaksi(String tanggal, String keterangan, double jumlah) {
        this.tanggal = tanggal;
        this.keterangan = keterangan;
        this.jumlah = jumlah;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public void tampilDetail() {
        System.out.println("Tanggal    : " + tanggal);
        System.out.println("Keterangan : " + keterangan);
        System.out.println("Jumlah     : " + jumlah);
    }

}