package org.example;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class DatabaseConfig
{
    private static final Properties ozellikler = new Properties();

    static
    {
        try (InputStream input=DatabaseConfig.class.getClassLoader().getResourceAsStream("db.properties"))
        {
            if (input == null)
            {
                System.out.println("db.properties adında bir dosya bulunamadı...");
                System.exit(1);
            }
            ozellikler.load(input);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static String getDbUrl()
    {
        return ozellikler.getProperty("db.url");
    }

    public static String getDbUserName()
    {
        return ozellikler.getProperty("db.username");
    }

    public static String getDbPassword()
    {
        return ozellikler.getProperty("db.password");
    }

}
