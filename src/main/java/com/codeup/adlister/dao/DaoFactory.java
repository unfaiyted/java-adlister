package com.codeup.adlister.dao;

import com.codeup.adlister.Config;

public class DaoFactory {
    private static Ads adsDao;
    private static Config config = new Config(
            "jdbc:mysql://localhost:3306/adlister_db?serverTimezone=UTC&useSSL=false",
            "adlister",
            "codeup");

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }
}
