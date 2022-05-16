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
@Table(name = "organization", schema = "public")
public class Organization {
     @OneToMany(mappedBy = "organization", orphanRemoval = true)
     private Set<Division> divisions = new HashSet<>();
     @OneToMany(mappedBy = "organization", orphanRemoval = true)
     private Set<Account> accounts = new HashSet<>();
    @Id
    @Column(name = "id", nullable = false, length = 50)
    private String id;
    
    @Column(name = "short_name", nullable = true, length = 50)
    private String shortName;
    
    @Column(name = "inn", nullable = true, length = 15)
    private String inn;
    
    @Column(name = "international_name", nullable = true, length = 100)
    private String internationalName;
    
    @Column(name = "full_name", nullable = true, length = 100)
    private String fullName;
    
    @Column(name = "kpp", nullable = true, length = 15)
    private String kpp;
    
    @Column(name = "form_ownership", nullable = true, length = 50)
    private String formOwnership;
    
    @Column(name = "ogrn", nullable = true, length = 30)
    private String ogrn;
    
    @Column(name = "city", nullable = true, length = 50)
    private String city;
    
    @Column(name = "area", nullable = true, length = 50)
    private String area;
    
    @Column(name = "country", nullable = true, length = 50)
    private String country;
    
    @Column(name = "zku", nullable = true, length = 1)
    private String zku;
    
    @Column(name = "cr", nullable = true, length = 1)
    private String cr;
    
    @Column(name = "li", nullable = true, length = 1)
    private String li;
    
    @Column(name = "lp", nullable = true, length = 1)
    private String lp;
    
    @Column(name = "sv", nullable = true, length = 1)
    private String sv;
    
    @Column(name = "ph", nullable = true, length = 1)
    private String ph;
    
    @Column(name = "cc", nullable = true, length = 1)
    private String cc;
    
    @Column(name = "warn", nullable = true, length = 1)
    private String warn;
    
    @Column(name = "aa", nullable = true, length = 1)
    private String aa;
    
    @Column(name = "ou", nullable = true, length = 1)
    private String ou;
    
    @Column(name = "idsbp", nullable = true, length = 10)
    private String idsbp;
    
    @Column(name = "pas", nullable = true, length = 1)
    private String pas;
    
    @Column(name = "tb", nullable = true, length = 1)
    private String tb;
    
    @Column(name = "fb", nullable = true, length = 1)
    private String fb;
    
    @Column(name = "ct", nullable = true, length = 1)
    private String ct;
    
    @Column(name = "sbp", nullable = true, length = 1)
    private String sbp;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void addDivision(Division division) {
        divisions.add(division);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "divisions=" + divisions +
                ", accounts=" + accounts +
                ", id='" + id + '\'' +
                ", shortName='" + shortName + '\'' +
                ", inn='" + inn + '\'' +
                ", internationalName='" + internationalName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", kpp='" + kpp + '\'' +
                ", formOwnership='" + formOwnership + '\'' +
                ", ogrn='" + ogrn + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", country='" + country + '\'' +
                ", zku='" + zku + '\'' +
                ", cr='" + cr + '\'' +
                ", li='" + li + '\'' +
                ", lp='" + lp + '\'' +
                ", sv='" + sv + '\'' +
                ", ph='" + ph + '\'' +
                ", cc='" + cc + '\'' +
                ", warn='" + warn + '\'' +
                ", aa='" + aa + '\'' +
                ", ou='" + ou + '\'' +
                ", idsbp='" + idsbp + '\'' +
                ", pas='" + pas + '\'' +
                ", tb='" + tb + '\'' +
                ", fb='" + fb + '\'' +
                ", ct='" + ct + '\'' +
                ", sbp='" + sbp + '\'' +
                '}';
    }
}
