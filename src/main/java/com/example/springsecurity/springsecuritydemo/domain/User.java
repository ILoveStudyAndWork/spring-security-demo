package com.example.springsecurity.springsecuritydemo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
public class User {
    private long id;
    private String username;
    private String password;
    private Set<Authorities> authorities = new HashSet<>();

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="user")
    public Set<Authorities> getAuthorities() {
        return authorities;
    }
}
