package com.votechain.repository;

import com.votechain.entity.Code;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeRepository extends JpaRepository<Code, Long> {

    Code findById(long id);

    void deleteById(long id);
}
