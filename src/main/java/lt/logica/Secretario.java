package lt.logica;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Secretario extends Persona {
  private String sector;
  @OneToOne
  private Usuario usuario;

  public Secretario() {
  }

  public Secretario(int id, String ci, String nombre, String apellido, String telefono, String direccion,
      LocalDate fecha_nac, String sector, Usuario usuario) {
    super(id, ci, nombre, apellido, telefono, direccion, fecha_nac);
    this.sector = sector;
    this.usuario = usuario;
  }

  public String getSector() {
    return sector;
  }

  public void setSector(String sector) {
    this.sector = sector;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

}
