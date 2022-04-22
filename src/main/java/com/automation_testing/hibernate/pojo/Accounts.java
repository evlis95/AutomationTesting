package com.automation_testing.hibernate.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Getter @Setter
@Table(name = "accounts", schema = "public", catalog = "Automation_testing")
public class Accounts implements Serializable {
    @Id
    @Column(name = "id", nullable = false, length = 255)
    private String id;
    @Basic
    @Column(name = "div_id", nullable = false, length = 255)
    private String divId;
    @Basic
    @Column(name = "acc_num", nullable = false, length = 255)
    private String accNum;
    @Basic
    @Column(name = "type", nullable = false, length = 1)
    private String type;
    @Basic
    @Column(name = "acc_numerical_code", nullable = false, length = 3)
    private String accNumericalCode;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accounts accounts = (Accounts) o;
        return Objects.equals(id, accounts.id) && Objects.equals(divId, accounts.divId) && Objects.equals(accNum, accounts.accNum) && Objects.equals(type, accounts.type) && Objects.equals(accNumericalCode, accounts.accNumericalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, divId, accNum, type, accNumericalCode);
    }
}
