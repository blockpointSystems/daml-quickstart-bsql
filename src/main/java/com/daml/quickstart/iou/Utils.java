package com.daml.quickstart.iou;
import java.sql.Connection;
import java.sql.DriverManager;

public class Utils {
    public Connection connect() {
        Connection c;
        try {
            c = DriverManager.getConnection("jdbc:mdb://{your public bSQL IP address}:5461/iou?user={your bSQL username}&password={your bSQL password}");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
            return null;
        }
        System.out.println("Successfully connected to bSQL!");
        return  c;
    }
}
