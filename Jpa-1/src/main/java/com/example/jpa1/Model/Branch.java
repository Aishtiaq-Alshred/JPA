package com.example.jpa1.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Size(min = 1,max = 30)
    @Column(columnDefinition = "varchar(30) not null")
    private String area;

    @ManyToOne
    @JoinColumn(name = "merchant_id_m",referencedColumnName = "id")
    @JsonIgnore
    private Merchant merchant;
}
