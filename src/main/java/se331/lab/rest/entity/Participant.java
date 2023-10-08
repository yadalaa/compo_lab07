package se331.lab.rest.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String name;
    String telNo;
    @ManyToMany
    @Builder.Default
    List<Event> eventHistory = new ArrayList<>();
}
