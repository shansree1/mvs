package com.sbi.mvs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class Pfhrms implements Serializable {

    @Id
    private Long pfId;
    private String name;
    private String mobileNumber;
    private String emailIdOfficial;
    private String emailIdDesignated;

    public Long getPfId() {
        return pfId;
    }

    public void setPfId(Long pfId) {
        this.pfId = pfId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailIdOfficial() {
        return emailIdOfficial;
    }

    public void setEmailIdOfficial(String emailIdOfficial) {
        this.emailIdOfficial = emailIdOfficial;
    }

    public String getEmailIdDesignated() {
        return emailIdDesignated;
    }

    public void setEmailIdDesignated(String emailIdDesignated) {
        this.emailIdDesignated = emailIdDesignated;
    }
}
