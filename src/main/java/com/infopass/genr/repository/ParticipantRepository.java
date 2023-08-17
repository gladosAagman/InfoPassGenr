package com.infopass.genr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infopass.genr.model.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    // Additional custom query methods can be defined here if needed
}

