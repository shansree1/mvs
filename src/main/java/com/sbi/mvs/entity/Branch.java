package com.sbi.mvs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Branch implements Serializable {

    @Id
    private Long branchId;
    private String branchName;
    private String branchAddress1;
    private String branchAddress2;
    private String branchAddress3;
    private String branchAddress4;
    private Long branchPinCode;
    private String branchPhoneNumber;
    private Long stateCode;
    private String branchEmailId;

    @ManyToOne
    @JoinColumn(name = "branchType")
    private BranchType branchType;

    @ManyToOne
    @JoinColumn(name = "regionId")
    private Region region;


}
