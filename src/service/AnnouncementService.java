package service;

import model.Position;
import model.entity.Announcement;

import java.util.List;

public interface AnnouncementService {
    List<Announcement> getAllUserId(int UserId);
    List<Announcement>getAllDescription(String Description);
    List<Announcement>getAllPrice(int Price);
    List<Announcement>getAllTitle(String title);
    List<Position>getAllPosition(Position position);
    void UpdateTitle(int id,String title);
    void UpdateDescription(int id,String description);
    void UpdatePrice(int id,int Price);
    void UpdateUserId(int id,int UserId);

}
