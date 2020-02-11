package fr.univparis8.iut.dut.vacation;

import fr.univparis8.iut.dut.employee.EmployeeDto;

import java.time.LocalDate;

public class VacationDayDto {

    private Long id;

    private EmployeeDto employeeDto;

    private LocalDate day;

    public VacationDayDto() {
    }

    public VacationDayDto(Long id, EmployeeDto employeeDto, LocalDate day) {
        this.id = id;
        this.employeeDto = employeeDto;
        this.day = day;
    }

    public Long getId() { return id; }

    public EmployeeDto getEmployeeDto() {
        return employeeDto;
    }

    public LocalDate getDay() { return day; }

    public static final class VacationDayDtoBuilder {
        private Long id;
        private EmployeeDto employeeDto;
        private LocalDate day;

        private VacationDayDtoBuilder() {
        }

        public static VacationDayDtoBuilder create() {
            return new VacationDayDtoBuilder();
        }

        public VacationDayDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public VacationDayDtoBuilder withEmployeeDto(EmployeeDto employeeDto) {
            this.employeeDto = employeeDto;
            return this;
        }

        public VacationDayDtoBuilder withDay(LocalDate day) {
            this.day = day;
            return this;
        }

        public VacationDayDto build() {
            return new VacationDayDto(id, employeeDto, day);
        }
    }

}
