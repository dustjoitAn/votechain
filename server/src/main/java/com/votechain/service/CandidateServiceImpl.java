package com.votechain.service;

import com.votechain.entity.Candidate;
import com.votechain.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    public List<Candidate> getAllCandidates() {
        List<Candidate> candidates = new ArrayList<>();
        candidateRepository.findAll().forEach(candidate -> candidates.add(candidate));
        return candidates;
    }

    public Candidate getCandidateById(long id) {
        return candidateRepository.findById(id);
    }

    public void saveOrUpdate(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    public void delete(long id) {
        candidateRepository.deleteById(id);
    }
}
