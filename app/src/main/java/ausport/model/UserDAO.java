package ausport.model;

import java.util.List;

public interface UserDAO extends DAO {
    public long insertUser(User u);
    public long updateUser(User u);
    public long deleteUser(User u);

    public List<User> getAll();
    
}


