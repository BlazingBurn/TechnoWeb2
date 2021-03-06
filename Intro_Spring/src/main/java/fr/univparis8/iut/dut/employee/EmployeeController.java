package fr.univparis8.iut.dut.employee;

import fr.univparis8.iut.dut.common.exception.IdMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAll();
    }

    @GetMapping("{id}")
    public EmployeeDto getEmployee(@PathVariable Long id) {
        return EmployeeMapper.toEmployeeDto(employeeService.get(id));
    }

    @GetMapping("byFirstName")
     public List<EmployeeDto> getAllEmployeesByFirstName() { return employeeService.getByFirstName(); }


    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) throws URISyntaxException {

        if(employeeDto.getId() != null) {
            throw new IllegalArgumentException("Employee id should not be populated when creating and employee");
        }
        if(employeeDto.getAdress() == null) {
            throw new IllegalArgumentException("Vous avez non mis l'adresse");
        }

        Employee newEmployee = employeeService.create(EmployeeMapper.toEmployee(employeeDto));

        URI uri = new URI(ServletUriComponentsBuilder.fromCurrentRequest()
                .pathSegment("{id}")
                .buildAndExpand(newEmployee.getId())
                .toUri().getPath()
        );

        return ResponseEntity.created(uri).body(EmployeeMapper.toEmployeeDto(newEmployee));
    }

    @PostMapping("batch")
    public ResponseEntity<List<EmployeeDto>> createEmployeeBatch(@RequestBody List<EmployeeDto> employeeDtos) throws URISyntaxException {

        for (EmployeeDto index: employeeDtos
             ) {
            if(index.getId() != null) {
                throw new IllegalArgumentException("Employee id should not be populated when creating and employee");
            }
            if(index.getAdress() == null) {
                throw new IllegalArgumentException("Vous avez non mis l'adresse");
            }
        }

        //sinon stream avec filtre sur ID et findFirst pour verif si retourne quelque chose donc faux

        List<Employee> newEmployeeList = employeeService.createAll(EmployeeMapper.DtoToEmployeesList(employeeDtos));

        return ResponseEntity.ok(EmployeeMapper.toEmployeesDtoList(newEmployeeList));

    }

    @PutMapping("{id}")
    public EmployeeDto updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        if(employeeDto.getId() == null) {
            throw new IllegalArgumentException("Employee id should be populated for HTTP PUT method: you cannot predict its id");
        }
        if(!id.equals(employeeDto.getId())) {
            throw new IdMismatchException("Path id and payload id do not match");
        }

        Employee updatedEmployee = employeeService.update(EmployeeMapper.toEmployee(employeeDto));
        return EmployeeMapper.toEmployeeDto(updatedEmployee);
    }

    @PatchMapping("{id}")
    public EmployeeDto partialUpdateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        if(employeeDto.getId() == null) {
            throw new IllegalArgumentException("Employee id should be populated for HTTP PUT method: you cannot predict its id");
        }
        if(!id.equals(employeeDto.getId())) {
            throw new IdMismatchException("Path id and payload id do not match");
        }

        Employee updatedEmployee = employeeService.partialUpdate(EmployeeMapper.toEmployee(employeeDto));
        return EmployeeMapper.toEmployeeDto(updatedEmployee);
    }

    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
    }

}
