package fr.univparis8.iut.dut.vacation;

import fr.univparis8.iut.dut.employee.Employee;

import java.time.LocalDate;
import java.util.Objects;

public class VacationDay {

    private final Long id;
    private Employee employee;
    private final LocalDate day;


    public VacationDay(Long id, Employee employee, LocalDate day) {
        this.id = id;
        this.employee = employee;
        this.day = day;
    }

    public Long getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public LocalDate getDay() {
        return day;
    }

    public VacationDay mergeWith(VacationDay other) {
        return VacationDay.VacationDayBuilder.create()
                .withId(id)
                .withEmployee(!Objects.isNull(other.employee) ? other.employee : employee)
                .withDay(!Objects.isNull(other.day) ? other.day : day)
                .build();
    }

    public static final class VacationDayBuilder {
        private Long id;
        private Employee employee;
        private LocalDate day;

        private VacationDayBuilder() {
        }

        public static VacationDay.VacationDayBuilder create() {
            return new VacationDay.VacationDayBuilder();
        }

        public VacationDay.VacationDayBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public VacationDay.VacationDayBuilder withEmployee(Employee employee) {
            this.employee = employee;
            return this;
        }

        public VacationDay.VacationDayBuilder withDay(LocalDate date) {
            this.day = date;
            return this;
        }

        public VacationDay build() {
            return new VacationDay(id, employee, day);
        }
    }

}
