package com.votechain.service;

import com.votechain.entity.Code;
import com.votechain.repository.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CodeServiceImpl implements CodeService {

    @Autowired
    CodeRepository codeRepository;

    public List<Code> getAllCodes() {
        List<Code> codes = new ArrayList<>();
        codeRepository.findAll().forEach(code -> codes.add(code));
        return codes;
    }

    public Code getCodeById(long id) {
        return codeRepository.findById(id);
    }

    public void saveOrUpdate(Code code) {
        codeRepository.save(code);
    }

    public void delete(long id) {
        codeRepository.deleteById(id);
    }
}
