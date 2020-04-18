package com.votechain.service;

import com.votechain.entity.Signature;
import com.votechain.repository.SignatureRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class SignatureServiceImpl implements SignatureService {

    @Autowired
    SignatureRepository signatureRepository;

    public List<Signature> getAllSignatures() {
        List<Signature> users = new ArrayList<>();
        signatureRepository.findAll().forEach(user -> users.add(user));
        return users;
    }

    public Signature getSignatureById(long id) {
        return signatureRepository.findById(id);
    }

    public void saveOrUpdate(Signature user) {
        signatureRepository.save(user);
    }

    public void delete(long id) {
        signatureRepository.deleteById(id);
    }
}
