package com.sbi.mvs.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class BranchType implements Serializable {

    @Id
    private Long branchType;
    private String typeName;

    @OneToMany( mappedBy = "branchType")
    private Set<Branch> branches;

    public Long getBranchType() {
        return branchType;
    }

    public void setBranchType(Long branchType) {
        this.branchType = branchType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Set<Branch> getBranches() {
        return branches;
    }

    public void setBranches(Set<Branch> branches) {
        this.branches = branches;
    }
}
