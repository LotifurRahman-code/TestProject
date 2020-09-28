package com.lotifurrahman.navigationdrawer;

public class MainList {

    private int id;
    private int surah_no;
    private String surah_name;
    private String surah_class;
    private int surah_total_ayat;

    MainList() {}

    public MainList(int surah_no, String surah_name, String surah_class, int surah_total_ayat) {
        this.surah_no = surah_no;
        this.surah_name = surah_name;
        this.surah_class = surah_class;
        this.surah_total_ayat = surah_total_ayat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSurah_no() {
        return surah_no;
    }

    public void setSurah_no(int surah_no) {
        this.surah_no = surah_no;
    }

    public String getSurah_name() {
        return surah_name;
    }

    public void setSurah_name(String surah_name) {
        this.surah_name = surah_name;
    }

    public String getSurah_class() {
        return surah_class;
    }

    public void setSurah_class(String surah_class) {
        this.surah_class = surah_class;
    }

    public int getSurah_total_ayat() {
        return surah_total_ayat;
    }

    public void setSurah_total_ayat(int surah_total_ayat) {
        this.surah_total_ayat = surah_total_ayat;
    }
}
