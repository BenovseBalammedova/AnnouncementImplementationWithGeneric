package model.entity;

import model.Position;

public class Announcement {
    private int userId;
    private String description;
    private int price;
    private String title;
    private Position position;

    public Announcement() {
    }

    public Announcement(int userId, String description, int price, String title, Position position) {
        this.userId = userId;
        this.description = description;
        this.price = price;
        this.title = title;
        this.position = position;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "userId=" + userId +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", position=" + position +
                '}';
    }
}
