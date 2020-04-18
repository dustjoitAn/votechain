package com.votechain.service;

import com.votechain.entity.Key;
import com.votechain.repository.KeyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class KeyServiceImpl implements KeyService {

    @Autowired
    KeyRepository keyRepository;

    public List<Key> getAllKeys() {
        List<Key> keys = new ArrayList<>();
        keyRepository.findAll().forEach(key -> keys.add(key));
        return keys;
    }

    public Key getKeyById(long id) {
        return keyRepository.findById(id);
    }

    public void saveOrUpdate(Key key) {
        keyRepository.save(key);
    }

    public void delete(long id) {
        keyRepository.deleteById(id);
    }
}
