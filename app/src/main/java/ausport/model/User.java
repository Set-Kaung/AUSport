package ausport.model;

import ausport.util.PasswordHelper;



public class User {
    private String username;
    private PasswordHelper password;
    private Role role;
    
    public User(String studentID){
        this.username = studentID;
    }
    public User(String username, PasswordHelper password, Role role){
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    

    public PasswordHelper getPassword() {
        return password;
    }

    public void setPassword(PasswordHelper password) {
        this.password = password;
    }

    public Role getRole(){
        return this.role;
    }
    
}
