package SocialWebsite.Users;

import SocialWebsite.FriendException;

public class HackerUser extends User {

    public HackerUser(String name, String surname, String nickname) {super(name, surname, nickname);}

    public void hacker(User user) throws FriendException {

        this.getFriendList(user).clear();
    }

}
