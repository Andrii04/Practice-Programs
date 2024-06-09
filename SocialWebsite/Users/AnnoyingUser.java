package SocialWebsite.Users;

public class AnnoyingUser extends User {

    public AnnoyingUser(String name, String surname, String nickname) {super(name, surname, nickname);}

    @Override
    public void sendFriendRequest(User user) {

        super.sendFriendRequest(user);
        super.sendFriendRequest(user);
        super.sendFriendRequest(user);
    }

}
