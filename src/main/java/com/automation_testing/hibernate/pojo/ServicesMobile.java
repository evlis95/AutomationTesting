package com.automation_testing.hibernate.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "services_mobile", schema = "public", catalog = "Automation_testing")
public class ServicesMobile implements Serializable {

    @Id
    @Column(name = "div_id")
    private String divId;

    private String adv;

    private String req;




}
