package utils;

import POJO.test.ContactUs;

import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    public Connection dbConnect() throws ClassNotFoundException, SQLException {
        Class.forName("com.myslq.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql//localhost:1111/dummy","root","root");
    }

    public List<ContactUs> getContactUsByEmail(String email){
        List<ContactUs> contacts = new ArrayList<>();
        try{
            Connection conn = dbConnect();

            PreparedStatement statement = conn.prepareStatement("SELECT * FROM contact_us WHERE email=?");
            statement.setString(1,email);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                ContactUs cu = new ContactUs();
                cu.setEmail(rs.getString("email"));
                cu.setMessage(rs.getString("message"));
                cu.setDate(rs.getDate("date"));
                contacts.add(cu);
            }
            conn.close();
        }catch(Exception e){
            Logger.Error("Error connecting to DB: "+e);
        }
        return contacts;
    }
}
