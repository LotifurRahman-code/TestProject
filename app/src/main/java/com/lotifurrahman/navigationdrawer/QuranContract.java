package com.lotifurrahman.navigationdrawer;

import android.provider.BaseColumns;


public class QuranContract {
    private QuranContract(){};

    public static class QuranWithAyatTable implements BaseColumns {
        public static final String SURAH_WITH_AYAT_TABLE_NAME = "surah_with_ayat";
        public static final String _ID = "id";
        public static final String COLUMN_SURAH_NO = "surah_no";
        public static final String COLUMN_SURAH_ARABIC = "surah_arabic";
        public static final String COLUMN_SURAH_BANGLA = "surah_bangla";
        public static final String COLUMN_SURAH_ENGLISH = "surah_english";
        public static final String COLUMN_SURAH_AYAT_NO = "surah_ayat_no";

        public static final String SURAH_LIST_TABLE_NAME = "surah_list";
        public static final String COLUMN_SURAH_NAME = "surah_name";
        public static final String COLUMN_SURAH_DESCENDCLASS = "surah_class";
        public static final String COLUMN_SURAH_TOTALAYAT = "surah_ayat";

    }
}

