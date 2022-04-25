package com.talentyco.shopping.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.talentyco.shopping.domain.security.Authority;
import com.talentyco.shopping.domain.security.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@NamedEntityGraph(
        name = "UserComplete",
        attributeNodes = { @NamedAttributeNode(value = "userRoles", subgraph = "role-subgraph") },
        subgraphs = {
                @NamedSubgraph(name = "role-subgraph", attributeNodes = { @NamedAttributeNode("role") }
        )}
)
@Entity
@SuppressWarnings("serial")
public class User implements UserDetails {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, updatable = false)
        private Long id;

        @NotNull
        private String username;

        private String password;
        private String firstName;
        private String lastName;

        @NotNull
        @Email
        private String email;

        @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name = "address_id")
        private Address address;

        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        @JsonIgnore
        private Set<UserRole> userRoles = new HashSet<>();

        public User() {
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                Set<GrantedAuthority> authorities = new HashSet<>();
                userRoles.forEach(userRole -> authorities.add(new Authority(userRole.getRole().getName())));
                return authorities;
        }

        @Override
        public String toString() {
                return "User{" +
                        "id=" + id +
                        ", username='" + username + '\'' +
                        ", password='" + password + '\'' +
                        ", email='" + email + '\'' +
                        '}';
        }

        @Override
        public boolean isAccountNonExpired() {
                return true;
        }

        @Override
        public boolean isAccountNonLocked() {
                return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
                return true;
        }

        @Override
        public boolean isEnabled() {
                return true;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        @Override
        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        @Override
        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public Address getAddress() {
                return address;
        }

        public void setAddress(Address address) {
                this.address = address;
        }

        public Set<UserRole> getUserRoles() {
                return userRoles;
        }

        public void setUserRoles(Set<UserRole> userRoles) {
                this.userRoles = userRoles;
        }
}
