package com.blogapplication.BlogApplication.payloads;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@NoArgsConstructor
@Getter
@Setter

public class UserDto {

    private int id;

    @NotEmpty
    @Size(min = 4, message = "User name must be min of 4 character!!!")
    private String name;

    @Email(message = "In valid email!!!")
    private String email;

    @NotEmpty
    @Size(min = 3, max = 10, message = "Password must be minimum of 3 character an maximum of 10 character ")
    private String password;

    @NotEmpty
    private String about;

    //@Empty=both null and empty should not be there
    //@Null=should not be null
}
