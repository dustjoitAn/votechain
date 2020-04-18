package com.votechain.controller;

import com.votechain.entity.Code;
import com.votechain.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CodeController {
    @Autowired
    CodeService codeService;

    @GetMapping("/codes")
    private List<Code> getAllCodes() {
        return codeService.getAllCodes();
    }

    @GetMapping("/codes/{id}")
    private Code getCode(@PathVariable("id") int id) {
        return codeService.getCodeById(id);
    }

    @DeleteMapping("/codes/{id}")
    private void deleteCode(@PathVariable("id") int id) {
        codeService.delete(id);
    }

    @PostMapping("/codes")
    private long saveCode(@RequestBody Code code) {
        codeService.saveOrUpdate(code);
        return code.getId();
    }
}
