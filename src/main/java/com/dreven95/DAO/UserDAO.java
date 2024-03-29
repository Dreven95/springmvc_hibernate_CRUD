package com.dreven95.DAO;

import com.dreven95.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {
    public List<User> getAllUsers();
    public void saveUser(User user);
    public User getUser(int id);
    public void deleteUser(int id);
}
