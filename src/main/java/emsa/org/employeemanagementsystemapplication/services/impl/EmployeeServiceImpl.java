package emsa.org.employeemanagementsystemapplication.services.impl;

import emsa.org.employeemanagementsystemapplication.Repositories.DepartmentRepo;
import emsa.org.employeemanagementsystemapplication.Repositories.EmployeeRepo;
import emsa.org.employeemanagementsystemapplication.Repositories.QualificationRepo;
import emsa.org.employeemanagementsystemapplication.entities.Department;
import emsa.org.employeemanagementsystemapplication.entities.Employee;
import emsa.org.employeemanagementsystemapplication.entities.Qualification;
import emsa.org.employeemanagementsystemapplication.exceptions.ResourceNotFoundException;
import emsa.org.employeemanagementsystemapplication.payloads.EmployeeDto;
import emsa.org.employeemanagementsystemapplication.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private QualificationRepo qualificationRepo;

    //create employee

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = this.dtoToEmployee(employeeDto);
        Employee savedEmployee = this.employeeRepo.save(employee);

        return this.employeeToDto(savedEmployee);
    }

    //update the employee data

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto, Integer employeeId) {
        Employee employee = this.employeeRepo.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee", "emp id", employeeId));

        employee.setName(employeeDto.getName());
        employee.setAge(employeeDto.getAge());
        employee.setContact(employeeDto.getContact());
        employee.setGender(employeeDto.getGender());
        employee.setEmpEmail(employeeDto.getEmpEmail());
        employee.setEmpPassword(employeeDto.getEmpPassword());

        Employee updatedEmployee = this.employeeRepo.save(employee);
        return this.employeeToDto(updatedEmployee);
    }

    //get employee by employee Id

    @Override
    public EmployeeDto getEmployeeById(Integer employeeId) {
        Employee employee = this.employeeRepo.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee", "emp id", employeeId));
        return this.employeeToDto(employee);
    }

    // get employee according to department
    @Override
    public List<EmployeeDto> getEmployeeByDepartment(Integer departmentId) {
        Department department = this.departmentRepo.findById(departmentId)
                .orElseThrow(()-> new ResourceNotFoundException("Department", "department id", departmentId));
        List<Employee> employeeList = this.employeeRepo.findByDepartment(department);

        return employeeList.stream().map((employee)-> this.modelMapper.map(employee, EmployeeDto.class)).toList();
    }

    @Override
    public List<EmployeeDto> getEmployeeByQualification(Integer qualId) {
        Qualification qualification = this.qualificationRepo.findById(qualId)
                .orElseThrow(()-> new ResourceNotFoundException("Qualification","qualification id", qualId));
        List<Employee> employeeList = this.employeeRepo.findByQualification(qualification);
        return employeeList.stream().map((employee)->this.modelMapper.map(employee, EmployeeDto.class)).toList();
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
      List<Employee> employees = this.employeeRepo.findAll();
      List<EmployeeDto> employeeDtos = employees.stream().map((employee) -> this.modelMapper.map(employee, EmployeeDto.class)).toList();
      return  employeeDtos;
    }

    @Override
    public void deleteEmployee(Integer employeeId) {
        Employee employee = this.employeeRepo.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee", "employee id",employeeId));
        this.employeeRepo.delete(employee);

    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        return null;
    }


    public Employee dtoToEmployee(EmployeeDto employeeDto) {
        Employee emp = this.modelMapper.map(employeeDto, Employee.class);
        return  emp;
    }

    public EmployeeDto employeeToDto(Employee employee) {
        EmployeeDto employeeDto = this.modelMapper.map(employee, EmployeeDto.class);
        return  employeeDto;
    }
}
