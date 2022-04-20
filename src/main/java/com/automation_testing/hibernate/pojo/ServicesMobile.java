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
    private String id;
    @Basic
    @Column(name = "adv", nullable = false, length = 1)
    private String adv;
    @Basic
    @Column(name = "req", nullable = false, length = 1)
    private String req;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "div_id")
    private Divisions division;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "div_id", nullable = false, length = 255)
    private String divId;

    public ServicesMobile() {
    }

    public String getAdv() {
        return adv;
    }

    public void setAdv(String adv) {
        this.adv = adv;
    }

    public String getReq() {
        return req;
    }

    public void setReq(String req) {
        this.req = req;
    }

    public String getDivId() {
        return divId;
    }

    public void setDivId(String divId) {
        this.divId = divId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicesMobile that = (ServicesMobile) o;
        return Objects.equals(adv, that.adv) && Objects.equals(req, that.req) && Objects.equals(divId, that.divId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(divId, adv, req);
    }
}
