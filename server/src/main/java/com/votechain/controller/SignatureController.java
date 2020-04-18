package com.votechain.controller;

import com.votechain.entity.Signature;
import com.votechain.service.SignatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class SignatureController {

    @Autowired
    SignatureService signatureService;

    @GetMapping("/signatures")
    private List<Signature> getAllSignatures() {
        return signatureService.getAllSignatures();
    }

    @GetMapping("/signatures/{id}")
    private Signature getSignature(@PathVariable("id") int id) {
        return signatureService.getSignatureById(id);
    }

    @DeleteMapping("/signatures/{id}")
    private void deleteSignature(@PathVariable("id") int id) {
        signatureService.delete(id);
    }

    @PostMapping("/signatures")
    private long saveSignature(@RequestBody Signature signature) {
        signatureService.saveOrUpdate(signature);
        return signature.getId();
    }
}
