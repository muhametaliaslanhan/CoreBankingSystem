package org.example;
import java.sql.PreparedStatement;
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

    public void add_user(User kullanici)
    {
        String sql_sorgu = "INSERT INTO Users(first_Name,Last_Name,tc_identity_number) VALUES (?,?,?)";

        try (Connection eklemek_icin_baglanti = DriverManager.getConnection(DatabaseConfig.getDbUrl(),
                DatabaseConfig.getDbUserName(),DatabaseConfig.getDbPassword());
                PreparedStatement ne_olacak = eklemek_icin_baglanti.prepareStatement(sql_sorgu))
        {

            ne_olacak.setString(1,kullanici.getName());
            ne_olacak.setString(2,kullanici.getLastname());
            ne_olacak.setString(3,kullanici.getTc_no());

            ne_olacak.executeUpdate();
            System.out.println("Yeni kullanıcı sisteme eklendi....");


        }catch (java.sql.SQLException e)
        {
            System.out.println("ekleme islemni icin baglanti kurulamadi...");
        }

    }

}
