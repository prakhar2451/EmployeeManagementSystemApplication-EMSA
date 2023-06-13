package emsa.org.employeemanagementsystemapplication.services;

import emsa.org.employeemanagementsystemapplication.entities.Employee;
import emsa.org.employeemanagementsystemapplication.payloads.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employee);
    EmployeeDto updateEmployee(EmployeeDto employee, Integer empId);
    EmployeeDto getEmployeeById(Integer empId);
   List< EmployeeDto> getEmployeeByDepartment(Integer departmentId);

   List<EmployeeDto> getEmployeeByQualification(Integer qualId);
    List<EmployeeDto> getAllEmployees();

    void deleteEmployee(Integer empId);

    EmployeeDto updateEmployee(EmployeeDto employeeDto);

}
