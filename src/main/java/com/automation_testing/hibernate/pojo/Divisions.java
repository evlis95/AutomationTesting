package com.automation_testing.hibernate.pojo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "divisions")
public class Divisions implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false, length = 255)
    private String id;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "bic", nullable = false, length = 255)
    private String bic;
    private String corr_acc;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id")
    private Organizations organization;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "div_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Accounts> accounts;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "div_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ServicesMobile> servicesMobiles;
    @Basic
    @Column(name = "corr_acc", nullable = false, length = 255)
    private String corrAcc;
    @Basic
    @Column(name = "org_id", nullable = false, length = 255)
    private String orgId;

    public Divisions() {
    }
    public Divisions(String id, String name, String bic, String corr_acc, Organizations organization) {
        this.id = id;
        this.name = name;
        this.bic = bic;
        this.corr_acc = corr_acc;
        this.organization = organization;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getCorrAcc() {
        return corrAcc;
    }

    public void setCorrAcc(String corrAcc) {
        this.corrAcc = corrAcc;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

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
