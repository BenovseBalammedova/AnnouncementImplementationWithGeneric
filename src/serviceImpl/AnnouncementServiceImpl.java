package serviceImpl;

import exception.AnnouncementIllegalArgument;
import exception.AnnouncementNotFoundException;
import model.Position;
import model.entity.Announcement;
import service.AnnouncementService;
import service.CommonService;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementServiceImpl implements CommonService<Announcement>, AnnouncementService {
    static ArrayList<Announcement>announcementlist=new ArrayList<>();
    static {
        announcementlist.add(new Announcement(1, "Telefon satılır, yaxşı vəziyyətdə", 300, "Telefon", Position.PREMIUM));
        announcementlist.add(new Announcement(2, "Ev kirayə verilir, mərkəzdə", 500, "Ev Kirayə", Position.ARCHIVED));
        announcementlist.add(new Announcement(3, "İş elanları, təcrübəli proqramçı axtarılır", 0, "İş Elanı", Position.STANDARD));
        announcementlist.add(new Announcement(4, "Mebel satılır, yeni kimi", 200, "Mebel", Position.STANDARD));
    }
    @Override
    public List<Announcement> getAllUserId(int UserId) {
        try {
            return announcementlist.stream().map(announcement -> new Announcement(announcement.getUserId(), announcement.getDescription(), announcement.getPrice(),announcement.getTitle(),Position.STANDARD))
                    .filter(announcement -> announcement.getUserId() == UserId).toList();
        }
        catch (AnnouncementNotFoundException ex){
            ex.printStackTrace();
            throw new AnnouncementNotFoundException("bele bir userid yoxdur");
        }
    }

    @Override
    public List<Announcement> getAllDescription(String Description) {

            return announcementlist.stream().filter(announcement ->announcement.getDescription().equals(Description)).toList();



    }

    @Override
    public List<Announcement> getAllPrice(int Price) {
        return announcementlist.stream().map(announcement -> new Announcement(announcement.getUserId(), announcement.getDescription(), announcement.getPrice(),announcement.getTitle(),Position.PREMIUM))
                .filter(announcement -> announcement.getPrice() == Price).toList();
    }

    @Override
    public List<Announcement> getAllTitle(String title) {
        return announcementlist.stream().filter(announcement -> announcement.getTitle().equals(title)).toList();
    }

    @Override
    public List<Position> getAllPosition(Position position) {
        return announcementlist.stream()
                .filter(announcement -> announcement.getPosition().equals(position))
                .map(Announcement::getPosition)
                .toList();
    }

    @Override
    public void UpdateTitle(int id, String title) {
        try{
            Announcement announcement=announcementlist.get(id-1);
            announcement.setTitle(title);
            announcementlist.add(announcement);
        }
        catch (AnnouncementNotFoundException ex){
            ex.printStackTrace();
            throw new AnnouncementNotFoundException("id tapilmadi");
        }


    }

    @Override
    public void UpdateDescription(int id, String description) {

        try{
            Announcement announcement=announcementlist.get(id-1);
            announcement.setDescription(description);
            announcementlist.add(announcement);
        }
        catch (AnnouncementNotFoundException ex){
            ex.printStackTrace();
            throw new AnnouncementNotFoundException("id tapilmadi");
        }

    }

    @Override
    public void UpdatePrice(int id, int Price) {

        try{
            Announcement announcement=announcementlist.get(id-1);
            announcement.setPrice(Price);
            announcementlist.add(announcement);
        }
        catch (AnnouncementNotFoundException ex){
            ex.printStackTrace();
            throw new AnnouncementNotFoundException("bele bir id yoxdu");
        }
    }

    @Override
    public void UpdateUserId(int id, int UserId) {
        try {
            Announcement announcement=announcementlist.get(id-1);
            announcement.setUserId(UserId);
            announcementlist.add(announcement);
        }
        catch (AnnouncementNotFoundException ex){
            ex.printStackTrace();
            throw  new AnnouncementNotFoundException("bele bir id tapilmadi");
        }

    }

    @Override
    public void add(Announcement object) {
        try {
            announcementlist.add(object);
        }
        catch(AnnouncementIllegalArgument ex){
            ex.printStackTrace();
            throw new AnnouncementIllegalArgument("Verilenleri duzgun daxil edin illegal bir sey daxil etmeyin");
        }
        finally {
            System.out.println(" ");
        }

    }

    @Override
    public void update(int id,Position position) {
        try {
            Announcement announcement=announcementlist.get(id-1);
            announcement.setPosition(position);
            announcementlist.add(announcement);
        }
        catch (AnnouncementNotFoundException ex){
            ex.printStackTrace();
            throw new AnnouncementNotFoundException("id duzgun daxil ediniz");
        }
        finally {
            System.out.println(" ");
        }

    }

    @Override
    public Announcement getById(int id) {
        try {
            return announcementlist.get(id-1);

        }

        catch (AnnouncementNotFoundException ex){
            ex.printStackTrace();
            throw new AnnouncementNotFoundException("bele bir elan yoxdur ");
        }
        finally {
            System.out.println(" ");
        }

    }

    @Override
    public List<Announcement> getAll() {
        return announcementlist;
    }

    @Override
    public void delete(int id) {
        try {
            announcementlist.remove(id-1);
        }
        catch (AnnouncementNotFoundException ex){
            ex.printStackTrace();
            throw new AnnouncementNotFoundException("bele bir id li elan yoxdur");
        }
        finally {
            System.out.println(" ");
        }
    }
}
