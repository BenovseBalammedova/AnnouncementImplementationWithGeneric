package service;

import model.Position;

import java.util.List;

public interface CommonService <T>{
    void add(T object);
    void update (int id, Position position);
    T getById(int id);
    List<T> getAll();
    void delete(int id);

}
