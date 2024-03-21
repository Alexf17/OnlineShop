package com.example.onlineshop.entity;

import com.example.onlineshop.generator.UuidTimeSequenceGenerator;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", type = UuidTimeSequenceGenerator.class)
    @Column(name = "role_id")
    private UUID id;

    @Column(name = "role_name")
    private String roleName;

    @JsonBackReference
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<UserInfo> users;


    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<Authority> authorities;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (!id.equals(role.id)) return false;
        return roleName.equals(role.roleName);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + roleName.hashCode();
        return result;
    }
}
