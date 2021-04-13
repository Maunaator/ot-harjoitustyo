
package lattarikyselija.data;

import java.util.Objects;

public class Laji {
    private String snimi;
    private String lnimi;
    private String ryhma;

    public Laji(String snimi, String lnimi, String ryhma) {
        this.snimi = snimi;
        this.lnimi = lnimi;
        this.ryhma = ryhma;
    }

    public String getSnimi() {
        return snimi;
    }

    public String getLnimi() {
        return lnimi;
    }

    public String getRyhma() {
        return ryhma;
    }

    @Override
    public String toString() {
        return snimi + " - " + lnimi;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.snimi);
        hash = 59 * hash + Objects.hashCode(this.lnimi);
        hash = 59 * hash + Objects.hashCode(this.ryhma);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Laji other = (Laji) obj;
        if (!Objects.equals(this.snimi, other.snimi)) {
            return false;
        }
        if (!Objects.equals(this.lnimi, other.lnimi)) {
            return false;
        }
        if (!Objects.equals(this.ryhma, other.ryhma)) {
            return false;
        }
        return true;
    }
}
