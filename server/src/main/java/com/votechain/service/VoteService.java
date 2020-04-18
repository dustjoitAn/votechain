package com.votechain.service;

import com.votechain.entity.Vote;

import java.util.List;

public interface VoteService {

    List<Vote> getAllVotes();

    Vote getVoteById(long id);

    void saveOrUpdate(Vote vote);

    void delete(long id);
}
