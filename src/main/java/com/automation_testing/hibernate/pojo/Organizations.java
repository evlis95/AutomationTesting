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
@Table(name = "organizations")
public class Organizations implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false, length = 255)
    private String id;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "kpp", nullable = false, length = 255)
    private String kpp;
    @Basic
    @Column(name = "inn", nullable = true, length = 255)
    private String inn;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "org_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Divisions> divisions;

    public Organizations(String id, String name, String kpp, String inn) {
        this.id = id;
        this.name = name;
        this.kpp = kpp;
        this.inn = inn;
    }

    public Organizations() {
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

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organizations that = (Organizations) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(kpp, that.kpp) && Objects.equals(inn, that.inn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, kpp, inn);
    }
}
