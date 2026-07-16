package dao;

import database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Pemasukan;

public class PemasukanDAO {

    Connection conn = DatabaseConnection.getConnection();

    // INSERT menggunakan Stored Procedure
    public void tambahPemasukan(Pemasukan p) {

        try {

            CallableStatement cs = conn.prepareCall("{CALL tambah_pemasukan(?,?,?)}");

            cs.setString(1, p.getTanggal());
            cs.setString(2, p.getKeterangan());
            cs.setDouble(3, p.getJumlah());

            cs.execute();

            System.out.println("Data pemasukan berhasil ditambahkan.");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    // SELECT
    public List<Pemasukan> getAllPemasukan() {

        List<Pemasukan> list = new ArrayList<>();

        try {

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM pemasukan");

            while (rs.next()) {

                Pemasukan p = new Pemasukan(
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
    public void updatePemasukan(int id, Pemasukan p) {

        try {

            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE pemasukan SET tanggal=?, keterangan=?, jumlah=? WHERE id_pemasukan=?");

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
    public void deletePemasukan(int id) {

        try {

            PreparedStatement ps = conn.prepareStatement(
                    "DELETE FROM pemasukan WHERE id_pemasukan=?");

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Data berhasil dihapus.");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

}