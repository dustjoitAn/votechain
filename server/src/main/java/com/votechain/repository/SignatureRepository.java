package com.votechain.repository;

import com.votechain.entity.Signature;
import com.votechain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignatureRepository extends JpaRepository<Signature, Long> {

    Signature findById(long id);

    void deleteById(long id);

}
