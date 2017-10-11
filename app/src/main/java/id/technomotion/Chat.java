package id.technomotion;

/**
 * Created by omayib on 11/10/17.
 */

public class Chat {
    private String message;
    private String sender;
    private String avatar;

    public Chat(String message, String sender, String avatar) {
        this.message = message;
        this.sender = sender;
        this.avatar = avatar;
    }

    public String getMessage() {
        return message;
    }

    public String getSender() {
        return sender;
    }

    public String getAvatar() {
        return avatar;
    }
}
