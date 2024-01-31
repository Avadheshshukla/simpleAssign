package com.sunbase_assignment.Model;

import com.sunbase_assignment.Model.GenderEnum.GenderType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
//    String generatedValueAnnotation = "@GeneratedValue(strategy = GenerationType.UUID)";
    //@GeneratedValue(strategy =  GenerationType.UUID)
    private  String userId;
    @NotBlank
    private String first_name;
    @NotBlank
    private String last_name;
    @Enumerated(value = EnumType.STRING)
    private GenderType Gender;
    private String street;
    private String address;
    private String city;
    private String state;
    @Email(message = "Please Enter Valid Mail ID")
    private String email;
    @Digits(integer = 13, fraction = 0, message = "Please Enter Valid Phone Number!!")
    @Size(min = 10, max = 13, message = "Please Enter Valid Phone Number!!")
    private String phone;



}
