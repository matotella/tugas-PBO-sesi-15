package dao;

import database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Pengeluaran;

public class PengeluaranDAO {

    Connection conn = DatabaseConnection.getConnection();

    // INSERT
    public void tambahPengeluaran(Pengeluaran p) {

        try {

            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO pengeluaran(tanggal,keterangan,jumlah) VALUES(?,?,?)");

            ps.setString(1, p.getTanggal());
            ps.setString(2, p.getKeterangan());
            ps.setDouble(3, p.getJumlah());

            ps.executeUpdate();

            System.out.println("Data pengeluaran berhasil ditambahkan.");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    // SELECT
    public List<Pengeluaran> getAllPengeluaran() {

        List<Pengeluaran> list = new ArrayList<>();

        try {

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM pengeluaran");

            while (rs.next()) {

                Pengeluaran p = new Pengeluaran(
                        rs.getString("tanggal"),
                        rs.getString("keterangan"),
                        rs.getDouble("jumlah"));

                list.add(p);

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return list;

    }

    // UPDATE
    public void updatePengeluaran(int id, Pengeluaran p) {

        try {

            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE pengeluaran SET tanggal=?, keterangan=?, jumlah=? WHERE id_pengeluaran=?");

            ps.setString(1, p.getTanggal());
            ps.setString(2, p.getKeterangan());
            ps.setDouble(3, p.getJumlah());
            ps.setInt(4, id);

            ps.executeUpdate();

            System.out.println("Data berhasil diupdate.");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    // DELETE
    public void deletePengeluaran(int id) {

        try {

            PreparedStatement ps = conn.prepareStatement(
                    "DELETE FROM pengeluaran WHERE id_pengeluaran=?");

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Data berhasil dihapus.");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    // VIEW
    public void tampilRingkasanKas() {

        try {

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM view_ringkasan_kas");

            System.out.println("\n===== RINGKASAN KAS =====");

            while (rs.next()) {

                System.out.println(
                        rs.getString("jenis") + " | "
                        + rs.getString("tanggal") + " | "
                        + rs.getString("keterangan") + " | "
                        + rs.getDouble("jumlah"));

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    // FUNCTION
    public double getSaldoKas() {

        double saldo = 0;

        try {

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT saldo_kas() AS saldo");

            if (rs.next()) {

                saldo = rs.getDouble("saldo");

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return saldo;

    }

}