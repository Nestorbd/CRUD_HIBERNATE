package Modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "estanteria", schema = "almacen_v1", catalog = "")
@IdClass(EstanteriaEntityPK.class)
public class EstanteriaEntity {
    private String nombre;
    private int idAlmacen;

    @Id
    @Column(name = "Nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Id
    @Column(name = "Id_almacen")
    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstanteriaEntity that = (EstanteriaEntity) o;
        return idAlmacen == that.idAlmacen &&
                Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, idAlmacen);
    }
}
