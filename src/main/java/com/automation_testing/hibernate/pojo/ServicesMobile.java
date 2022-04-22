package com.automation_testing.hibernate.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter @Setter
@Table(name = "services_mobile", schema = "public", catalog = "Automation_testing")
public class ServicesMobile implements Serializable {
    @Id
    @Column(name = "div_id", nullable = false, length = 255)
    private String divId;
    @Basic
    @Column(name = "adv", nullable = false, length = 1)
    private String adv;
    @Basic
    @Column(name = "req", nullable = false, length = 1)
    private String req;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicesMobile that = (ServicesMobile) o;
        return Objects.equals(divId, that.divId) && Objects.equals(adv, that.adv) && Objects.equals(req, that.req);
    }

    @Override
    public int hashCode() {
        return Objects.hash(divId, adv, req);
    }
}
