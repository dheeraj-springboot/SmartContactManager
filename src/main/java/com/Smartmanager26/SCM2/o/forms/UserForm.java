package com.Smartmanager26.SCM2.o.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {
    @NotBlank(message = "USername is required")
    private String name;
    @Email(message = "Invalid email address")
    @NotBlank(message = "email is required")
    private String email;
    @NotBlank(message = "password is required")
    private String password;
    @NotBlank(message = "About is required")
    private String about;
    @NotBlank(message = "PhoneNumber is required")
    @Size(min=10,max = 10,message = "minimum and max is 10")
    private String phoneNumber;

}
