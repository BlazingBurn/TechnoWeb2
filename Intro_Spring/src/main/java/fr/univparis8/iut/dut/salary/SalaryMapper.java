package fr.univparis8.iut.dut.salary;

import fr.univparis8.iut.dut.employee.Employee;
import fr.univparis8.iut.dut.employee.EmployeeMapper;

import java.util.List;
import java.util.stream.Collectors;

public class SalaryMapper {

    public static SalaryDto toSalaryDto(Salary salary) {
        return SalaryDto.SalaryDtoBuilder.create()
                .withId(salary.getId())
                .withMontantVerse(salary.getMontantVerse())
                .withNbJoursTravailMois(salary.getNbJourTravailMois())
                .withDateVersement(salary.getDateVersement())
                .withDateVersementDu(salary.getDateVersementDu())
                .withEmployeeDto(EmployeeMapper.toEmployeeDto(salary.getEmployee()))
                .build();
    }

    public static Salary toSalary(SalaryDto salary) {
        return Salary.SalaryBuilder.create()
                .withId(salary.getId())
                .withMontantVerse(salary.getMontantVerse())
                .withNbJourTravailMois(salary.getNbJoursTravailMois())
                .withDateVersement(salary.getDateVersement())
                .withDateVersementDu(salary.getDateVersementDu())
                .withEmployee(EmployeeMapper.toEmployee(salary.getEmployeeDto()))
                .build();
    }

    public static Salary toSalaryEX(SalaryEntity salary) {
        return Salary.SalaryBuilder.create()
                .withId(salary.getId())
                .withMontantVerse(salary.getMontantVerse())
                .withNbJourTravailMois(salary.getNbJoursTravailMois())
                .withDateVersement(salary.getDateVersement())
                .withDateVersementDu(salary.getDateVersementDu())
                .build();
    }

    public static Salary toSalary(SalaryEntity salary) {
        return Salary.SalaryBuilder.create()
                .withId(salary.getId())
                .withMontantVerse(salary.getMontantVerse())
                .withNbJourTravailMois(salary.getNbJoursTravailMois())
                .withDateVersement(salary.getDateVersement())
                .withDateVersementDu(salary.getDateVersementDu())
                .withEmployee(EmployeeMapper.toEmployee(salary.getEmployeeEntity()))
                .build();
    }

    public static SalaryEntity toSalary(Salary salary) {
        return SalaryEntity.SalaryEntityBuilder.create()
                .withId(salary.getId())
                .withMontantVerse(salary.getMontantVerse())
                .withNbJoursTravailMois(salary.getNbJourTravailMois())
                .withDateVersement(salary.getDateVersement())
                .withDateVersementDu(salary.getDateVersementDu())
                .withEmployee(EmployeeMapper.toEmployee(salary.getEmployee()))
                .build();
    }


    public static List<Salary> toSalaryList(List<SalaryEntity> salaryEntities) {
        return salaryEntities.stream()
                .map(SalaryMapper::toSalaryEX)
                .collect(Collectors.toList());
    }

    public static List<Salary> toSalaryListEX(List<SalaryEntity> salaryEntities) {
        return salaryEntities.stream()
                .map(SalaryMapper::toSalaryEX)
                .collect(Collectors.toList());
    }

    public static List<SalaryDto> toSalaryDtoList(List<Salary> salariesEntities) {
        return salariesEntities.stream()
                .map(SalaryMapper::toSalaryDto)
                .collect(Collectors.toList());
    }

    public static List<Salary> DtoToSalaryList(List<SalaryDto> salariesEntities) {
        return salariesEntities.stream()
                .map(SalaryMapper::toSalary)
                .collect(Collectors.toList());
    }

    public static List<SalaryEntity> toSalaryEntityList(List<Salary> salariesEntities) {
        return salariesEntities.stream()
                .map(SalaryMapper::toSalary)
                .collect(Collectors.toList());
    }


}
