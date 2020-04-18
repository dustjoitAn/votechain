package com.votechain.entity;

import javax.persistence.*;

@Entity
@Table(name = "the_keys")
public class Key {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
    @Column(name = "bitcoin_public_key")
    private String bitcoinPublicKey;
    @Column(name = "bitcoin_private_key")
    private String bitcoinPrivateKey;
    @Column(name = "bitcoin_address")
    private String bitcoinAddress;
    @Column(name = "is_used")
    private String isUsed;
    @Column(name = "used_for")
     private String usedFor;
    @Column(name = "is_paid")
    private String isPaid;

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public String getBitcoinPublicKey() {
          return bitcoinPublicKey;
     }

     public void setBitcoinPublicKey(String bitcoinPublicKey) {
          this.bitcoinPublicKey = bitcoinPublicKey;
     }

     public String getBitcoinPrivateKey() {
          return bitcoinPrivateKey;
     }

     public void setBitcoinPrivateKey(String bitcoinPrivateKey) {
          this.bitcoinPrivateKey = bitcoinPrivateKey;
     }

     public String getBitcoinAddress() {
          return bitcoinAddress;
     }

     public void setBitcoinAddress(String bitcoinAddress) {
          this.bitcoinAddress = bitcoinAddress;
     }

     public String getUsedFor() {
          return usedFor;
     }

     public void setUsedFor(String usedFor) {
          this.usedFor = usedFor;
     }

}
