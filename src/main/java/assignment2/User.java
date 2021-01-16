package assignment2;

public class User {
    private String username;
    private String side;

    public User(String username, String side) {
        this.username = username;
        this.side = side;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }
}
