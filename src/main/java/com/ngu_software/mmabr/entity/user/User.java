package com.ngu_software.mmabr.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    // URL + ID + AVATAR
//    https://cdn.discordapp.com/avatars/183603187712786432/3f7d726590620f12e690c71ff1d989e0.png

    @Id
    @Column(name = "discord_id")
    private String discordId;

    @Column(name = "discord_name")
    private String discordName;

    @Column(name = "discord_email")
    private String discordEmail;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_ip",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "ip_id"))
    private Set<Ip> associatedIpSet;

    public User(String discordId, String discordName, String discordEmail) {
        this.discordId = discordId;
        this.discordName = discordName;
        this.discordEmail = discordEmail;
        this.associatedIpSet = new HashSet<>();
    }
}
