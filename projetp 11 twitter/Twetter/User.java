import java.util.Map;
import java.util.TreeMap;

public class User {
    private String username;
    private Map<String, User> followers;
    private Map<String, User> following;
    private Map<Integer, Tweet> timeline;
    private int unreadCount;

    public void follow(User user) throws Exception {
        if (following.containsKey(user.getUsername()))
            throw new Exception("Tu já segue esse cara ai pow");

        // Relação NxN, o cara segue e é seguido
        this.following.put(user.getUsername(), user);
        user.getFollowers().put(this.username, this);
    }

    public void unfollow(String username) throws Exception {
        if (!this.following.containsKey(username))
            throw new Exception("Tu não segue ele para deixar de seguir pai");

        User aux = this.following.remove(username);
        aux.getFollowers().remove(this.username);

    }

    public void sendTweet(Tweet tweet) {
        for (Map.Entry<String, User> followerss : this.followers.entrySet()) {
            followerss.getValue().timeline.put(tweet.getIdTw(), tweet);
            followerss.getValue().unreadCount++;
        }
        this.timeline.put(tweet.getIdTw(), tweet);
    }

    // retorna todas as timelines ainda nao vistass
    public String getUnread() {
        StringBuilder solver = new StringBuilder();
        if (unreadCount == 0)
            return "Tá vazio mah";

        while (unreadCount != this.timeline.size()) {
            solver.append(timeline.get(unreadCount)).append("\n");
            unreadCount++;
        }
        unreadCount = 0;
        return solver.toString();
    }

    // retorna a timeline do user
    public Tweet getTweet(int idTw) throws Exception {
        if (!timeline.containsKey(idTw))
            throw new Exception("Esse tweet não existe nesta timeline");

        return this.timeline.get(idTw);
    }

    // retornar logo todas as timelines de uma vez só
    public String getTimelineFull() {
        StringBuilder solver = new StringBuilder();

        for (Tweet tweet : timeline.values())
            solver.append(tweet).append("\n");

        this.unreadCount = 0;
        return solver.toString();
    }

    public User(String username) {
        this.username = username;
        this.followers = new TreeMap<>();
        this.following = new TreeMap<>();
        this.timeline = new TreeMap<>();
    }

    public String toString() {
        return username;
    }

    // gets
    public Map<String, User> getFollowers() {
        return followers;
    }

    public Map<String, User> getFollowing() {
        return following;
    }

    public Map<Integer, Tweet> getTimeline() {
        return timeline;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public String getUsername() {
        return username;
    }

}
