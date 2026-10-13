package org.example;

public class User {
    int id;
    String name;
    String lastname;
    String tc_no;

    public User(int anahtar_id,String isim, String soyisim ,String kimlik_no)
    {
        id = anahtar_id;
        name= isim;
        lastname=soyisim;
        tc_no= kimlik_no;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTc_no() {
        return tc_no;
    }

    public void setTc_no(String tc_no) {
        this.tc_no = tc_no;
    }
}
