package com.votechain.repository;

import com.votechain.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    Candidate findById(long id);

    void deleteById(long id);
}
