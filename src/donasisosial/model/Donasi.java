package donasisosial.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Kelas Donasi merepresentasikan sebuah donasi yang diberikan oleh donatur ke
 * program donasi tertentu.
 */
public class Donasi {

    private final String idDonasi;
    private final String idProgram;
    private final double jumlah;
    private final LocalDate tanggal;

    /**
     * Konstruktor kelas Donasi.
     *
     * @param idDonasi ID unik donasi
     * @param idProgram ID program donasi yang menerima donasi
     * @param jumlah jumlah dana yang didonasikan, harus > 0
     * @param tanggal tanggal donasi dilakukan
     * @throws IllegalArgumentException jika jumlah <= 0 atau parameter id
     * kosong/null
     */
    public Donasi(String idDonasi, String idProgram, double jumlah, LocalDate tanggal) {
        if (idDonasi == null || idDonasi.isBlank()) {
            throw new IllegalArgumentException("ID donasi tidak boleh kosong");
        }
        if (idProgram == null || idProgram.isBlank()) {
            throw new IllegalArgumentException("ID program tidak boleh kosong");
        }
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah donasi harus lebih besar dari 0");
        }
        if (tanggal == null) {
            throw new IllegalArgumentException("Tanggal donasi tidak boleh null");
        }

        this.idDonasi = idDonasi;
        this.idProgram = idProgram;
        this.jumlah = jumlah;
        this.tanggal = tanggal;
    }

    public String getIdDonasi() {
        return idDonasi;
    }

    public String getIdProgram() {
        return idProgram;
    }

    public double getJumlah() {
        return jumlah;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    /**
     * Mengembalikan representasi string dari donasi dengan format: "Donasi
     * [idDonasi] ke Program [idProgram] sejumlah Rp [jumlah], tanggal:
     * [tanggal]"
     *
     * @return String representasi donasi
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return String.format("Donasi [%s] ke Program %s sejumlah Rp %.2f, tanggal: %s",
                idDonasi, idProgram, jumlah, tanggal.format(formatter));
    }

    public class Session {

        public static int idUser;
        public static String namaUser;
    }
}
