package donasisosial.model;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private final List<User> daftarUser = new ArrayList<>();

    /**
     * Menambahkan user baru, dengan pengecekan username unik.
     *
     * @param user User baru yang akan didaftarkan
     * @return true jika berhasil ditambahkan, false jika username sudah ada
     */
    public boolean registrasiUser(User user) {
        if (user == null) {
            return false;
        }
        // Cek apakah username sudah ada
        for (User u : daftarUser) {
            if (u.getUsername().equals(user.getUsername())) {
                return false; // Username sudah ada
            }
        }
        daftarUser.add(user);
        return true;
    }

    public User login(String username, String password) {
        for (User user : daftarUser) {
            if (user.login(username, password)) {
                return user;
            }
        }
        return null; // Tidak ditemukan user yang cocok
    }

    public List<User> getAllUsers() {
        return daftarUser;
    }
}
