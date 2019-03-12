package com.sbi.mvs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Pfhrms implements Serializable {

    @Id
    private Long pfId;
    private String name;
    private String mobileNumber;
    private String emailIdOfficial;
    private String emailIdDesignated;

}
