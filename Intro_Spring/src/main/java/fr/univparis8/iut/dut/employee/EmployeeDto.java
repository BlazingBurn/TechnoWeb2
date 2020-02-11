package fr.univparis8.iut.dut.employee;

import fr.univparis8.iut.dut.salary.Salary;
import fr.univparis8.iut.dut.salary.SalaryDto;
import fr.univparis8.iut.dut.vacation.VacationDayDto;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDto {

    private Long id;

    private String firstName;

    private String lastName;

    private Adress adress;

    private List<SalaryDto> salary;

    private List<VacationDayDto> vacation;

    public EmployeeDto() {
        salary = new ArrayList<>() ;
        vacation = new ArrayList<>();
    }

    public EmployeeDto(Long id, String firstName, String lastName, Adress adress, List<SalaryDto> salary, List<VacationDayDto> vacation) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.salary = salary;
        this.vacation = vacation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Adress getAdress() { return adress; }

    public void setAdress(Adress adress) { this.adress = adress; }

    public List<SalaryDto> getSalary() {
        return salary;
    }

    public void setSalary(List<SalaryDto> salary) {
        this.salary = salary;
    }

    public List<VacationDayDto> getVacation() {
        return vacation;
    }

    public void setVacation(List<VacationDayDto> vacation) {
        this.vacation = vacation;
    }

    public static final class EmployeeDtoBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private  Adress adress;
        private List<SalaryDto> salary;
        private List<VacationDayDto> vacation;

        private EmployeeDtoBuilder() {
        }

        public static EmployeeDtoBuilder create() {
            return new EmployeeDtoBuilder();
        }

        public EmployeeDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EmployeeDtoBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public EmployeeDtoBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public EmployeeDtoBuilder withAdress(Adress adress) {
            this.adress = adress;
            return this;
        }

        public EmployeeDtoBuilder withSalary(List<SalaryDto> salary) {
            this.salary = salary;
            return this;
        }

        public EmployeeDtoBuilder withVacationDayDto(List<VacationDayDto> vacationDayDto) {
            this.vacation = vacationDayDto;
            return this;
        }

        public EmployeeDto build() {
            return new EmployeeDto(id, firstName, lastName, adress, salary, vacation);
        }
    }
}
