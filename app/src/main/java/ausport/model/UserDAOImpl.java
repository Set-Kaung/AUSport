package ausport.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ausport.util.PasswordHelper;


public class UserDAOImpl implements UserDAO {
    private Connection connection;
    
    @Override
    public void setup() throws Exception {
       connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AUSport", "au_admin", "admin1234");
        
    }

    @Override
    public boolean checkConnection() throws Exception {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AUSport", "au_admin", "admin1234");
        return false;
    }

    @Override
    public void close() throws Exception {
       if(connection.isValid(3)){
            connection.close();
       }
       try {
        DriverManager.getConnection("jdbc:mysql://localhost:3306/AUSport?shutdown=true", "au_admin", "admin1234");
    }
    catch (Exception e) {
        e.printStackTrace();
    }
    }

    @Override
    public long insertUser(User u) {
        String query = "INSERT INTO users (username,hash,salt,role) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, u.getUsername());
            stmt.setBytes(2, u.getPassword().getHash());
            stmt.setBytes(3,u.getPassword().getSalt());
            stmt.setString(4, u.getRole().toString());
            long rows = stmt.executeUpdate();
            return rows;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return 0;
    }

    @Override
    public long updateUser(User u) {
        return 0;
    }

    @Override
    public long deleteUser(User u) {
       return 0;
    }

    @Override
    public List<User> getAll() {
        String query = "SELECT * FROM users";
        List<User>  users = new ArrayList<>();
        try{
            Statement stmt = connection.createStatement();
            ResultSet s = stmt.executeQuery(query);
            while(s.next()){
                String username = s.getString("username");
                byte[] hash = s.getBytes("hash");
                byte[] salt = s.getBytes("salt");
                String role = s.getString("role");
                User u = new User(username, new PasswordHelper(hash, salt), Role.getRole(role));
                users.add(u);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return users;
    }

}
