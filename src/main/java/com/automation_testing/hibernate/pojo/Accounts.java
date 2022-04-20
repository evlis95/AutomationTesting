package com.automation_testing.hibernate.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter @Setter
@Table(name = "accounts")
public class Accounts {
    @Id
    private String id;
    private String acc_num;
    private String type;
    private String acc_numerical_code;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "div_id")
    private Divisions division;

    public Accounts() {
    }

    public Accounts(String id, String acc_num, String type, String acc_numerical_code, Divisions division) {
        this.id = id;
        this.acc_num = acc_num;
        this.type = type;
        this.acc_numerical_code = acc_numerical_code;
        this.division = division;
    }
}
