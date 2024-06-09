package SocialWebsite;

import SocialWebsite.Users.*;

public class Main {
    public static void main(String[] args) throws FriendException {

        SocialWebsite Server = new SocialWebsite();

        User booscuit = new User("Andrea", "Zeppeli", "Booscuit");
        User nikov = new User("Nikola", "Joestar", "NikoV");
        User fanny = new User("Tiffany", "Giovanna", "fanny_pak");
        User lilamor = new User("Licia", "Tedeschi", "lilamor");
        SuperUser dado = new SuperUser("Davide", "Puglia", "dadaismo");
        HackerUser kristel = new HackerUser("Kristel", "Sakura", "kri");
        AnnoyingUser lollo = new AnnoyingUser("Lorenzo", "Fastidiosi", "lollo18");

        Server.addUser(booscuit);
        Server.addUser(nikov);
        Server.addUser(fanny);
        Server.addUser(lilamor);
        Server.addUser(dado);
        Server.addUser(kristel);
        Server.addUser(lollo);

        System.out.println(Server.getUsers()); //good

        booscuit.sendFriendRequest(lilamor);
        System.out.println("Lilamor Friend Requests:\n" + lilamor.getFriendRequests()); //good
        lilamor.acceptFriendRequest(booscuit);
        System.out.println("Booscuit's and Lilamor's Friend Lists:\n" + //good
                booscuit.getFriendList(booscuit) + "\n" + lilamor.getFriendList(lilamor));

        booscuit.setFriendListPrivacy(false);
        lilamor.getFriendList(booscuit);
        //fanny.getFriendList(booscuit); //good

        booscuit.sendFriendRequest(fanny);
        booscuit.sendFriendRequest(nikov);
        fanny.acceptFriendRequest(booscuit);
        nikov.acceptFriendRequest(booscuit);

        System.out.println("Booscuit's FriendList before hacked:\n" +
                booscuit.getFriendList(booscuit)); //good

        kristel.hacker(booscuit);
        System.out.println("Booscuit's FriendList after being hacked:\n" +
                booscuit.getFriendList(booscuit)); //good

        //fanny.getFriendList(booscuit); //good
        System.out.println(dado.getFriendList(booscuit)); //good

        //lilamor.getName(booscuit); //good
        booscuit.setPersonalInfoPrivacy(true);
        System.out.println(lilamor.getName(booscuit)); //good

        System.out.println("fanny's Friend Requests before spam:\n" +
                fanny.getFriendRequests()); //good

        lollo.sendFriendRequest(fanny);
        System.out.println("fanny's Friend Requests after spam from " +
                "AnnoyingUser lollo:\n" + fanny.getFriendRequests()); //good

        System.out.println(SocialWebsite.admin.getFriendList(lilamor)); //good

        System.out.println("Users in Server by Surname:\n" + Server.getUsers()); //good

        //all good
    }
}
