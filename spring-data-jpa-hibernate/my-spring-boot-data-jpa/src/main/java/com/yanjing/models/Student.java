package com.yanjing.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "First name is required")
    private String firstname;

    @NotEmpty(message = "Last name is required")
    private String lastname;

    @Email(message = "email is not valid")
    @Column(nullable = true, name = "email")
    private String email;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;
}
