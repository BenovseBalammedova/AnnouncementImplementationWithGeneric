package model.entity;

import model.Position;

public class User {
    private int id;
    private String fullName;
    private String email;
    private Position position;
    private String parol;

    public User() {
    }

    public User(int id, String fullName, String email, Position position, String parol) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.position = position;
        this.parol = parol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getParol() {
        return parol;
    }

    public void setParol(String parol) {
        this.parol = parol;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", position=" + position +
                ", parol='" + parol + '\'' +
                '}';
    }
}
