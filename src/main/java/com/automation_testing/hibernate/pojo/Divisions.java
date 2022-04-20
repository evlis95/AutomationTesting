package com.automation_testing.hibernate.pojo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "divisions")
public class Divisions {
    @Id
    private String id;
    private String name;
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

    public Divisions() {
    }

    public Divisions(String id, String name, String bic, String corr_acc, Organizations organization) {
        this.id = id;
        this.name = name;
        this.bic = bic;
        this.corr_acc = corr_acc;
        this.organization = organization;
    }
}
