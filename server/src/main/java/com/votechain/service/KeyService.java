package com.votechain.service;

import com.votechain.entity.Key;

import java.util.List;

public interface KeyService {
    List<Key> getAllKeys();

    Key getKeyById(long id);

    void saveOrUpdate(Key key);

    void delete(long id);
}
