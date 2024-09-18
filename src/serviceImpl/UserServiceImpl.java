package serviceImpl;

import exception.UserIllegalArgument;
import exception.UserNotFoundException;
import model.Position;
import model.entity.User;

import service.CommonService;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements CommonService<User>, UserService {
    static ArrayList<User> userArrayList = new ArrayList<>();

    static {
        userArrayList.add(new User(1, "Bənövşə Əliyeva", "benovse@example.com", Position.USER, "parol1"));
        userArrayList.add(new User(2, "Ağa Məmmədov", "aga@example.com", Position.USER, "parol2"));
        userArrayList.add(new User(3, "Leyla Quliyeva", "leyla@example.com", Position.USER, "parol3"));
    }

    @Override
    public void add(User object) {
        try{
            userArrayList.add(object);
        }
        catch (UserIllegalArgument ex){
            ex.printStackTrace();
            throw new UserIllegalArgument("siz illgal bir seyler daxil edirsiz");
        }

    }

    @Override
    public void update(int id, Position position) {
        try {
            User user=userArrayList.get(id-1);
            user.setPosition(position);
            userArrayList.add(user);
        }
        catch (UserNotFoundException ex){
            ex.printStackTrace();
            throw new UserNotFoundException("id duzgun daxil ediniz");
        }
        finally {
            System.out.println(" ");
        }

    }

    @Override
    public User getById(int id) {
        try{
            return userArrayList.get(id-1);
        }
        catch (UserNotFoundException ex){
            ex.printStackTrace();
            throw new UserNotFoundException("id tapilmadi");
        }
    }

    @Override
    public List<User> getAll() {
        return userArrayList;
    }

    @Override
    public void delete(int id) {
        try {
            userArrayList.remove(id-1);
        }
        catch (UserNotFoundException ex){
            ex.printStackTrace();
            throw new UserNotFoundException("id tapilmadi");
        }


    }

    @Override
    public List<User> getAllId(int id) {
        try {
            return userArrayList.stream().filter(user -> user.getId() == id).toList();
        } catch (UserNotFoundException ex) {
            throw new UserNotFoundException("bu id de User yoxdur");
        }
    }

    @Override
    public List<Position> getAllPosition(Position position) {
        return userArrayList.stream()
                .filter(user -> user.getPosition().equals(position))
                .map(User::getPosition)
                .toList();
    }

    @Override
    public List<User> getAllEmail(String email) {
        return userArrayList.stream().filter(user -> user.getEmail().equals(email)).toList();
    }

    @Override
    public void UpdateFullName(int id, String fullname) {
        try {
            User user = userArrayList.get(id - 1);
            user.setFullName(fullname);
            userArrayList.add(user);
        } catch (UserNotFoundException ex) {
            ex.printStackTrace();
            throw new UserNotFoundException("id tapilmadi");


        }

    }
        @Override
        public void UpdateEmail ( int id, String email){
            try {
                User user = userArrayList.get(id - 1);
                user.setEmail(email);
                userArrayList.add(user);
            } catch (UserNotFoundException ex) {
                ex.printStackTrace();
                throw new UserNotFoundException("id tapilmadi");


            }
        }
    }


