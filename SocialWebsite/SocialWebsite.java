package SocialWebsite;

import SocialWebsite.Users.Admin;
import SocialWebsite.Users.User;

import java.util.HashSet;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SocialWebsite {

    private HashSet<User> users;

    public static final Admin admin = new Admin("Admin", "Admin", "Admin");

    public SocialWebsite() {

        this.users = new HashSet<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public TreeMap<String, User> getUsers() {

        TreeMap<String, User> usersBySurname = new TreeMap<String, User>();

        usersBySurname.putAll(users.stream()
                .collect(Collectors.toMap(
                        user -> admin.getSurnameAdmin(user),
                        user -> user)));

        return usersBySurname;
    }
}