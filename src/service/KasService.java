package service;

import dao.PemasukanDAO;
import dao.PengeluaranDAO;
import model.Pemasukan;
import model.Pengeluaran;
import util.InputHelper;

public class KasService {

    private PemasukanDAO pemasukanDAO = new PemasukanDAO();
    private PengeluaranDAO pengeluaranDAO = new PengeluaranDAO();

    public void tambahPemasukan() {

        System.out.println("\n===== TAMBAH PEMASUKAN =====");

        String tanggal = InputHelper.inputString("Tanggal (YYYY-MM-DD) : ");
        String keterangan = InputHelper.inputString("Keterangan          : ");
        double jumlah = InputHelper.inputDouble("Jumlah              : ");

        Pemasukan p = new Pemasukan(tanggal, keterangan, jumlah);

        pemasukanDAO.tambahPemasukan(p);

    }

    public void lihatPemasukan() {

        System.out.println("\n===== DATA PEMASUKAN =====");

        for (Pemasukan p : pemasukanDAO.getAllPemasukan()) {

            p.tampilDetail();
            System.out.println("------------------------------");

        }

    }

    public void tambahPengeluaran() {

        System.out.println("\n===== TAMBAH PENGELUARAN =====");

        String tanggal = InputHelper.inputString("Tanggal (YYYY-MM-DD) : ");
        String keterangan = InputHelper.inputString("Keterangan          : ");
        double jumlah = InputHelper.inputDouble("Jumlah              : ");

        Pengeluaran p = new Pengeluaran(tanggal, keterangan, jumlah);

        pengeluaranDAO.tambahPengeluaran(p);

    }

    public void lihatPengeluaran() {

        System.out.println("\n===== DATA PENGELUARAN =====");

        for (Pengeluaran p : pengeluaranDAO.getAllPengeluaran()) {

            p.tampilDetail();
            System.out.println("------------------------------");

        }

    }

    public void lihatRingkasanKas() {

        pengeluaranDAO.tampilRingkasanKas();

    }

    public void lihatSaldoKas() {

        System.out.println("\n==============================");
        System.out.println("Saldo Kas : Rp " + pengeluaranDAO.getSaldoKas());
        System.out.println("==============================");

    }

}