package emsa.org.employeemanagementsystemapplication.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class PayrollDto {

    private int id;
    int employeeId;
    int jobId;
    int salaryId;
    int leaveId;
    Date date;
    double total_amount;

}
