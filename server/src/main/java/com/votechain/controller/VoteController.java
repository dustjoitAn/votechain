package com.votechain.controller;

import com.votechain.entity.Vote;
import com.votechain.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class VoteController {

    @Autowired
    VoteService userServiceImpl;

    @GetMapping("/votes")
    private List<Vote> getAllVotes() {
        return userServiceImpl.getAllVotes();
    }

    @GetMapping("/votes/{id}")
    private Vote getVote(@PathVariable("id") int id) {
        return userServiceImpl.getVoteById(id);
    }

    @DeleteMapping("/votes/{id}")
    private void deleteVote(@PathVariable("id") int id) {
        userServiceImpl.delete(id);
    }

    @PostMapping("/votes")
    private long savePerson(@RequestBody Vote vote) {
        userServiceImpl.saveOrUpdate(vote);
        return vote.getId();
    }
}
