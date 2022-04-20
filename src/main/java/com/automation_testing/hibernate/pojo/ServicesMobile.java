package com.automation_testing.hibernate.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "services_mobile")
public class ServicesMobile {
    @Id
    private String id;
    private String adv;
    private String req;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "div_id")
    private Divisions division;

    public ServicesMobile() {
    }

}
