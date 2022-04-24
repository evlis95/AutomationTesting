package com.automation_testing.hibernate.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "divisions", schema = "public", catalog = "Automation_testing")
public class Divisions implements Serializable {

    @Id
    private String id;

    @Column(name = "div_name")
    private String name;

    private String bic;

    @Column(name = "corr_acc")
    private String corrAcc;

    @ManyToOne
    @JoinColumn(name = "org_id")
    private Organizations organization;


}
