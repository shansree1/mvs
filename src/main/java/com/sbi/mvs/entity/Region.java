package com.sbi.mvs.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Region implements Serializable {

    @Id
    private Long regionId;
    private String regionName;

    @ManyToOne
    @JoinColumn(name = "moduleId")
    private Module module;

    @OneToMany(mappedBy = "region")
    private Set<Branch> branches;

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Set<Branch> getBranches() {
        return branches;
    }

    public void setBranches(Set<Branch> branches) {
        this.branches = branches;
    }
}
