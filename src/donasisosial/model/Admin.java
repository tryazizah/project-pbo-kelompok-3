package donasisosial.model;

public class Admin extends User {

    private String nama;

    // Constructor lengkap: menerima username, password, dan nama
    public Admin(String username, String plainPassword, String nama) {
        super(username, plainPassword, "admin");  // gunakan lowercase "admin" untuk konsistensi role
        this.nama = (nama != null && !nama.isEmpty()) ? nama : "Admin";
    }

    // Constructor minimal: tanpa nama, nama default "Admin"
    public Admin(String username, String plainPassword) {
        this(username, plainPassword, "Admin");  // panggil konstruktor lengkap
    }

    @Override
    public void aksesMenu() {
        System.out.println("Selamat datang, Admin " + nama + "!");
        // Tambahkan fitur menu admin di sini, misalnya:
        // - Kelola donasi
        // - Lihat laporan
        // - Kelola pengguna
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama != null && !nama.isEmpty()) {
            this.nama = nama;
        }
    }

    @Override
    public String toString() {
        return "Admin{"
                + "username='" + username + '\''
                + ", nama='" + nama + '\''
                + ", role='" + role + '\''
                + '}';
    }
}
