package emsa.org.employeemanagementsystemapplication.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDto {

    private  int id;

    @NotEmpty
    @Size(min = 4, message = "Username must at least of 4 characters.")
    private String name;
    private String gender;
    private int age;
    private String jobRole;
    private long contact;
    @Email(message = "Email address is not valid")
    private String empEmail;
    @Size(min = 4, max = 10, message = "Password must be at least of 4 chars and max of 10 chars.")
    private  String empPassword;
}
