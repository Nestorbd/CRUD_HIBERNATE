package Modelo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SeComponeEntityPK implements Serializable {
    private String tipoCompuesto;
    private String tipo;
    private int modeloCompuesto;
    private int modelo;

    @Column(name = "Tipo_Compuesto")
    @Id
    public String getTipoCompuesto() {
        return tipoCompuesto;
    }

    public void setTipoCompuesto(String tipoCompuesto) {
        this.tipoCompuesto = tipoCompuesto;
    }

    @Column(name = "Tipo")
    @Id
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Column(name = "Modelo_Compuesto")
    @Id
    public int getModeloCompuesto() {
        return modeloCompuesto;
    }

    public void setModeloCompuesto(int modeloCompuesto) {
        this.modeloCompuesto = modeloCompuesto;
    }

    @Column(name = "Modelo")
    @Id
    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeComponeEntityPK that = (SeComponeEntityPK) o;
        return modeloCompuesto == that.modeloCompuesto &&
                modelo == that.modelo &&
                Objects.equals(tipoCompuesto, that.tipoCompuesto) &&
                Objects.equals(tipo, that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoCompuesto, tipo, modeloCompuesto, modelo);
    }
}
