package fr.univparis8.iut.dut.employee;

import fr.univparis8.iut.dut.salary.Salary;
import fr.univparis8.iut.dut.salary.SalaryEntity;
import fr.univparis8.iut.dut.vacation.VacationDay;
import fr.univparis8.iut.dut.vacation.VacationDayEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "nom_rue")
    private String nomRue;

    @Column(name = "code_Postal")
    private int codePostal;

    @Column(name = "nom_ville")
    private String nomVille;

    @Column(name = "nom_Pays")
    private String nomPays;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "employeeEntity")
    public List<SalaryEntity> salary;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeEntity")
    public List<VacationDayEntity> vacation;

    public EmployeeEntity() {
        this.salary = new ArrayList<>();
        this.vacation = new ArrayList<>();
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

    public String getNomRue() { return nomRue; }

    public void setNomRue(String nomRue) { this.nomRue = nomRue; }

    public int getCodePostal() { return codePostal; }

    public void setCodePostal(int codePostal) { this.codePostal = codePostal; }

    public String getNomVille() { return nomVille; }

    public void setNomVille(String nomVille) { this.nomVille = nomVille; }

    public String getNomPays() { return nomPays; }

    public void setNomPays(String nomPays) { this.nomPays = nomPays; }

    public List<SalaryEntity> getSalaryList() {
        return salary;
    }

    public void setSalaryList(List<SalaryEntity> salaryList) {
        this.salary = salaryList;
    }

    public List<VacationDayEntity> getVacationList() {
        return vacation;
    }

    public void setVacationList(List<VacationDayEntity> vacation) {
        this.vacation = vacation;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return codePostal == that.codePostal &&
                Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(nomRue, that.nomRue) &&
                Objects.equals(nomVille, that.nomVille) &&
                Objects.equals(nomPays, that.nomPays) &&
                Objects.equals(salary, that.salary) &&
                Objects.equals(vacation, that.vacation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, nomRue, codePostal, nomVille, nomPays, salary, vacation);
    }

    public static final class EmployeEntityBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private String nomRue;
        private int codePostal;
        private String nomVille;
        private String nomPays;
        private List<SalaryEntity> salaryList;
        private List<VacationDayEntity> vacationList;

        private EmployeEntityBuilder() {
        }

        public static EmployeEntityBuilder create() {
            return new EmployeEntityBuilder();
        }

        public EmployeEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EmployeEntityBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public EmployeEntityBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public EmployeEntityBuilder withNomRue(String nomRue) {
            this.nomRue = nomRue;
            return this;
        }

        public EmployeEntityBuilder withCodePostal(int codePostal) {
            this.codePostal = codePostal;
            return this;
        }

        public EmployeEntityBuilder withNomVille(String nomVille) {
            this.nomVille = nomVille;
            return this;
        }

        public EmployeEntityBuilder withNomPays(String nomPays) {
            this.nomPays = nomPays;
            return this;
        }

        public EmployeEntityBuilder withSalary(List<SalaryEntity> salaryList) {
            this.salaryList = salaryList;
            return this;
        }

        public EmployeEntityBuilder withVacation(List<VacationDayEntity> vacationList) {
            this.vacationList = vacationList;
            return this;
        }

        public EmployeeEntity build() {
            EmployeeEntity employeeEntity = new EmployeeEntity();
            employeeEntity.setId(id);
            employeeEntity.setFirstName(firstName);
            employeeEntity.setLastName(lastName);
            employeeEntity.setNomRue(nomRue);
            employeeEntity.setCodePostal(codePostal);
            employeeEntity.setNomVille(nomVille);
            employeeEntity.setNomPays(nomPays);
            employeeEntity.setSalaryList(salaryList);
            employeeEntity.setVacationList(vacationList);
            return employeeEntity;
        }
    }
}
