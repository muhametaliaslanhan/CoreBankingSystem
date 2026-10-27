package org.example;
import java.lang.classfile.instruction.SwitchCase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        UserDao userdao_liste=new UserDao();

        Scanner input_alma = new Scanner(System.in);

        islemDongusu:while(true) {

            List<User> gelen_kullanicilar= userdao_liste.gettAllUsers();
            System.out.println("1.Veri tabanında olanları gormek icin"+"\n"+"2.Veri tabanina kullanici eklemek icim"+"\n"+"Cikis");
            int secim_sayisi = input_alma.nextInt();

            switch (secim_sayisi) {
                case 1:

                    for (User u : gelen_kullanicilar) {
                        System.out.println(u.getId() + "-" + u.getName() + " " + u.getLastname() + "-" + u.getTc_no());
                    }
                    break;

                case 2:
                    int id_max_bulmak_icin_hersey = id_belirleme_fonksiyon();
                    System.out.println("kullanici ismi giriniz...");
                    input_alma.nextLine();
                    String isim = input_alma.nextLine();
                    System.out.println("kullanici soyismi giriniz...");
                    String soyisim = input_alma.nextLine();
                    System.out.println("kullanici TC kimlik numarasi giriniz...");
                    String tc_kimlik_no = input_alma.nextLine();

                    User yeni_kullanici = new User(id_max_bulmak_icin_hersey, isim, soyisim, tc_kimlik_no);

                    System.out.println("Eklenen yeni kullanici:" + "\n"
                            + yeni_kullanici.getId() + "-" + yeni_kullanici.getName() + " " + yeni_kullanici.getLastname()
                            + "-" + yeni_kullanici.getTc_no());

                    UserDao eklenicek_kullanici = new UserDao();
                    eklenicek_kullanici.add_user(yeni_kullanici);

                    break;

                case 3:
                    System.out.println("Çıkış yapılıyor.....");
                    break islemDongusu;
            }
        }
    }

    public static int id_belirleme_fonksiyon()
    {
        int id_max=0;
        UserDao userdao_veri_tabani_erisimi =new UserDao();
        List<User> kullanici_listesi= userdao_veri_tabani_erisimi.gettAllUsers();

        for (User u : kullanici_listesi) {
            id_max = u.getId();
        }

        return id_max+1;
    }
}
