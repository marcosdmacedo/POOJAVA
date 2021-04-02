import java.util.Map;
import java.util.TreeMap;

public class Controller {
    private Map<String, User> users;
    private Map<Integer, Tweet> tweets;

    public void sendTweet(String username, String msg) throws Exception {
        if (!users.containsKey(username))
            throw new Exception("User nao encontrado!");

        Tweet tweet = new Tweet(username, msg);
        this.users.get(username).sendTweet(tweet);
        this.tweets.put(tweet.getIdTw(), tweet);
    }

    public void addUser(String username) throws Exception {
        if (users.containsKey(username))
            throw new Exception("Usuario existente");

        User user = new User(username);
        this.users.put(username, user);
    }

    public User getUser(String username) throws Exception {
        if (!this.users.containsKey(username))
            throw new Exception("[ERROR] nao encontrado");

        return this.users.get(username);
    }

    public void follow(String follower, String following) throws Exception {
        if (!users.containsKey(follower) || !users.containsKey(following))
            throw new Exception("Usuarios não encontrado");

        User seguidor = users.get(follower);
        User seguindo = users.get(following);

        seguidor.follow(seguindo);
    }

    public void unfollow(String follower, String following) throws Exception {
        if (!users.containsKey(follower) || !users.containsKey(following))
            throw new Exception("Um dos usuarios nao encontrados");

        User seguidor = users.get(follower);
        User seguindo = users.get(following);

        seguidor.unfollow(seguindo.getUsername());
    }

    public void like(String username, int idTw) throws Exception {
        if (!users.containsKey(username))
            throw new Exception("Usuario nao encontrado!");

        if (!tweets.containsKey(idTw))
            throw new Exception("Tweet nao encontrado!");

        if (!users.get(username).getTimeline().containsKey(idTw))
            throw new Exception("Timeline nao encontrada!");

        Tweet tweet = tweets.get(idTw);
        tweet.like(username);
    }

    public String unread(String username) throws Exception {
        if (!users.containsKey(username))
            throw new Exception("Usuario nao encontrado");

        return users.get(username).getUnread();
    }

    public String timeLine(String username) throws Exception {
        if (!users.containsKey(username)) {
            throw new Exception("Usuario nao encontrado");
        }

        return users.get(username).getTimelineFull();
    }

    public Controller() {
        this.tweets = new TreeMap<>();
        this.users = new TreeMap<>();
    }

}
