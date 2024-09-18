package service;

import model.Position;
import model.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllId(int id);
    List<Position>getAllPosition(Position position);
    List<User>getAllEmail(String email);

    void UpdateFullName(int id,String fullname);
    void UpdateEmail(int id,String email);

}
