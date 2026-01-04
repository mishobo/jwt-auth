package com.husseinmishobo.authorization.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Setter
@Getter
@Table(
        name = "users",
        schema = "users",
        indexes = { @Index(name = "idx_users_email", columnList = "email")}
)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @NotBlank
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @JsonIgnore
    @NotBlank
    @Size(min = 8)
    @Column(nullable = false)
    private String password;


    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

}
