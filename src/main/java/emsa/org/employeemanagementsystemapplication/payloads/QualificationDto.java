package emsa.org.employeemanagementsystemapplication.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QualificationDto {
    private int qualId;
    private String position;
    private String requirements;
}
