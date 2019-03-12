package com.sbi.mvs.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BranchPeopleData implements Serializable {

    @Id
    private Long branchId;

    @OneToOne
    @JoinColumn(name = "branchManagerId")
    private Pfhrms branchManager;

    @OneToOne
    @JoinColumn(name = "atmOfficerId")
    private Pfhrms atmOfficer;

    @MapsId
    @OneToOne(mappedBy = "branchPeopleData")
    @JoinColumn(name = "branchId")
    private Branch branch;

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Pfhrms getBranchManager() {
        return branchManager;
    }

    public void setBranchManager(Pfhrms branchManager) {
        this.branchManager = branchManager;
    }

    public Pfhrms getAtmOfficer() {
        return atmOfficer;
    }

    public void setAtmOfficer(Pfhrms atmOfficer) {
        this.atmOfficer = atmOfficer;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
