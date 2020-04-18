package com.votechain.repository;

import com.votechain.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    Vote findById(long id);

    void deleteById(long id);
}
