package com.votechain.service;

import com.votechain.entity.Code;

import java.util.List;

public interface CodeService {

    List<Code> getAllCodes();

    Code getCodeById(long id);

    void saveOrUpdate(Code code);

    void delete(long id);
}
