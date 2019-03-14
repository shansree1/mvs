package com.sbi.mvs.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class ATMAuxInfo implements Serializable {

    @Id
    private String atmId;
    private LocalDate targetDate;
    private Boolean tmkAvailable;
    private Boolean tmkChecksum;
    private Boolean auxField1;
    private Boolean auxField2;
    private Boolean auxField3;
    private Boolean auxField4;
    private Boolean auxField5;
    private Boolean auxField6;
    private Boolean auxField7;
    private Boolean auxField8;
    private Boolean auxField9;
    private Boolean auxField10;

    @MapsId
    @OneToOne(mappedBy = "atmAuxInfo")
    @JoinColumn(name = "atmId")
    private ATM atm;

    public String getAtmId() {
        return atmId;
    }

    public void setAtmId(String atmId) {
        this.atmId = atmId;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public Boolean getTmkAvailable() {
        return tmkAvailable;
    }

    public void setTmkAvailable(Boolean tmkAvailable) {
        this.tmkAvailable = tmkAvailable;
    }

    public Boolean getTmkChecksum() {
        return tmkChecksum;
    }

    public void setTmkChecksum(Boolean tmkChecksum) {
        this.tmkChecksum = tmkChecksum;
    }

    public Boolean getAuxField1() {
        return auxField1;
    }

    public void setAuxField1(Boolean auxField1) {
        this.auxField1 = auxField1;
    }

    public Boolean getAuxField2() {
        return auxField2;
    }

    public void setAuxField2(Boolean auxField2) {
        this.auxField2 = auxField2;
    }

    public Boolean getAuxField3() {
        return auxField3;
    }

    public void setAuxField3(Boolean auxField3) {
        this.auxField3 = auxField3;
    }

    public Boolean getAuxField4() {
        return auxField4;
    }

    public void setAuxField4(Boolean auxField4) {
        this.auxField4 = auxField4;
    }

    public Boolean getAuxField5() {
        return auxField5;
    }

    public void setAuxField5(Boolean auxField5) {
        this.auxField5 = auxField5;
    }

    public Boolean getAuxField6() {
        return auxField6;
    }

    public void setAuxField6(Boolean auxField6) {
        this.auxField6 = auxField6;
    }

    public Boolean getAuxField7() {
        return auxField7;
    }

    public void setAuxField7(Boolean auxField7) {
        this.auxField7 = auxField7;
    }

    public Boolean getAuxField8() {
        return auxField8;
    }

    public void setAuxField8(Boolean auxField8) {
        this.auxField8 = auxField8;
    }

    public Boolean getAuxField9() {
        return auxField9;
    }

    public void setAuxField9(Boolean auxField9) {
        this.auxField9 = auxField9;
    }

    public Boolean getAuxField10() {
        return auxField10;
    }

    public void setAuxField10(Boolean auxField10) {
        this.auxField10 = auxField10;
    }

    public ATM getAtm() {
        return atm;
    }

    public void setAtm(ATM atm) {
        this.atm = atm;
    }
}
