import java.util.TreeSet;

public class Tweet {
    private int idTw;
    private String username;
    private String msg;
    private TreeSet<String> likes;

    public void like(String username) {
        this.likes.add(username);
    }

    public Tweet(String username, String msg) {
        this.username = username;
        this.msg = msg;
        this.idTw++;
        this.likes = new TreeSet<>();
        if (this.idTw == 1)
            this.idTw = 0;
    }

    // Gets
    public int getIdTw() {
        return idTw;
    }

    public TreeSet<String> getLikes() {
        return likes;
    }

    public String getMsg() {
        return msg;
    }

    public String getUsername() {
        return username;
    }

    public String toString() {
        StringBuilder exit = new StringBuilder();
        exit.append(idTw).append(":").append(username).append("(").append(msg).append(")").append(likes);

        return exit.toString();
    }
}