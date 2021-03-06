package com.sbi.mvs.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ATM implements Serializable {

    @Id
    private String atmId;
    private String atmType;
    private String siteType;
    private String ownershipType;
    private String networkType;
    private String oem;
    private String model;
    private String phase;
    private String msVendor;
    private String cashRepl;

    @ManyToOne
    @JoinColumn(name = "ownerBranch")
    private Branch ownerBranch;

    @ManyToOne
    @JoinColumn(name = "cashLinkBranch")
    private Branch cashLinkBranch;

    private String address1;
    private String address2;
    private String address3;
    private String village;
    private String taluk;
    private String subDistrict;
    private String district;
    private String state;
    private String popGroup;
    private String landmark;

    @OneToOne
    @PrimaryKeyJoinColumn
    private ATMNetwork atmNetwork;

    @OneToOne
    @PrimaryKeyJoinColumn
    private ATMAuxInfo atmAuxInfo;

    public String getAtmId() {
        return atmId;
    }

    public void setAtmId(String atmId) {
        this.atmId = atmId;
    }

    public String getAtmType() {
        return atmType;
    }

    public void setAtmType(String atmType) {
        this.atmType = atmType;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public String getOwnershipType() {
        return ownershipType;
    }

    public void setOwnershipType(String ownershipType) {
        this.ownershipType = ownershipType;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public String getOem() {
        return oem;
    }

    public void setOem(String oem) {
        this.oem = oem;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getMsVendor() {
        return msVendor;
    }

    public void setMsVendor(String msVendor) {
        this.msVendor = msVendor;
    }

    public String getCashRepl() {
        return cashRepl;
    }

    public void setCashRepl(String cashRepl) {
        this.cashRepl = cashRepl;
    }

    public Branch getOwnerBranch() {
        return ownerBranch;
    }

    public void setOwnerBranch(Branch ownerBranch) {
        this.ownerBranch = ownerBranch;
    }

    public Branch getCashLinkBranch() {
        return cashLinkBranch;
    }

    public void setCashLinkBranch(Branch cashLinkBranch) {
        this.cashLinkBranch = cashLinkBranch;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getTaluk() {
        return taluk;
    }

    public void setTaluk(String taluk) {
        this.taluk = taluk;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPopGroup() {
        return popGroup;
    }

    public void setPopGroup(String popGroup) {
        this.popGroup = popGroup;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public ATMNetwork getAtmNetwork() {
        return atmNetwork;
    }

    public void setAtmNetwork(ATMNetwork atmNetwork) {
        this.atmNetwork = atmNetwork;
    }

    public ATMAuxInfo getAtmAuxInfo() {
        return atmAuxInfo;
    }

    public void setAtmAuxInfo(ATMAuxInfo atmAuxInfo) {
        this.atmAuxInfo = atmAuxInfo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ATM{");
        sb.append("atmId='").append(atmId).append('\'');
        sb.append(", atmType='").append(atmType).append('\'');
        sb.append(", siteType='").append(siteType).append('\'');
        sb.append(", ownershipType='").append(ownershipType).append('\'');
        sb.append(", networkType='").append(networkType).append('\'');
        sb.append(", oem='").append(oem).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", phase='").append(phase).append('\'');
        sb.append(", msVendor='").append(msVendor).append('\'');
        sb.append(", cashRepl='").append(cashRepl).append('\'');
        sb.append(", ownerBranch=").append(ownerBranch);
        sb.append(", cashLinkBranch=").append(cashLinkBranch);
        sb.append(", address1='").append(address1).append('\'');
        sb.append(", address2='").append(address2).append('\'');
        sb.append(", address3='").append(address3).append('\'');
        sb.append(", village='").append(village).append('\'');
        sb.append(", taluk='").append(taluk).append('\'');
        sb.append(", subDistrict='").append(subDistrict).append('\'');
        sb.append(", district='").append(district).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append(", popGroup='").append(popGroup).append('\'');
        sb.append(", landmark='").append(landmark).append('\'');
        sb.append(", atmNetwork=").append(atmNetwork);
        sb.append(", atmAuxInfo=").append(atmAuxInfo);
        sb.append('}');
        return sb.toString();
    }
}

