package org.example;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ListIterator;
import java.util.ArrayList;


public class UserDao {

    public List<User> gettAllUsers()
    {
        List<User> kullanici_listesi = new ArrayList<>();
        try(Connection baglanti = DriverManager.getConnection(DatabaseConfig.getDbUrl(), DatabaseConfig.getDbUserName(),
                DatabaseConfig.getDbPassword()))
        {
            System.out.println("Acildi ulan.....");
            java.sql.Statement birinci_nesne=baglanti.createStatement();

            java.sql.ResultSet sorgu_sonuc=birinci_nesne.executeQuery("SELECT * FROM users");

            while (sorgu_sonuc.next())
            {
                int id =sorgu_sonuc.getInt("id");
                String isim = sorgu_sonuc.getString("first_name");
                String soyisim =sorgu_sonuc.getString("last_name");
                String tc_no=sorgu_sonuc.getString("tc_identity_number");

                User kullanici_nesnesi = new User(id,isim,soyisim,tc_no);

                System.out.println(kullanici_nesnesi);
                kullanici_listesi.add(kullanici_nesnesi);
            }
        }
        catch(java.sql.SQLException e)
        {
            System.out.println("bağlantı kurulamadi........" + e.getMessage());
        }

        return kullanici_listesi;
    }

}
