package donasisosial.model;

import java.util.Objects;

public abstract class User {

    protected String username;
    protected String password; // password dalam plain text (bisa dienkripsi di pengembangan selanjutnya)
    protected String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public boolean login(String inputUsername, String inputPassword) {
        return Objects.equals(this.username, inputUsername) && Objects.equals(this.password, inputPassword);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    // Method wajib diimplementasi oleh child class
    public abstract void aksesMenu();
}
