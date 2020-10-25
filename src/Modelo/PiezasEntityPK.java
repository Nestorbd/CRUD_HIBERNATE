package Modelo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PiezasEntityPK implements Serializable {
    private int modelo;
    private String tipo;

    @Column(name = "Modelo")
    @Id
    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    @Column(name = "Tipo")
    @Id
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PiezasEntityPK that = (PiezasEntityPK) o;
        return modelo == that.modelo &&
                Objects.equals(tipo, that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelo, tipo);
    }
}
