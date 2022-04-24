package com.automation_testing.hibernate.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(name = "accounts", schema = "public", catalog = "Automation_testing")
public class Accounts implements Serializable {

    @Id
    private String id;
    @Column(name = "div_id")
    private String divID;

    @Column(name = "acc_num")
    private String accNum;

    @Column(name = "acc_type")
    private String type;

    @Column(name = "acc_numerical_code")
    private String accNumericalCode;


}
