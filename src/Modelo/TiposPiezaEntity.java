package Modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tipos_pieza", schema = "almacen_v1", catalog = "")
public class TiposPiezaEntity {
    private String tipo;
    private String descripcion;

    @Id
    @Column(name = "Tipo")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Basic
    @Column(name = "Descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TiposPiezaEntity that = (TiposPiezaEntity) o;
        return Objects.equals(tipo, that.tipo) &&
                Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, descripcion);
    }
}
