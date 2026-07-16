package model;

public class Pengeluaran extends Transaksi {

    public Pengeluaran() {

    }

    public Pengeluaran(String tanggal, String keterangan, double jumlah) {

        super(tanggal, keterangan, jumlah);

    }

    @Override
    public void tampilDetail() {

        System.out.println("===== DATA PENGELUARAN =====");

        super.tampilDetail();

    }

}