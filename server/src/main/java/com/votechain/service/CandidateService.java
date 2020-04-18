package com.votechain.service;

import com.votechain.entity.Candidate;

import java.util.List;

public interface CandidateService {

    List<Candidate> getAllCandidates();

    Candidate getCandidateById(long id);

    void saveOrUpdate(Candidate candidate);

    void delete(long id);
}
