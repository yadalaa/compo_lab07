package se331.lab.rest.config;

import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.Participant;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrganizerRepository;
import se331.lab.rest.repository.ParticipantRepository;
import se331.lab.rest.security.user.*;
import se331.lab.rest.security.user.User;
import se331.lab.rest.security.user.UserRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static se331.lab.rest.security.user.Role.ROLE_ADMIN;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;
    @Autowired
    final ParticipantRepository participantRepository;
    final UserRepository userRepository;


    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Participant p1,p2,p3,p4,p5;
        p1 = participantRepository.save(Participant.builder()
                        .name("Kiki")
                        .telNo("01")
                        .build());
        p2 = participantRepository.save(Participant.builder()
                .name("Kuku")
                .telNo("02")
                .build());
        p3 = participantRepository.save(Participant.builder()
                .name("Kaka")
                .telNo("03")
                .build());
        p4 = participantRepository.save(Participant.builder()
                .name("Koko")
                .telNo("04")
                .build());
        p5 = participantRepository.save(Participant.builder()
                .name("Keke")
                .telNo("05")
                .build());
        Organizer org1,org2,org3;
                org1 = organizerRepository.save(Organizer.builder()
                                .name("CAMT").build());
                org2 = organizerRepository.save(Organizer.builder()
                                .name("CMU").build());
                org3 = organizerRepository.save(Organizer.builder()
                                .name("ChiangMai").build());
                Event tempEvent;
                tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .build());
                tempEvent.setOrganizer(org1);
                org1.getOwnEvents().add(tempEvent);
             p1.getEventHistory().add(tempEvent);
             p2.getEventHistory().add(tempEvent);
             p3.getEventHistory().add(tempEvent);
                tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for taking the exam")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petAllowed(false)
                .build());
                tempEvent.setOrganizer(org1);
                org1.getOwnEvents().add(tempEvent);
            p1.getEventHistory().add(tempEvent);
            p2.getEventHistory().add(tempEvent);
            p3.getEventHistory().add(tempEvent);
                tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .build());
                tempEvent.setOrganizer(org2);
                org2.getOwnEvents().add(tempEvent);
            p1.getEventHistory().add(tempEvent);
            p2.getEventHistory().add(tempEvent);
            p4.getEventHistory().add(tempEvent);
                tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00-6.00 pm.")
                .petAllowed(false)
                .build());
                tempEvent.setOrganizer(org3);
                org3.getOwnEvents().add(tempEvent);
            p3.getEventHistory().add(tempEvent);
            p4.getEventHistory().add(tempEvent);
            p5.getEventHistory().add(tempEvent);
            addUser();
            org1.setUser(user1);
            user1.setOrganizer(org1);
            org2.setUser(user2);
            user2.setOrganizer(org2);
            org3.setUser(user3);
            user3.setOrganizer(org3);
    }
    User user1, user2, user3;
    private void addUser() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        user1 = User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01
                ,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user2 = User.builder()
                .username("user")
                .password(encoder.encode("admin"))
                .firstname("user")
                .lastname("user")
                .email("enabled@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01
                        ,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user3 = User.builder()
                .username("disableUser")
                .password(encoder.encode("disableUser"))
                .firstname("disableUser")
                .lastname("disableUser")
                .email("disableUser@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01
                        ,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user1.getRoles().add(ROLE_ADMIN);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

    }
}
