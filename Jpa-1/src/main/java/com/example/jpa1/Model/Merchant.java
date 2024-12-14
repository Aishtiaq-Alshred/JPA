package com.example.jpa1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(columnDefinition = "varchar(10)")
    private String name;


    //الترتيب مهم
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "merchant")
    private Set<Branch> branches;
}
