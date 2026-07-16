package main;

import service.KasService;
import util.InputHelper;

public class Main {

    public static void main(String[] args) {

        KasService service = new KasService();

        int pilih;

        do {

            System.out.println("\n====================================");
            System.out.println("   APLIKASI MANAJEMEN KAS SEDERHANA");
            System.out.println("====================================");
            System.out.println("1. Data Transaksi");
            System.out.println("2. Pengeluaran");
            System.out.println("3. Laporan");
            System.out.println("4. Keluar");

            pilih = InputHelper.inputInt("Pilih Menu : ");

            switch (pilih) {

                case 1:

                    int menu1;

                    do {

                        System.out.println("\n===== MENU PEMASUKAN =====");
                        System.out.println("1. Tambah Pemasukan");
                        System.out.println("2. Lihat Data Pemasukan");
                        System.out.println("3. Kembali");

                        menu1 = InputHelper.inputInt("Pilih : ");

                        switch (menu1) {

                            case 1:
                                service.tambahPemasukan();
                                break;

                            case 2:
                                service.lihatPemasukan();
                                break;

                        }

                    } while (menu1 != 3);

                    break;

                case 2:

                    int menu2;

                    do {

                        System.out.println("\n===== MENU PENGELUARAN =====");
                        System.out.println("1. Tambah Pengeluaran");
                        System.out.println("2. Lihat Data Pengeluaran");
                        System.out.println("3. Kembali");

                        menu2 = InputHelper.inputInt("Pilih : ");

                        switch (menu2) {

                            case 1:
                                service.tambahPengeluaran();
                                break;

                            case 2:
                                service.lihatPengeluaran();
                                break;

                        }

                    } while (menu2 != 3);

                    break;

                case 3:

                    int menu3;

                    do {

                        System.out.println("\n===== MENU LAPORAN =====");
                        System.out.println("1. Lihat Ringkasan Kas");
                        System.out.println("2. Lihat Saldo Akhir");
                        System.out.println("3. Kembali");

                        menu3 = InputHelper.inputInt("Pilih : ");

                        switch (menu3) {

                            case 1:
                                service.lihatRingkasanKas();
                                break;

                            case 2:
                                service.lihatSaldoKas();
                                break;

                        }

                    } while (menu3 != 3);

                    break;

                case 4:
                    System.out.println("\nTerima kasih telah menggunakan aplikasi.");
                    break;

                default:
                    System.out.println("\nMenu tidak tersedia!");

            }

        } while (pilih != 4);

    }

}