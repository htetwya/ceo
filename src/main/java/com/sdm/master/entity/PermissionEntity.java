/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdm.master.entity;

import com.sdm.core.model.DefaultEntity;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.http.HttpMethod;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Htoonlin
 */
@Entity(name = "PermissionEntity")
@Table(name = "tbl_permissions")
public class PermissionEntity extends DefaultEntity {

    private static final long serialVersionUID = 231291254158536747L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String pattern;

    @Column
    private String httpMethod;

    @NotFound(action = NotFoundAction.IGNORE)
    @JoinTable(name = "tbl_route_permissions",
        joinColumns = {@JoinColumn(name = "route_id")},
        inverseJoinColumns = {@JoinColumn(name = "role_id")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<RoleEntity> roles;

    public PermissionEntity() {
    }

    public PermissionEntity(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getPattern() {
        return this.pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public HttpMethod getMethod() {
        if (this.httpMethod == null) {
            return null;
        }

        return HttpMethod.valueOf(this.httpMethod);
    }

    public List<RoleEntity> getRoles() {
        if (this.roles == null) {
            return new ArrayList<>();
        }
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PermissionEntity other = (PermissionEntity) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
