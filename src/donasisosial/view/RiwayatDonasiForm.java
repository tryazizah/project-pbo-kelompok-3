package donasisosial.view;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import donasisosial.model.Donatur;
import donasisosial.model.Donasi;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.DriverManager;

public class RiwayatDonasiForm extends javax.swing.JFrame {

    private Donatur donatur;

    public RiwayatDonasiForm(Donatur donatur) {
        this.donatur = donatur;
        initComponents();
        setLocationRelativeTo(null);
        lblJudul.setText("Riwayat Donasi - " + donatur.getNama());
        tampilkanRiwayatDonasi();
    }

    private void tampilkanRiwayatDonasi() {
        DefaultTableModel model = (DefaultTableModel) tblRiwayat.getModel();
        model.setRowCount(0); // bersihkan isi tabel
        System.out.println("Menampilkan riwayat untuk ID user: " + donatur.getId());

        try {
            // Ganti dengan nama database kamu
            java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/donasisosial", "root", "");
            String sql = "SELECT * FROM riwayat_donasi WHERE id_user= ?";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, donatur.getId()); // ambil id_user dari objek Donatur

            java.sql.ResultSet rs = ps.executeQuery();
            int no = 1;
            while (rs.next()) {
                Object[] row = {
                    no++,
                    rs.getString("program"),
                    String.format("Rp%,.0f", rs.getDouble("nominal")),
                    rs.getString("tanggal") != null ? rs.getString("tanggal") : "-" // jika ada tanggal
                };
                model.addRow(row);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan riwayat: " + e.getMessage());
        }
    }

    public void simpanDonasi(int id, String nama, String program, double nominal) {
        try {
            java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/donasisosial", "root", "");
            String sql = "INSERT INTO riwayat_donasi (id, nama_donatur, program, nominal) VALUES (?, ?, ?, ?)";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, nama);
            ps.setString(3, program); // "Pendidikan", "Bencana", atau "Kesehatan"
            ps.setDouble(4, nominal);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Donasi berhasil disimpan!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan donasi: " + e.getMessage());
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnKembali = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRiwayat = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        lblJudul.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblJudul.setForeground(new java.awt.Color(255, 255, 255));
        lblJudul.setText("Riwayat Donasi Anda");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addComponent(lblJudul)
                .addGap(145, 145, 145))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJudul, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 461, 50);

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        btnKembali.setBackground(new java.awt.Color(153, 204, 255));
        btnKembali.setForeground(new java.awt.Color(255, 255, 255));
        btnKembali.setText("Kembali ke Menu");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(btnKembali)
                .addContainerGap(169, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnKembali, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 270, 460, 56);

        jScrollPane1.setBackground(new java.awt.Color(153, 204, 255));

        tblRiwayat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Program Donasi", "Jumlah Donasi", "Tanggal  Donasi"
            }
        ));
        jScrollPane2.setViewportView(tblRiwayat);

        jScrollPane1.setViewportView(jScrollPane2);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 52, 454, 220);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        new MenuDonaturForm(donatur).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    public static void main(String args[]) {
        // Contoh dummy donatur (ganti dengan data asli jika ada)
        Donatur donatur = new Donatur(1, "donatur1", "donatur123", "Nama Donatur");
        // Tambahkan riwayat donasi dummy jika ingin testing

        java.awt.EventQueue.invokeLater(() -> {
            new RiwayatDonasiForm(donatur).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JTable tblRiwayat;
    // End of variables declaration//GEN-END:variables
}
