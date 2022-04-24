package com.automation_testing.hibernate.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "organizations", schema = "public", catalog = "Automation_testing")
public class Organizations implements Serializable {

    @Id
    private String id;

    @Column(name = "org_name")
    private String name;

    private String kpp;

    private String inn;

    @OneToMany(mappedBy = "organization",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Divisions> divisionsList;



}
