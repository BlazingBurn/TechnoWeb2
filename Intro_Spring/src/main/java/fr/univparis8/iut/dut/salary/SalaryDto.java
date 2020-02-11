package fr.univparis8.iut.dut.salary;

import fr.univparis8.iut.dut.employee.EmployeeDto;

import java.time.LocalDate;
import java.util.Objects;

public class SalaryDto {

    private Long id;

    private double montantVerse;

    private int nbJoursTravailMois;

    private LocalDate dateVersement;

    private String dateVersementDu;

    private EmployeeDto employeeDto;

    public SalaryDto() {
    }

    public SalaryDto(Long id, double montantVerse, int nbJours, String date, EmployeeDto employeeDto) {
        this.id = id;
        this.montantVerse = montantVerse;
        this.nbJoursTravailMois = nbJours == 0 ? 20 : nbJours;
        this.dateVersement = LocalDate.now();
        this.dateVersementDu = date;
        this.employeeDto = employeeDto;
    }

    public Long getId() { return id; }

    public double getMontantVerse() { return montantVerse; }

    public void setMontantVerse(double montantVerse) {
        this.montantVerse = montantVerse;
    }

    public int getNbJoursTravailMois() { return nbJoursTravailMois; }

    public LocalDate getDateVersement() { return dateVersement; }

    public String getDateVersementDu() {
        return dateVersementDu;
    }

    public EmployeeDto getEmployeeDto() {
        return employeeDto;
    }

    public static final class SalaryDtoBuilder {
        private Long id;
        private double montantVerse;
        private int nbJoursTravailMois;
        private LocalDate dateVersement;
        private String dateVersementDu;
        private EmployeeDto employeeDto;

        private SalaryDtoBuilder() {
        }

        public static SalaryDtoBuilder create() {
            return new SalaryDtoBuilder();
        }

        public SalaryDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public SalaryDtoBuilder withMontantVerse(double montantVerse) {
            this.montantVerse = montantVerse;
            return this;
        }

        public SalaryDtoBuilder withNbJoursTravailMois(int nbJourTravailMois) {
            this.nbJoursTravailMois = nbJourTravailMois;
            return this;
        }

        public SalaryDtoBuilder withDateVersement(LocalDate date) {
            this.dateVersement = date;
            return this;
        }

        public SalaryDtoBuilder withDateVersementDu(String date) {
            this.dateVersementDu = date;
            return this;
        }

        public SalaryDtoBuilder withEmployeeDto(EmployeeDto employeeDto) {
            this.employeeDto = employeeDto;
            return this;
        }

        public SalaryDto build() {
            return new SalaryDto(id, montantVerse, nbJoursTravailMois, dateVersementDu, employeeDto);
        }
    }

}
