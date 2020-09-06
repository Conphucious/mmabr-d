package com.ngu_software.mmabr.entity.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ip")
public class Ip {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "ip_address")
    private String ipAddress;

    @ManyToMany(mappedBy = "associatedIpSet")
    private Set<User> userReference;

    public Ip(String ipAddress) {
        this.ipAddress = ipAddress;
        this.userReference = new HashSet<>();
    }

    public void addToIpList(User user) {
        if (userReference == null) {
            userReference = new HashSet<>();
        }
        userReference.add(user);
    }

}