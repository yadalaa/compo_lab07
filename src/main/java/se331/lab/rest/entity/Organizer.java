package se331.lab.rest.entity;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import se331.lab.rest.security.user.User;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String name;
    @OneToMany(mappedBy = "organizer")
    @Builder.Default
    List<Event> ownEvents = new ArrayList<>();
    @OneToOne
    User user;
}
