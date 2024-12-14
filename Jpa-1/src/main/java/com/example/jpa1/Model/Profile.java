package com.example.jpa1.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Profile {

    @Id
    private Integer id;
    @NotEmpty
    @Column(columnDefinition = "varchar(10) not null")
    @Size(max = 10)
    private String phoneNumber;
    @NotEmpty
    private String gender;
    @NotNull
    @Min(18)
    private Integer age;
    @NotEmpty
    @Email
    private String email;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Customer customer;
}
