package emsa.org.employeemanagementsystemapplication.controllers;

import emsa.org.employeemanagementsystemapplication.entities.Employee;
import emsa.org.employeemanagementsystemapplication.payloads.ApiResponse;
import emsa.org.employeemanagementsystemapplication.payloads.EmployeeDto;
import emsa.org.employeemanagementsystemapplication.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emsa/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create_employee")
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        System.out.println("Generating employee's data");
        EmployeeDto createEmployeDto = this.employeeService.createEmployee(employeeDto);
        return  new ResponseEntity<>(createEmployeDto, HttpStatus.CREATED);
    }

    @PutMapping("/update_employee/{empId}")
    public ResponseEntity<EmployeeDto> updateEmployee(@Valid @RequestBody EmployeeDto employeeDto,@PathVariable Integer empId) {
        EmployeeDto updatedEmployee = this.employeeService.updateEmployee(employeeDto, empId);
        return ResponseEntity.ok(updatedEmployee);
    }

    @GetMapping("/employee/{empId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Integer empId) {
         return ResponseEntity.ok(this.employeeService.getEmployeeById(empId));
    }
    @GetMapping("/department/{departmentId}/employee")
    public ResponseEntity<List<EmployeeDto>> getEmployeeByDepartment(@PathVariable("departmentId") Integer departmentId) {
        List<EmployeeDto> employeeDtos = this.employeeService.getEmployeeByDepartment(departmentId);
        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }

    @GetMapping("/qualification/{qualId}/employee")
    public ResponseEntity<List<EmployeeDto>> getEmployeeByQualification(@PathVariable("qualId") Integer qualId) {
        List<EmployeeDto> employeeDtos = this.employeeService.getEmployeeByQualification(qualId);
        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }

    @DeleteMapping("/delete_employee/{employeeId}")
    public ApiResponse deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
        this.employeeService.deleteEmployee(employeeId);
        return new ApiResponse("Employee data has been removed successfully", true);
    }

    @GetMapping("/all_employees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(this.employeeService.getAllEmployees());
    }

}
