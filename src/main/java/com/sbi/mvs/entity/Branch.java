package com.sbi.mvs.entity;

import javax.persistence.*;
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

    @OneToOne
    @PrimaryKeyJoinColumn
    private BranchPeopleData branchPeopleData;

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchAddress1() {
        return branchAddress1;
    }

    public void setBranchAddress1(String branchAddress1) {
        this.branchAddress1 = branchAddress1;
    }

    public String getBranchAddress2() {
        return branchAddress2;
    }

    public void setBranchAddress2(String branchAddress2) {
        this.branchAddress2 = branchAddress2;
    }

    public String getBranchAddress3() {
        return branchAddress3;
    }

    public void setBranchAddress3(String branchAddress3) {
        this.branchAddress3 = branchAddress3;
    }

    public String getBranchAddress4() {
        return branchAddress4;
    }

    public void setBranchAddress4(String branchAddress4) {
        this.branchAddress4 = branchAddress4;
    }

    public Long getBranchPinCode() {
        return branchPinCode;
    }

    public void setBranchPinCode(Long branchPinCode) {
        this.branchPinCode = branchPinCode;
    }

    public String getBranchPhoneNumber() {
        return branchPhoneNumber;
    }

    public void setBranchPhoneNumber(String branchPhoneNumber) {
        this.branchPhoneNumber = branchPhoneNumber;
    }

    public Long getStateCode() {
        return stateCode;
    }

    public void setStateCode(Long stateCode) {
        this.stateCode = stateCode;
    }

    public String getBranchEmailId() {
        return branchEmailId;
    }

    public void setBranchEmailId(String branchEmailId) {
        this.branchEmailId = branchEmailId;
    }

    public BranchType getBranchType() {
        return branchType;
    }

    public void setBranchType(BranchType branchType) {
        this.branchType = branchType;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public BranchPeopleData getBranchPeopleData() {
        return branchPeopleData;
    }

    public void setBranchPeopleData(BranchPeopleData branchPeopleData) {
        this.branchPeopleData = branchPeopleData;
    }
}
