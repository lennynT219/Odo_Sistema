package lt.logica;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Persona {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String ci, nombre, apellido, telefono, direccion;
  private LocalDate fecha_nac;

  public Persona() {
  }

  public Persona(int id, String ci, String nombre, String apellido, String telefono, String direccion,
      LocalDate fecha_nac) {
    this.id = id;
    this.ci = ci;
    this.nombre = nombre;
    this.apellido = apellido;
    this.telefono = telefono;
    this.direccion = direccion;
    this.fecha_nac = fecha_nac;
  }

  public String getCi() {
    return ci;
  }

  public void setCi(String ci) {
    this.ci = ci;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public LocalDate getFecha_nac() {
    return fecha_nac;
  }

  public void setFecha_nac(LocalDate fecha_nac) {
    this.fecha_nac = fecha_nac;
  }
}
