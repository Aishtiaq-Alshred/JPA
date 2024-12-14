package com.example.jpa1.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "your name is Empty!")
    @Column(columnDefinition = "varchar(10) not null")
    private String name;

    //الترتيب مهم في الاونتيشن
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Profile profile;
}
