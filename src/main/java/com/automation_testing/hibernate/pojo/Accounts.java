package com.automation_testing.hibernate.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(name = "accounts", schema = "public", catalog = "Automation_testing")
public class Accounts {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "div_id")
    private Divisions division;

    @Column(name = "acc_num")
    private String accNum;

    @Column(name = "acc_type")
    private String type;

    @Column(name = "acc_numerical_code")
    private String accNumericalCode;

    @ManyToOne
    @JoinColumn(name = "org_id")
    private Organizations organization;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Accounts accounts)) return false;
        return id.equals(accounts.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
