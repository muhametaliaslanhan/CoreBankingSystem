package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        UserDao userdao_liste=new UserDao();
        List<User> gelen_kullanicilar= userdao_liste.gettAllUsers();

        for (User u: gelen_kullanicilar )
        {
            System.out.println(u.getId()+"-"+u.getName()+" "+u.getLastname()+"-"+u.getTc_no());
        }
    }
}
