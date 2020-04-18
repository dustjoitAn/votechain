package com.votechain.repository;

import com.votechain.entity.Key;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyRepository extends JpaRepository<Key, Long> {
    Key findById(long id);

    void deleteById(long id);
}
