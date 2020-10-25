package Modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "se_compone", schema = "almacen_v1", catalog = "")
@IdClass(SeComponeEntityPK.class)
public class SeComponeEntity {
    private String tipoCompuesto;
    private String tipo;
    private int modeloCompuesto;
    private int modelo;

    @Id
    @Column(name = "Tipo_Compuesto")
    public String getTipoCompuesto() {
        return tipoCompuesto;
    }

    public void setTipoCompuesto(String tipoCompuesto) {
        this.tipoCompuesto = tipoCompuesto;
    }

    @Id
    @Column(name = "Tipo")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Id
    @Column(name = "Modelo_Compuesto")
    public int getModeloCompuesto() {
        return modeloCompuesto;
    }

    public void setModeloCompuesto(int modeloCompuesto) {
        this.modeloCompuesto = modeloCompuesto;
    }

    @Id
    @Column(name = "Modelo")
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
        SeComponeEntity that = (SeComponeEntity) o;
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
