package model;

public class Pemasukan extends Transaksi {

    public Pemasukan() {

    }

    public Pemasukan(String tanggal, String keterangan, double jumlah) {

        super(tanggal, keterangan, jumlah);

    }

    @Override
    public void tampilDetail() {

        System.out.println("===== DATA PEMASUKAN =====");

        super.tampilDetail();

    }

}