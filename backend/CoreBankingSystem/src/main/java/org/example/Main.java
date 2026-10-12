package org.example;
import java.sql.Connection;
import java.sql.DriverManager;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
   public static void main(String[] args) {
        try(Connection baglanti = DriverManager.getConnection(DatabaseConfig.getDbUrl(), DatabaseConfig.getDbUserName(),
                DatabaseConfig.getDbPassword()))
        {
            System.out.println("Acildi ulan.....");
            java.sql.Statement birinci_nesne=baglanti.createStatement();

            java.sql.ResultSet sorgu_sonuc=birinci_nesne.executeQuery("SELECT * FROM users");
            while (sorgu_sonuc.next())
            {
                System.out.println(sorgu_sonuc.getString("first_name")+" "+sorgu_sonuc.getString("last_name"));
            }
        }
        catch(java.sql.SQLException e)
        {
            System.out.println("bağlantı kurulamadi........" + e.getMessage());
        }
    }
}
