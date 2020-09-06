package com.ngu_software.mmabr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class UserPrincipal {
    private String role;
    private String id;
    private String username;
    private String avatar;
    private String discriminator;
    private String email;
    private boolean isVerified;
}
