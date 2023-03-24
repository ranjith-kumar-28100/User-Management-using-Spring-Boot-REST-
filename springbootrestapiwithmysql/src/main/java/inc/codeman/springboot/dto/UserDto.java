package inc.codeman.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "UserDto Model Information")
public class UserDto {
    @Schema(description = "User's Id")
    private Long id;
    @Schema(description = "User's First Name")
    @NotEmpty(message = "User First Name should not be Empty")
    private String firstName;
    @Schema(description = "User's Last Name")
    @NotEmpty(message = "User Last Name should not be Empty")
    private String lastName;
    @Schema(description = "User's Email Address")
    @Email(message = "Enter a valid Email address")
    @NotEmpty(message = "User Email should not be Empty")
    private String email;
}
