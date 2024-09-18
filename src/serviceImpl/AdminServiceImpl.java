package serviceImpl;

import exception.AdminIllegalArgument;
import exception.AdminNotFoundException;

import model.Position;

import model.entity.User;
import service.AdminService;
import service.CommonService;


import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements CommonService<User>, AdminService {
    static ArrayList<User> adminArrayList = new ArrayList<>();

    static {
        adminArrayList.add(new User(1, "Bənövşə Əliyeva", "benovse@example.com", Position.ADMIN, "parol1"));
        adminArrayList.add(new User(2, "Ağa Məmmədov", "aga@example.com", Position.ADMIN, "parol2"));
        adminArrayList.add(new User(3, "Leyla Quliyeva", "leyla@example.com", Position.ADMIN, "parol3"));
    }

    @Override
    public List<User> getAllId(int id) {
        try {
            return adminArrayList.stream().filter(admin -> admin.getId() == id).toList();
        }
        catch (AdminNotFoundException ex){
            throw new AdminNotFoundException("bu id de admin yoxdur");
        }
    }

    @Override
    public List<Position> getAllPosition(Position position) {
        return adminArrayList.stream()
                .filter(admin -> admin.getPosition().equals(position))
                .map(User::getPosition)
                .toList();
    }

    @Override
    public List<User> getAllEmail(String email) {
        return adminArrayList.stream().filter(admin->admin.getEmail().equals(email)).toList();
    }

    @Override
    public void UpdateFullName(int id, String fullname) {
        try{
            User user=adminArrayList.get(id-1);
            user.setFullName(fullname);
            adminArrayList.add(user);
        }
        catch (AdminNotFoundException ex){
            ex.printStackTrace();
            throw new AdminNotFoundException("id tapilmadi");
        }

    }

    @Override
    public void UpdateEmail(int id, String email) {
        try{
            User user=adminArrayList.get(id-1);
            user.setFullName(email);
            adminArrayList.add(user);
        }
        catch (AdminNotFoundException ex){
            ex.printStackTrace();
            throw new AdminNotFoundException("id tapilmadi");
        }

    }


    @Override
    public void add(User object) {
        try{
            adminArrayList.add(object);
        }
        catch (AdminIllegalArgument ex){
            ex.printStackTrace();
            throw new AdminIllegalArgument("siz illgal bir seyler daxil edirsiz");
        }

    }

    @Override
    public void update(int id,Position position) {
        try {
            User admin=adminArrayList.get(id-1);
            admin.setPosition(position);
            adminArrayList.add(admin);
        }
        catch (AdminNotFoundException ex){
            ex.printStackTrace();
            throw new AdminNotFoundException("id duzgun daxil ediniz");
        }
        finally {
            System.out.println(" ");
        }

    }

    @Override
    public User getById(int id) {
        try{
            return adminArrayList.get(id-1);
        }
        catch (AdminNotFoundException ex){
            ex.printStackTrace();
            throw new AdminNotFoundException("id tapilmadi");
        }
    }

    @Override
    public List<User> getAll() {
        return adminArrayList;
    }

    @Override
    public void delete(int id) {
        try {
            adminArrayList.remove(id-1);
        }
        catch (AdminNotFoundException ex){
            ex.printStackTrace();
            throw new AdminNotFoundException("id tapilmadi");
        }

    }
}