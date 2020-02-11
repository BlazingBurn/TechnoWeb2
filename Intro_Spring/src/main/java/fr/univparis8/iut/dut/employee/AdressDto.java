package fr.univparis8.iut.dut.employee;

public class AdressDto {

    private String nomRue;
    private int codePostal;
    private String nomVille;
    private String nomPays;

    public AdressDto(String nomRue, int codePostal, String nomVille, String nomPays) {
        this.nomRue = nomRue;
        this.codePostal = codePostal;
        this.nomVille = nomVille;
        this.nomPays = nomPays;
    }

    public String getNomRue() {
        return nomRue;
    }

    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }

    public static final class AdressDtoBuilder {
        private String nomRue;
        private int codePostal;
        private String nomVille;
        private String nomPays;

        private AdressDtoBuilder() {
        }

        public static AdressDtoBuilder create() {
            return new AdressDtoBuilder();
        }

        public AdressDtoBuilder withNomRue(String nomRue) {
            this.nomRue = nomRue;
            return this;
        }

        public AdressDtoBuilder withCodePostal(int codePostal) {
            this.codePostal = codePostal;
            return this;
        }

        public AdressDtoBuilder withNomVille(String nomVille) {
            this.nomVille = nomVille;
            return this;
        }

        public AdressDtoBuilder withNomPays(String nomPays) {
            this.nomPays = nomPays;
            return this;
        }

        public Adress build() {
            return new Adress(nomRue, codePostal, nomVille, nomPays);
        }
    }

}