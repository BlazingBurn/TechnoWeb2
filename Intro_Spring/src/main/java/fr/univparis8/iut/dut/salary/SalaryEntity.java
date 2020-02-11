package fr.univparis8.iut.dut.salary;

import com.sun.istack.NotNull;
import fr.univparis8.iut.dut.employee.EmployeeEntity;

import javax.persistence.*;
import javax.validation.Constraint;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "salary", uniqueConstraints={@UniqueConstraint(columnNames = {"dateVersementDu" , "employee"})})
public class SalaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id;

    @Column(name = "montantVerse")
    private double montantVerse;

    @Column(name = "nbJoursTravailMois")
    private int nbJoursTravailMois;

    @Column(name = "dateVersement")
    private LocalDate dateVersement;

    @NotNull
    @Column(name = "dateVersementDu")
    private String dateVersementDu;

    @NotNull
    @ManyToOne()
    @JoinColumn(name="employee")
    private EmployeeEntity employeeEntity;

    public SalaryEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMontantVerse() { return montantVerse; }

    public void setMontantVerse(double montantVerse) { this.montantVerse = montantVerse; }

    public int getNbJoursTravailMois() {
        return nbJoursTravailMois;
    }

    public void setNbJoursTravailMois(int nbJourTravailMois) {
        this.nbJoursTravailMois = nbJourTravailMois;
    }

    public LocalDate getDateVersement() {
        return dateVersement;
    }

    public void setDateVersement(LocalDate dateVersement) {
        this.dateVersement = dateVersement;
    }

    public String getDateVersementDu() {
        return dateVersementDu;
    }

    public void setDateVersementDu(String dateVersementDu) {
        this.dateVersementDu = dateVersementDu;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalaryEntity that = (SalaryEntity) o;
        return Double.compare(that.montantVerse, montantVerse) == 0 &&
                nbJoursTravailMois == that.nbJoursTravailMois &&
                Objects.equals(id, that.id) &&
                Objects.equals(dateVersement, that.dateVersement) &&
                Objects.equals(dateVersementDu, that.dateVersementDu) &&
                Objects.equals(employeeEntity, that.employeeEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, montantVerse, nbJoursTravailMois, dateVersement, dateVersementDu, employeeEntity);
    }

    public static final class SalaryEntityBuilder {
        private Long id;
        private double montantVerse;
        private int nbJoursTravailMois;
        private LocalDate dateVersement;
        private String dateVersementDu;
        private EmployeeEntity employeeEntity;

        private SalaryEntityBuilder() {
        }

        public static SalaryEntityBuilder create() {
            return new SalaryEntityBuilder();
        }

        public SalaryEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public SalaryEntityBuilder withMontantVerse(double montantVerse) {
            this.montantVerse = montantVerse;
            return this;
        }

        public SalaryEntityBuilder withNbJoursTravailMois(int nbJourTravailMois) {
            this.nbJoursTravailMois = nbJourTravailMois;
            return this;
        }

        public SalaryEntityBuilder withDateVersement(LocalDate date) {
            this.dateVersement = date;
            return this;
        }

        public SalaryEntityBuilder withDateVersementDu(String date) {
            this.dateVersementDu = date;
            return this;
        }

        public SalaryEntityBuilder withEmployee(EmployeeEntity employee) {
            this.employeeEntity = employee;
            return this;
        }

        public SalaryEntity build() {
            SalaryEntity SalaryEntity = new SalaryEntity();
            SalaryEntity.setId(id);
            SalaryEntity.setMontantVerse(montantVerse);
            SalaryEntity.setNbJoursTravailMois(nbJoursTravailMois);
            SalaryEntity.setDateVersement(dateVersement);
            SalaryEntity.setDateVersementDu(dateVersementDu);
            SalaryEntity.setEmployeeEntity(employeeEntity);
            return SalaryEntity;
        }
    }
}
