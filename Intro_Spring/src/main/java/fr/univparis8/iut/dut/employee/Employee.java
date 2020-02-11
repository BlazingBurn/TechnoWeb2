package fr.univparis8.iut.dut.employee;

import fr.univparis8.iut.dut.salary.Salary;
import fr.univparis8.iut.dut.vacation.VacationDay;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final Adress adress;
    private List<Salary> salary;
    private List<VacationDay> vacation;

    public Employee(Long id, String firstName, String lastName, Adress adress, List<Salary> salary, List<VacationDay> vacationDay) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.salary = salary;
        this.vacation = vacationDay;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Adress getAdress() {
        return adress;
    }

    public List<Salary> getSalary() { return  salary; }

    public List<VacationDay> getVacation() {
        return vacation;
    }

    public Employee mergeWith(Employee other) {
        return EmployeeBuilder.create()
                .withId(id)
                .withLastName(!Objects.isNull(other.lastName) ? other.lastName : lastName)
                .withFirstName(!Objects.isNull(other.firstName) ? other.firstName : firstName)
                .withAdress(!Objects.isNull(other.adress) ? other.adress : adress)
                .withSalary(!Objects.isNull(other.salary) ? other.salary : salary)
                .withVacationDay(!Objects.isNull(other.vacation) ? other.vacation : vacation)
                .build();
    }

    public static final class EmployeeBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private Adress adress;
        private List<Salary> salary;
        private List<VacationDay> vacationDay;

        private EmployeeBuilder() {
        }

        public static EmployeeBuilder create() {
            return new EmployeeBuilder();
        }

        public EmployeeBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public EmployeeBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public EmployeeBuilder withAdress(Adress adress) {
            this.adress = adress;
            return this;
        }

        public  EmployeeBuilder withSalary(List<Salary> salary) {
            this.salary = salary;
            return this;
        }

        public  EmployeeBuilder withVacationDay(List<VacationDay> vacationDay) {
            this.vacationDay = vacationDay;
            return this;
        }

        public Employee build() {
            return new Employee(id, firstName, lastName, adress, salary, vacationDay);
        }
    }
}
