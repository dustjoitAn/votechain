package com.votechain.service;

import com.votechain.entity.Signature;

import java.util.List;

public interface SignatureService {

    List<Signature> getAllSignatures();

    Signature getSignatureById(long id);

    void saveOrUpdate(Signature signature);

    void delete(long id);
}
