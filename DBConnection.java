package com.hotel.booking.config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class DBConnection {
    private static final Properties CONFIG = new Properties();
    static {
        try (InputStream in = DBConnection.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (in != null) CONFIG.load(in);
        } catch (Exception e) { throw new RuntimeException("Could not read application.properties", e); }
    }
    private DBConnection() {}
    private static String get(String key, String fallback) { return CONFIG.getProperty(key, fallback); }
    public static Connection getConnection() throws SQLException {
        String host = get("db.host", "localhost"), port = get("db.port", "3306");
        String db = get("db.name", "hotel_booking_system");
        String user = get("db.username", "root"), password = get("db.password", "");
        String base = "jdbc:mysql://" + host + ":" + port + "/";
        try (Connection c = DriverManager.getConnection(base, user, password);
             var st = c.createStatement()) { st.executeUpdate("CREATE DATABASE IF NOT EXISTS " + db); }
        return DriverManager.getConnection(base + db + "?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true", user, password);
    }
}
