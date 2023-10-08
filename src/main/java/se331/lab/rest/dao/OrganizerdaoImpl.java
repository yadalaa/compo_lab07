package se331.lab.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.OrganizerRepository;

import java.util.Optional;


@Repository
@RequiredArgsConstructor

public class OrganizerdaoImpl implements OrganizerDao {
    final OrganizerRepository organizerRepository;

    @Override
    public Page<Organizer> getOrganizer(Pageable pageRequest) {
        return organizerRepository.findAll(pageRequest);
    }

    @Override
    public Optional<Organizer> findById(Long id) {
        return organizerRepository.findById(id);
    }


}

