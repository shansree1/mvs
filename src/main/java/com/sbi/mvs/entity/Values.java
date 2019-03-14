package com.sbi.mvs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Values implements Serializable {

    @Id
    private String id;
    private String key;
    private String value;
}
