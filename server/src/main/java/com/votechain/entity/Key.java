package com.votechain.entity;

import javax.persistence.*;

@Entity
@Table(name = "key")
public class Key {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String bitcoinPublicKey;
     private String bitcoinPrivateKey;
     private String bitcoinAddress;
     private boolean isUsed;
     private String usedFor;
     private boolean isPaid;

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

     public boolean isUsed() {
          return isUsed;
     }

     public void setUsed(boolean used) {
          isUsed = used;
     }

     public String getUsedFor() {
          return usedFor;
     }

     public void setUsedFor(String usedFor) {
          this.usedFor = usedFor;
     }

     public boolean isPaid() {
          return isPaid;
     }

     public void setPaid(boolean paid) {
          isPaid = paid;
     }
}
