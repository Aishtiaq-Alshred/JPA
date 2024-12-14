package com.example.jpa1.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfileDTO {

    private Integer customer_id;

    private String phoneNumber;

    @NotEmpty
    private String gender;
    @NotNull
    @Min(18)
    private Integer age;
    @NotEmpty
    @Email
    private String email;

}
