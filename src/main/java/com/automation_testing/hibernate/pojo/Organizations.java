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
@Table(name = "organizations", schema = "public", catalog = "Automation_testing")
public class Organizations implements Serializable {
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
