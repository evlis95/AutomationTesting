package com.automation_testing.hibernate.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "account", schema = "public")
public class Account {
    @Id
    @Column(name = "id", nullable = false, length = 50)
    private String id;
    
    @Column(name = "acc_num", nullable = true, length = 30)
    private String accNum;
    
    @Column(name = "div_id", nullable = true, length = 30)
    private String divId;
    
    @Column(name = "org_id", nullable = true, length = 30)
    private String orgId;
    
    @Column(name = "balance", nullable = true, length = 100)
    private String balance;
    
    @Column(name = "account_status", nullable = true, length = 2)
    private String accountStatus;
    
    @Column(name = "acc_type", nullable = true, length = 20)
    private String accType;
    
    @Column(name = "alphabetic_code", nullable = true, length = 3)
    private String alphabeticCode;
    
    @Column(name = "balance_date", nullable = true, length = 30)
    private String balanceDate;
    
    @Column(name = "digital_code", nullable = true, length = 3)
    private String digitalCode;
    
    @Column(name = "debit_sum", nullable = true, length = 100)
    private String debitSum;
    
    @Column(name = "credit_sum", nullable = true, length = 100)
    private String creditSum;
    
    @Column(name = "i", nullable = true, length = 50)
    private String i;
    
    @Column(name = "display_in_details", nullable = true, length = 1)
    private String displayInDetails;
    
    @Column(name = "swa", nullable = true, length = 1)
    private String swa;
    
    @Column(name = "card", nullable = true, length = 100)
    private String card;
    
    @Column(name = "sdoc", nullable = true, length = 100)
    private String sdoc;
    
    @Column(name = "sbp_linc", nullable = true, length = 100)
    private String sbpLinc;
    
    @Column(name = "with_accept", nullable = true, length = 2)
    private String withAccept;
    
    @Column(name = "sbp_pay", nullable = true, length = 2)
    private String sbpPay;
    @ManyToOne
    private Organization organization;
    @ManyToOne
    private Division division;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
