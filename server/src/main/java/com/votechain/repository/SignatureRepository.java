package com.votechain.repository;

import com.votechain.entity.Signature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignatureRepository extends JpaRepository<Signature, Long> {

    Signature findById(long id);

    void deleteById(long id);

}
