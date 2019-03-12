package com.sbi.mvs.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ATMNetwork implements Serializable {

    @Id
    private Long atmId;
    private String ipAddress;
    private String subnet;
    private String defaultGateway;
    private String hostDNS;
    private String hostPreDNS;
    private String hostAltDNS;
    private String  atmSite;

    @MapsId
    @OneToOne(mappedBy = "atmNetwork")
    @JoinColumn(name = "atmId")
    private ATM atm;

    public Long getAtmId() {
        return atmId;
    }

    public void setAtmId(Long atmId) {
        this.atmId = atmId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getSubnet() {
        return subnet;
    }

    public void setSubnet(String subnet) {
        this.subnet = subnet;
    }

    public String getDefaultGateway() {
        return defaultGateway;
    }

    public void setDefaultGateway(String defaultGateway) {
        this.defaultGateway = defaultGateway;
    }

    public String getHostDNS() {
        return hostDNS;
    }

    public void setHostDNS(String hostDNS) {
        this.hostDNS = hostDNS;
    }

    public String getHostPreDNS() {
        return hostPreDNS;
    }

    public void setHostPreDNS(String hostPreDNS) {
        this.hostPreDNS = hostPreDNS;
    }

    public String getHostAltDNS() {
        return hostAltDNS;
    }

    public void setHostAltDNS(String hostAltDNS) {
        this.hostAltDNS = hostAltDNS;
    }

    public String getAtmSite() {
        return atmSite;
    }

    public void setAtmSite(String atmSite) {
        this.atmSite = atmSite;
    }

    public ATM getAtm() {
        return atm;
    }

    public void setAtm(ATM atm) {
        this.atm = atm;
    }
}
