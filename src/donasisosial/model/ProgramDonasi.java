/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package donasisosial.view;

/**
 *
 * @author ASUS
 */
public class ProgramDonasi {

    private String idProgram;
    private String namaProgram;
    private double targetDonasi;
    private String batasWaktu;

    public ProgramDonasi(String idProgram, String namaProgram, double targetDonasi, String batasWaktu) {
        this.idProgram = idProgram;
        this.namaProgram = namaProgram;
        this.targetDonasi = targetDonasi;
        this.batasWaktu = batasWaktu;
    }

    public String getIdProgram() {
        return idProgram;
    }

    public String getNamaProgram() {
        return namaProgram;
    }

    public double getTargetDonasi() {
        return targetDonasi;
    }

    public String getBatasWaktu() {
        return batasWaktu;
    }

}
