package com.automation_testing.hibernate.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Getter @Setter
@Table(name = "accounts")
public class Accounts implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false, length = 255)
    private String id;
    private String acc_num;
    @Basic
    @Column(name = "type", nullable = false, length = 1)
    private String type;
    private String acc_numerical_code;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "div_id")
    private Divisions division;
    @Basic
    @Column(name = "div_id", nullable = false, length = 255)
    private String divId;
    @Basic
    @Column(name = "acc_num", nullable = false, length = 255)
    private String accNum;
    @Basic
    @Column(name = "acc_numerical_code", nullable = false, length = 3)
    private String accNumericalCode;
    public Accounts() {
    }

    public Accounts(String id, String acc_num, String type, String acc_numerical_code, Divisions division) {
        this.id = id;
        this.acc_num = acc_num;
        this.type = type;
        this.acc_numerical_code = acc_numerical_code;
        this.division = division;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDivId() {
        return divId;
    }

    public void setDivId(String divId) {
        this.divId = divId;
    }

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public String getAccNumericalCode() {
        return accNumericalCode;
    }

    public void setAccNumericalCode(String accNumericalCode) {
        this.accNumericalCode = accNumericalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accounts accounts = (Accounts) o;
        return Objects.equals(id, accounts.id) && Objects.equals(type, accounts.type) && Objects.equals(divId, accounts.divId) && Objects.equals(accNum, accounts.accNum) && Objects.equals(accNumericalCode, accounts.accNumericalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, divId, accNum, type, accNumericalCode);
    }
}
