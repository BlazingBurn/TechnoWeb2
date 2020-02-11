package fr.univparis8.iut.dut.vacation;

import fr.univparis8.iut.dut.employee.Employee;

import java.time.LocalDate;
import java.util.Objects;

public class VacationRequest {

    private final Long id;
    private Employee employee;
    private final LocalDate dateDebut;
    private final LocalDate dateFin;

    public VacationRequest(Long id, Employee employee, LocalDate dateDebut, LocalDate dateFin) {
        this.id = id;
        this.employee = employee;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Long getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }


    public VacationRequest mergeWith(VacationRequest other) {
        return VacationRequest.VacationRequestBuilder.create()
                .withId(id)
                .withEmployee(!Objects.isNull(other.employee) ? other.employee : employee)
                .withDateDebut(!Objects.isNull(other.dateDebut) ? other.dateDebut : dateDebut)
                .withDateFin(!Objects.isNull(other.dateFin) ? other.dateFin : dateFin)
                .build();
    }

    public static final class VacationRequestBuilder {
        private Long id;
        private Employee employee;
        private LocalDate dateDebut;
        private LocalDate dateFin;

        private VacationRequestBuilder() {
        }

        public static VacationRequest.VacationRequestBuilder create() {
            return new VacationRequest.VacationRequestBuilder();
        }

        public VacationRequest.VacationRequestBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public VacationRequest.VacationRequestBuilder withEmployee(Employee employee) {
            this.employee = employee;
            return this;
        }

        public VacationRequest.VacationRequestBuilder withDateDebut(LocalDate date) {
            this.dateDebut = date;
            return this;
        }

        public VacationRequest.VacationRequestBuilder withDateFin(LocalDate date) {
            this.dateFin = date;
            return this;
        }

        public VacationRequest build() {
            return new VacationRequest(id, employee, dateDebut,dateFin);
        }
    }

}
