package com.votechain.controller;

import com.votechain.entity.Candidate;
import com.votechain.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CandidateController {
    @Autowired
    CandidateService candidateService;

    @GetMapping("/candidates")
    private List<Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    @GetMapping("/candidates/{id}")
    private Candidate getCandidate(@PathVariable("id") int id) {
        return candidateService.getCandidateById(id);
    }

    @DeleteMapping("/candidates/{id}")
    private void deleteCandidate(@PathVariable("id") int id) {
        candidateService.delete(id);
    }

    @PostMapping("/candidates")
    private long saveCandidate(@RequestBody Candidate candidate) {
        candidateService.saveOrUpdate(candidate);
        return candidate.getId();
    }
}
