package donasisosial.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Donatur extends User {

    private int id;
    private String nama;
    private final List<Donasi> riwayatDonasi = new ArrayList<>();

    
    
    public Donatur(String username, String password, String nama) {
        super(username, password, "donatur");
        this.nama = (nama != null) ? nama : "";
    }

    public Donatur(int id, String username, String password, String nama) {
    super(username, password, "donatur");
    this.id = id;
    this.nama = (nama != null) ? nama : "";
}

    
    public Donatur(String username, String password) {
        this(username, password, "");
    }

    public void tambahDonasi(Donasi donasi) {
        if (donasi != null) {
            riwayatDonasi.add(donasi);
        }
    }

    public List<Donasi> getRiwayatDonasi() {
        return Collections.unmodifiableList(riwayatDonasi);
    }

    public String getNama() {
        return nama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void aksesMenu() {
        System.out.println("Menampilkan menu khusus Donatur");
        // Tambahkan implementasi sesuai kebutuhan
    }
    
    public Donatur(int id, String nama) {
    super("", "", "donatur"); // username & password bisa dikosongkan
    this.id = id;
    this.nama = (nama != null) ? nama : "";
}
}
