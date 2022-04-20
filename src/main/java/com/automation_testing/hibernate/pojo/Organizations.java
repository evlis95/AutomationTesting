package com.automation_testing.hibernate.pojo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "organizations")
public class Organizations {
    @Id
    private String id;
    private String name;
    private String kpp;
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
}
