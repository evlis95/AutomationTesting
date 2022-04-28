package com.automation_testing.hibernate.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "services_mobile", schema = "public", catalog = "Automation_testing")
public class MobileServices implements Serializable {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "div_id")
    private Divisions division;

    private String adv;

    private String req;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MobileServices that)) return false;
        return division.equals(that.division);
    }

    @Override
    public int hashCode() {
        return Objects.hash(division);
    }


}
