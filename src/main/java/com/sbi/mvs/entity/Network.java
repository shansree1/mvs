package com.sbi.mvs.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Network implements Serializable {

    @Id
    private Long networkId;
    private String networkName;

    @ManyToOne
    @JoinColumn(name = "lhoId")
    private LHO lho;

    @OneToMany(mappedBy = "network")
    private Set<Module> modules;

    public Long getNetworkId() {
        return networkId;
    }

    public void setNetworkId(Long networkId) {
        this.networkId = networkId;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public LHO getLho() {
        return lho;
    }

    public void setLho(LHO lho) {
        this.lho = lho;
    }

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }
}
