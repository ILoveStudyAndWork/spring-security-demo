package com.example.springsecurity.springsecuritydemo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
public class Authorities implements GrantedAuthority {
    private static final long serialVersionUID = 5714174142238190816L;
    private long id;
    private String authority;
    private User user;

    @ManyToOne
    public User getUser() {
        return user;
    }

    // if use @Getter of lombok
    // the getId must write manually with @Id and @GeneratedValue
    // without those two annotation at the top of the getter function
    // the getter would be override by lombok
    // then the two annotation would disappear

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
}
