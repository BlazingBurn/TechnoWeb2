package fr.univparis8.iut.dut.vacation;

import com.sun.istack.NotNull;
import fr.univparis8.iut.dut.employee.EmployeeEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "vacation")
public class VacationDayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @ManyToOne()
    @JoinColumn(name="employee")
    private EmployeeEntity employeeEntity;

    @Column(name = "dayVacation")
    private LocalDate dayVacation;

    public VacationDayEntity() {};

    public VacationDayEntity(Long id, EmployeeEntity employeeEntity, LocalDate dayVacation) {
        this.id = id;
        this.employeeEntity = employeeEntity;
        this.dayVacation = dayVacation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

    public LocalDate getDay() {
        return dayVacation;
    }

    public void setDay(LocalDate day) {
        this.dayVacation = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VacationDayEntity that = (VacationDayEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(employeeEntity, that.employeeEntity) &&
                Objects.equals(dayVacation, that.dayVacation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeEntity, dayVacation);
    }


    public static final class VacationEntityBuilder {
        private Long id;
        private EmployeeEntity employeeEntity;
        private LocalDate dayVacation;

        private VacationEntityBuilder() {
        }

        public static VacationDayEntity.VacationEntityBuilder create() {
            return new VacationDayEntity.VacationEntityBuilder();
        }

        public VacationDayEntity.VacationEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public VacationDayEntity.VacationEntityBuilder withEmployee(EmployeeEntity employee) {
            this.employeeEntity = employee;
            return this;
        }

        public VacationDayEntity.VacationEntityBuilder withDay(LocalDate day) {
            this.dayVacation = day;
            return this;
        }

        public VacationDayEntity build() {
            VacationDayEntity VacationEntity = new VacationDayEntity();
            VacationEntity.setId(id);
            VacationEntity.setEmployeeEntity(employeeEntity);
            VacationEntity.setDay(dayVacation);
            return VacationEntity;
        }
    }



    /*@Entity
    VacationRequest{
        private LocalDate dateDebut;
        private LocalDate dateFin;

        VacationRequest(LocalDate dateDebut, LocalDate dateFin){
            this.dateDebut = dateDebut;
            this.dateFin = dateFin;
        }
    }*/


}
