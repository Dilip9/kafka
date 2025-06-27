package edu.kfk.gouri.model;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class AuthRequest {

    @Column(unique = true, nullable = false, name = "Username/Email")
    private String username;
    @Column(unique = true, nullable = false)
    private String password;
}
