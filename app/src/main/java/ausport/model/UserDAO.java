package ausport.model;

import java.util.List;

public interface UserDAO extends DAO {
    public long insertUser(User u);
    public boolean updateUser(User u);
    public boolean deleteUser(User u);

    public List<User> getAll();
    
}
