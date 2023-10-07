package se331.lab.rest.entity;
import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class Organizer{
    Long id;
    String category;
    String title;
    String description;
    String location;
    String date;
    String time;
    Boolean petAllowed;
    String organizer;
}
