package com.automation_testing.hibernate.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment_order", schema = "public", catalog = "Automation_testing")
public class PaymentOrder {

    @Id
    @Column(name = "doc_bank_id")
    private String docBankID;

    @Column(name = "available_for_can_req")
    private String availForCanReq;

    @Column(name = "doc_num")
    private String docNum;

    private String status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentOrder)) return false;
        PaymentOrder that = (PaymentOrder) o;
        return docBankID.equals(that.docBankID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(docBankID);
    }
}
