package com.automation_testing.hibernate.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "divisions", schema = "public", catalog = "Automation_testing")
public class Divisions implements Serializable {

    @Id
    private String id;

    @Column(name = "div_name")
    private String name;

    private String bic;

    @Column(name = "corr_acc")
    private String corrAcc;

    @ManyToOne
    @JoinColumn(name = "org_id")
    private Organizations organization;

    @OneToMany(mappedBy = "division",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Accounts> accountsList;

    @OneToOne(mappedBy = "division", cascade = CascadeType.ALL, orphanRemoval = true)
    private MobileServices serviceMobile;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Divisions divisions)) return false;
        return id.equals(divisions.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
