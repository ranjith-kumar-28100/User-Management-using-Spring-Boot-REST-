package inc.codeman.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description="User Model Information")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private Long id;
	@NotEmpty(message = "First Name should not be empty.")
	@Schema(description = "User First Name")
	private String firstName;
	@NotEmpty(message = "Last Name should not be empty.")
	@Schema(description = "User Last Name")
	private String lastName;
	@NotEmpty(message="Email should not be empty")
	@Email(message="Not a valid email id")
	@Schema(description = "User Email Id")
	private String email;
}
