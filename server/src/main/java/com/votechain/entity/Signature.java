package com.votechain.entity;

import javax.persistence.*;

@Entity
@Table(name = "signature")
public class Signature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sigHash;
    private String sigMsg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigHash() {
        return sigHash;
    }

    public void setSigHash(String sigHash) {
        this.sigHash = sigHash;
    }

    public String getSigMsg() {
        return sigMsg;
    }

    public void setSigMsg(String sigMsg) {
        this.sigMsg = sigMsg;
    }
}
