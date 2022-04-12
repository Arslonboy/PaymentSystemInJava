package com.example.paymentsysteminjava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@DiscriminatorValue(value = "agent_entity")
public class AgentEntity extends UserEntity{
    @Transient
    private Boolean isPaynet;
    @Transient
    private Boolean isClick;
    @Transient
    private Boolean isApelsin;
    @Transient
    private Boolean isPayme;



    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_AGENT"));
        return authorities;
    }

}
