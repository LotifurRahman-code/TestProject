package com.lotifurrahman.navigationdrawer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

import com.lotifurrahman.navigationdrawer.QuranContract.*;

public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "myquran.db";
    private static final int DATABASE_VERSION = 3;

    final String CREATE_TABLE_SURAH_LIST = "CREATE TABLE " +
            QuranWithAyatTable.SURAH_LIST_TABLE_NAME + " ( " +
            QuranWithAyatTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            QuranWithAyatTable.COLUMN_SURAH_NO + " INTEGER UNIQUE, " +
            QuranWithAyatTable.COLUMN_SURAH_NAME + " VARCHAR(250), " +
            QuranWithAyatTable.COLUMN_SURAH_DESCENDCLASS + " VARCHAR(150), " +
            QuranWithAyatTable.COLUMN_SURAH_TOTALAYAT + " INTEGER " +
            ")";

    private static final String SELECT_ALL_SURAH_LIST = "SELECT * FROM " + QuranWithAyatTable.SURAH_LIST_TABLE_NAME;

    public SQLiteDatabase db;
    Context context;

    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        db.execSQL(CREATE_TABLE_SURAH_LIST);
        fillSurahListable();

        Toast.makeText(context, "onCreate - লোড হচ্ছে..", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuranWithAyatTable.SURAH_LIST_TABLE_NAME);
        Toast.makeText(context, "onUpgrade - নতুন ভার্শন এ আপডেট করার জন্য ধনবাদ।।", Toast.LENGTH_SHORT).show();
        onCreate(db);
    }

    public long addSurahList(MainList mainList) {
        ContentValues cv = new ContentValues();
        cv.put(QuranWithAyatTable.COLUMN_SURAH_NO, mainList.getSurah_no());
        cv.put(QuranWithAyatTable.COLUMN_SURAH_NAME, mainList.getSurah_name());
        cv.put(QuranWithAyatTable.COLUMN_SURAH_DESCENDCLASS, mainList.getSurah_class());
        cv.put(QuranWithAyatTable.COLUMN_SURAH_TOTALAYAT, mainList.getSurah_total_ayat());

        long rowId = db.insert(QuranWithAyatTable.SURAH_LIST_TABLE_NAME, null, cv);
        return rowId;
    }

    public ArrayList<MainList> getAllSuraList() {
        ArrayList<MainList> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_ALL_SURAH_LIST, null);

        while (cursor.moveToNext()) {
            int ID = cursor.getInt(0);
            int Surah_No = cursor.getInt(1);
            String Surah_Name = cursor.getString(2);
            String Surah_Class = cursor.getString(3);
            int Surah_Total_ayat = cursor.getInt(4);

            MainList mainList = new MainList(Surah_No, Surah_Name, Surah_Class, Surah_Total_ayat);
            arrayList.add(mainList);
        }
        return arrayList;
    }

    private void fillSurahListable() {
        MainList surah1 = new MainList(1, "রফিক সাহেব ঠিক করলেন, ছেলের বিয়ে দেবেন। ছেলেকে গিয়ে বললেন, শোন, আমি ঠিক করেছি তোর বিয়ে দেবো। পাত্রীও ঠিক।\n" +
                "ছেলে : কিন্তু বাবা আমি তো নিজের পছন্দে বিয়ে করতে চাই!\n" +
                "প্রেসিডেন্ট : তাহলে আমি রাজি!\n", "মক্কা", 7);
        addSurahList(surah1);
    }

}
