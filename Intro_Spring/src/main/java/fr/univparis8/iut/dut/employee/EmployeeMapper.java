package fr.univparis8.iut.dut.employee;

import fr.univparis8.iut.dut.salary.SalaryMapper;
import fr.univparis8.iut.dut.vacation.VacationMapper;

import java.util.List;
import java.util.stream.Collectors;

public final class EmployeeMapper {

    public static EmployeeDto toEmployeeDto(Employee employee) {
        if(employee == null) return null;

        return EmployeeDto.EmployeeDtoBuilder.create()
                .withId(employee.getId())
                .withFirstName(employee.getFirstName())
                .withLastName(employee.getLastName())
                .withAdress(employee.getAdress())
                .withSalary(SalaryMapper.toSalaryDtoList(employee.getSalary()))
                .withVacationDayDto(VacationMapper.toVacationDayDtoList(employee.getVacation()))
                .build();
    }

    public static Employee toEmployee(EmployeeDto employee) {
        return Employee.EmployeeBuilder.create()
                .withId(employee.getId())
                .withFirstName(employee.getFirstName())
                .withLastName(employee.getLastName())
                .withAdress(employee.getAdress())
                .withSalary(SalaryMapper.DtoToSalaryList(employee.getSalary()))
                .withVacationDay(VacationMapper.DtoToVacationDayList(employee.getVacation()))
                .build();
    }

    public static Employee toEmployee(EmployeeEntity employee) {
        Adress adress = new Adress(employee.getNomRue(),employee.getCodePostal(),employee.getNomVille(),employee.getNomPays());

        return Employee.EmployeeBuilder.create()
                .withId(employee.getId())
                .withFirstName(employee.getFirstName())
                .withLastName(employee.getLastName())
                .withAdress(adress)
                .withSalary(SalaryMapper.toSalaryListEX(employee.getSalaryList()))
                .withVacationDay(VacationMapper.toVacationDayListEX(employee.getVacationList()))
                .build();
    }

    public static EmployeeEntity toEmployee(Employee employee) {
        return EmployeeEntity.EmployeEntityBuilder.create()
                .withId(employee.getId())
                .withFirstName(employee.getFirstName())
                .withLastName(employee.getLastName())
                .withNomRue(employee.getAdress() == null ? null : employee.getAdress().getNomRue())
                .withCodePostal(employee.getAdress() == null ? 0 : employee.getAdress().getCodePostal())
                .withNomVille(employee.getAdress() == null ? null : employee.getAdress().getNomVille())
                .withNomPays(employee.getAdress() == null ? null :  employee.getAdress().getNomPays())
                .withSalary(SalaryMapper.toSalaryEntityList(employee.getSalary()))
                .withVacation(VacationMapper.toVacationDayEntityList(employee.getVacation()))
                .build();
    }

    public static List<Employee> toEmployeesList(List<EmployeeEntity> employeeEntities) {
        return employeeEntities.stream()
                .map(EmployeeMapper::toEmployee)
                .collect(Collectors.toList());
    }

    public static List<EmployeeDto> toEmployeesDtoList(List<Employee> employeeEntities) {
        return employeeEntities.stream()
                .map(EmployeeMapper::toEmployeeDto)
                .collect(Collectors.toList());
    }

    public static List<Employee> DtoToEmployeesList(List<EmployeeDto> employeeEntities) {
        return employeeEntities.stream()
                .map(EmployeeMapper::toEmployee)
                .collect(Collectors.toList());
    }

    public static List<EmployeeEntity> toEmployeesEntityList(List<Employee> employeeEntities) {
        return employeeEntities.stream()
                .map(EmployeeMapper::toEmployee)
                .collect(Collectors.toList());
    }



}
