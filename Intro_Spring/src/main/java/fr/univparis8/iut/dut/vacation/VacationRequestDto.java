package fr.univparis8.iut.dut.vacation;

import fr.univparis8.iut.dut.employee.EmployeeDto;

import java.time.LocalDate;

public class VacationRequestDto {

    private Long id;

    private EmployeeDto employeeDto;

    private LocalDate dateDebut;

    private LocalDate dateFin;

    public VacationRequestDto() {
    }

    public VacationRequestDto(Long id, EmployeeDto employee, LocalDate dateDebut, LocalDate dateFin) {
        this.id = id;
        this.employeeDto = employee;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmployeeDto getEmployeeDto() {
        return employeeDto;
    }

    public void setEmployeeDto(EmployeeDto employeeDto) {
        this.employeeDto = employeeDto;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Long getId() {
        return id;
    }

    public EmployeeDto getEmployee() {
        return employeeDto;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public static final class VacationRequestDtoBuilder {
        private Long id;
        private EmployeeDto employeeDto;
        private LocalDate dateDebut;
        private LocalDate dateFin;

        private VacationRequestDtoBuilder() {
        }

        public static VacationRequestDtoBuilder create() {
            return new VacationRequestDtoBuilder();
        }

        public VacationRequestDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public VacationRequestDtoBuilder withEmployeeDto(EmployeeDto employeeDto) {
            this.employeeDto = employeeDto;
            return this;
        }

        public VacationRequestDtoBuilder withDateDebut(LocalDate dateDebut) {
            this.dateDebut = dateDebut;
            return this;
        }

        public VacationRequestDtoBuilder withDateFin(LocalDate dateFin) {
            this.dateFin = dateFin;
            return this;
        }

        public VacationRequestDto build() {
            return new VacationRequestDto(id, employeeDto, dateDebut, dateFin);
        }
    }

}
