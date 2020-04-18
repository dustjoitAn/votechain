package com.votechain.service;

import com.votechain.entity.Vote;
import com.votechain.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    VoteRepository voteRepository;

    public List<Vote> getAllVotes() {
        List<Vote> votes = new ArrayList<>();
        voteRepository.findAll().forEach(vote -> votes.add(vote));
        return votes;
    }

    public Vote getVoteById(long id) {
        return voteRepository.findById(id);
    }

    public void saveOrUpdate(Vote key) {
        voteRepository.save(key);
    }

    public void delete(long id) {
        voteRepository.deleteById(id);
    }
}
