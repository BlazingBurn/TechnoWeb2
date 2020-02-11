package fr.univparis8.iut.dut.salary;

import fr.univparis8.iut.dut.employee.Adress;
import fr.univparis8.iut.dut.employee.Employee;
import fr.univparis8.iut.dut.salary.Salary;

import java.time.LocalDate;
import java.util.Objects;

public class Salary {

    private final Long id;
    private final double montantVerse;
    private final int nbJoursTravailMois;
    private final LocalDate dateVersement;
    private final String dateVersementDu;
    private Employee employee;


    public Salary(Long id, double montantVerse, int nbJours, LocalDate date, String dateDuVersement, Employee employee) {
        this.id = id;
        this.montantVerse = montantVerse;
        this.nbJoursTravailMois = nbJours;
        this.dateVersement = date;
        this.dateVersementDu = dateDuVersement;
        this.employee = employee;
    }

    public Long getId() { return id; }

    public double getMontantVerse() { return montantVerse; }

    public int getNbJourTravailMois() { return nbJoursTravailMois; }

    public LocalDate getDateVersement() {
        return dateVersement;
    }

    public String getDateVersementDu() {
        return dateVersementDu;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Salary mergeWith(Salary other) {
        return Salary.SalaryBuilder.create()
                .withId(id)
                .withMontantVerse(!Objects.isNull(other.montantVerse) ? other.montantVerse : montantVerse)
                .withNbJourTravailMois(!Objects.isNull(other.nbJoursTravailMois) ? other.nbJoursTravailMois : nbJoursTravailMois)
                .withDateVersement(!Objects.isNull(other.dateVersement) ? other.dateVersement : dateVersement)
                .withDateVersementDu(!Objects.isNull(other.dateVersementDu) ? other.dateVersementDu : dateVersementDu)
                .withEmployee(!Objects.isNull(other.employee) ? other.employee : employee)
                .build();
    }

    public static final class SalaryBuilder {
        private Long id;
        private double montantVerse;
        private int nbJoursTravailMois;
        private LocalDate dateVersement;
        private String dateVersementDu;
        private Employee employee;

        private SalaryBuilder() {
        }

        public static Salary.SalaryBuilder create() {
            return new Salary.SalaryBuilder();
        }

        public SalaryBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public Salary.SalaryBuilder withMontantVerse(double montantVerse) {
            this.montantVerse = montantVerse;
            return this;
        }

        public Salary.SalaryBuilder withNbJourTravailMois(int nbJoursTravailMois) {
            this.nbJoursTravailMois = nbJoursTravailMois;
            return this;
        }

        public Salary.SalaryBuilder withDateVersement(LocalDate date) {
            this.dateVersement = date;
            return this;
        }

        public Salary.SalaryBuilder withDateVersementDu(String date) {
            this.dateVersementDu = date;
            return this;
        }

        public Salary.SalaryBuilder withEmployee(Employee employee) {
            this.employee = employee;
            return this;
        }

        public Salary build() {
            return new Salary(id, montantVerse, nbJoursTravailMois, dateVersement, dateVersementDu, employee);
        }
    }

}
