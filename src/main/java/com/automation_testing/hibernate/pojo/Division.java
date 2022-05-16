package com.automation_testing.hibernate.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "division", schema = "public")
public class Division {
    @OneToMany(mappedBy = "division", orphanRemoval = true)
    private Set<Account> accounts = new HashSet<>();
    @Id
    @Column(name = "id", nullable = false, length = 10)
    private String id;
    
    @Column(name = "short_name", nullable = true, length = 125)
    private String shortName;
    
    @Column(name = "international_name", nullable = true, length = 125)
    private String internationalName;
    
    @Column(name = "bic", nullable = true, length = 9)
    private String bic;
    
    @Column(name = "payment_name", nullable = true, length = 125)
    private String paymentName;
    
    @Column(name = "glued_name", nullable = true, length = 125)
    private String gluedName;
    
    @Column(name = "foreign_name", nullable = true, length = 125)
    private String foreignName;
    
    @Column(name = "corr_acc", nullable = true, length = 50)
    private String corrAcc;
    
    @Column(name = "type_locality", nullable = true, length = 100)
    private String typeLocality;
    
    @Column(name = "locality", nullable = true, length = 100)
    private String locality;
    
    @Column(name = "foreign_locality", nullable = true, length = 100)
    private String foreignLocality;
    
    @Column(name = "digital_country_code", nullable = true, length = 3)
    private String digitalCountryCode;
    
    @Column(name = "alphabetic_county_code", nullable = true, length = 3)
    private String alphabeticCountyCode;
    
    @Column(name = "swift_code", nullable = true, length = 50)
    private String swiftCode;
    
    @Column(name = "address", nullable = true, length = 100)
    private String address;
    
    @Column(name = "foreign_address", nullable = true, length = 100)
    private String foreignAddress;
    
    @Column(name = "bank_type", nullable = true, length = 100)
    private String bankType;
    
    @Column(name = "short_name_type_locality", nullable = true, length = 50)
    private String shortNameTypeLocality;
    
    @Column(name = "time_zone", nullable = true, length = 30)
    private String timeZone;

    @ManyToOne
    @JoinColumn(name = "org_id")
    private Organization organization;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Division division = (Division) o;
        return Objects.equals(id, division.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }
    
}
