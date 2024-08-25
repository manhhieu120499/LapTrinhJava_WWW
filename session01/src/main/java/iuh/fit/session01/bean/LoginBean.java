package iuh.fit.session01.bean;

import iuh.fit.session01.connect.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginBean {

    /*
     * des: function checkLogin user
     * params: us, pws
     * return 1: login user success
     * return 0 : password invalid
     * return -1 : username or password invalid
     * */
    public int login(String us, String pws) {
        String user = "";
        String password = "";
        try{
            Class.forName ("org.mariadb.jdbc.Driver");
            ConnectDB driver = new ConnectDB();
            Connection con = driver.getConnection();
            String sql = "select * from user where username= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, us);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                user = rs.getString("username");
                password = rs.getString("password");
            }
            con.close();
        }catch(Exception e) {
            e.printStackTrace();
        }

        if(user.equals(us)) {
            if(pws.equals(password)) {
                return 1;
            }else {
                return 0;
            }
        }
        return -1;
    }
}
