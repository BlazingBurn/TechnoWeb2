package fr.univparis8.iut.dut.employee;

import java.util.Objects;

public class Adress {

    private final String nomRue;
    private final int codePostal;
    private final String nomVille;
    private final String nomPays;

    public Adress(String nomRue, int codePostal, String nomVille, String nomPays) {
        this.nomRue = nomRue;
        this.codePostal = codePostal;
        this.nomVille = nomVille;
        this.nomPays = nomPays;
    }

    public String getNomRue() {
        return nomRue;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public String getNomVille() {
        return nomVille;
    }

    public String getNomPays() {
        return nomPays;
    }


    public Adress mergeWith(Adress other) {
        return AdressBuilder.create()
                .withNomRue(!Objects.isNull(other.nomRue) ? other.nomRue : nomRue)
                .withCodePostal(!Objects.isNull(other.codePostal) ? other.codePostal : codePostal)
                .withNomVille(!Objects.isNull(other.nomVille) ? other.nomVille : nomVille)
                .withNomPays(!Objects.isNull(other.nomPays) ? other.nomPays : nomPays)
                .build();
    }

    public static final class AdressBuilder {
        private String nomRue;
        private int codePostal;
        private String nomVille;
        private String nomPays;

        private AdressBuilder() {
        }

        public static AdressBuilder create() {
            return new AdressBuilder();
        }

        public AdressBuilder withNomRue(String nomRue) {
            this.nomRue = nomRue;
            return this;
        }

        public AdressBuilder withCodePostal(int codePostal) {
            this.codePostal = codePostal;
            return this;
        }

        public AdressBuilder withNomVille(String nomVille) {
            this.nomVille = nomVille;
            return this;
        }

        public AdressBuilder withNomPays(String nomPays) {
            this.nomPays = nomPays;
            return this;
        }

        public Adress build() {
            return new Adress(nomRue, codePostal, nomVille, nomPays);
        }
    }

}
