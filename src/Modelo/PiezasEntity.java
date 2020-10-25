package Modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "piezas", schema = "almacen_v1", catalog = "")
@IdClass(PiezasEntityPK.class)
public class PiezasEntity {
    private int modelo;
    private String tipo;
    private double precio;
    private String cantidad;
    private String descripcion;

    @Id
    @Column(name = "Modelo")
    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    @Id
    @Column(name = "Tipo")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Basic
    @Column(name = "Precio")
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Basic
    @Column(name = "Cantidad")
    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
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
        PiezasEntity that = (PiezasEntity) o;
        return modelo == that.modelo &&
                Double.compare(that.precio, precio) == 0 &&
                Objects.equals(tipo, that.tipo) &&
                Objects.equals(cantidad, that.cantidad) &&
                Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelo, tipo, precio, cantidad, descripcion);
    }
}
