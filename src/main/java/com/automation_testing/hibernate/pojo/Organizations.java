package com.automation_testing.hibernate.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;


import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "organizations", schema = "public", catalog = "Automation_testing")
public class Organizations {

    @Id
    private String id;

    @Column(name = "org_name")
    private String name;

    private String kpp;

    private String inn;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Divisions> divisionsSet = new HashSet<>();

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Accounts> accountsSet = new HashSet<>();


    public void addDivision(@NotNull Divisions division) {
        division.setOrganization(this);
        divisionsSet.add(division);
    }

    public void addAccount(Accounts account) {
        account.setOrganization(this);
        accountsSet.add(account);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Organizations that)) return false;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
