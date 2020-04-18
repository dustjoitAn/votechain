package com.votechain.controller;

import com.votechain.entity.Key;
import com.votechain.service.KeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class KeyController {
    @Autowired
    KeyService keyService;

    @GetMapping("/keys")
    private List<Key> getAllKeySs() {
        return keyService.getAllKeys();
    }

    @GetMapping("/keys/{id}")
    private Key getKey(@PathVariable("id") int id) {
        return keyService.getKeyById(id);
    }

    @DeleteMapping("/keys/{id}")
    private void deleteKey(@PathVariable("id") int id) {
        keyService.delete(id);
    }

    @PostMapping("/keys")
    private long saveKey(@RequestBody Key key) {
        keyService.saveOrUpdate(key);
        return key.getId();
    }
}
