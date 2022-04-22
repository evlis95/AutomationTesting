package com.automation_testing.hibernate.pojo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter @Setter
@Table(name = "divisions", schema = "public", catalog = "Automation_testing")
public class Divisions implements Serializable {
    @Id
    @Column(name = "id", nullable = false, length = 255)
    private String id;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "bic", nullable = false, length = 255)
    private String bic;
    @Basic
    @Column(name = "corr_acc", nullable = false, length = 255)
    private String corrAcc;
    @Basic
    @Column(name = "org_id", nullable = false, length = 255)
    private String orgId;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Divisions divisions = (Divisions) o;
        return Objects.equals(id, divisions.id) && Objects.equals(name, divisions.name) && Objects.equals(bic, divisions.bic) && Objects.equals(corrAcc, divisions.corrAcc) && Objects.equals(orgId, divisions.orgId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, bic, corrAcc, orgId);
    }
}
