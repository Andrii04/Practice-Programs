package SocialWebsite.Users;

import SocialWebsite.FriendException;
import SocialWebsite.SocialWebsite;

import java.util.ArrayList;
import java.util.TreeSet;

public class User {

    private String name;
    private String surname;
    private String nickname;
    private TreeSet<String> friendList;
    private ArrayList<String> friendRequests;
    private boolean publicFriendList;
    private boolean publicPersonalInfo;

    public User(String name, String surname, String nickname) {
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.friendList = new TreeSet<>();
        this.friendRequests = new ArrayList<>();
        this.publicFriendList = true;
        this.publicPersonalInfo = false;
    }

    public String getName(User user) throws FriendException {
        if (this == user || this.getClass() == Admin.class || user.getPublicPersonalInfo()) return user.name;
        else throw new FriendException(user.getNickname() + " has their personal info set to Private!");
    }

    public String getSurnameAdmin(User user) {

        if (this.getClass() == Admin.class) return user.surname;
        else {
            System.out.println("Need to be Admin to use this method!");
            return null;
        }
    }

    public String getSurname(User user) throws FriendException {
        if (this == user || this.getClass() == Admin.class || user.getPublicPersonalInfo()) return surname;
        else throw new FriendException(user.getNickname() + " has their personal info set to Private!");
    }

    public String getNickname() {
        return nickname;
    }

    public boolean getPublicPersonalInfo() {return publicPersonalInfo;}
    public boolean getPublicFriendList() {return publicFriendList;}

    public TreeSet<String> getFriendList(User user) throws FriendException {
        if (
                        this == user
                        || this.getClass() == Admin.class
                        || user.friendList.contains(this.nickname)
                        || this.getClass() == SuperUser.class
                        || this.getClass() == HackerUser.class
                        || user.getPublicFriendList())

            return user.friendList;

        else throw new FriendException("Only " + user.getNickname() + "'s Friends can see their friendList!");
    }

    public ArrayList<String> getFriendRequests() {return friendRequests;}

    private void addFriendRequest(User user) {friendRequests.add(user.getNickname());}
    private void addFriend(User user) {friendList.add(user.getNickname());}

    public void sendFriendRequest(User user) {
        user.addFriendRequest(this);
    }

    public void acceptFriendRequest(User user) throws FriendException{
        if (friendRequests.contains(user.getNickname())) {
            friendList.add(user.getNickname());
            user.friendList.add(nickname);
            friendRequests.remove(user.getNickname());
        }
        else throw new FriendException(user.getNickname() + " hasn't sent you a Friend Request!");
    }

    public void setFriendListPrivacy(boolean parameter) {
        publicFriendList = parameter;
    }

    public void setPersonalInfoPrivacy(boolean parameter) {
        publicPersonalInfo = parameter;
    }

    @Override
    public String toString() {return nickname;}

}
