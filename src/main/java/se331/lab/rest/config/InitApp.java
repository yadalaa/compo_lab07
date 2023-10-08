package se331.lab.rest.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.Participant;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrganizerRepository;
import se331.lab.rest.repository.ParticipantRepository;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;
    final ParticipantRepository participantRepository;
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
    }

}
