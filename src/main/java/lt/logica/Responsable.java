package lt.logica;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class Responsable extends Persona {
  private String tipo_res;

  public Responsable() {
  }

  public Responsable(int id, String ci, String nombre, String apellido, String telefono, String direccion,
      LocalDate fecha_nac, String tipo_res) {
    super(id, ci, nombre, apellido, telefono, direccion, fecha_nac);
    this.tipo_res = tipo_res;
  }

  public String getTipo_res() {
    return tipo_res;
  }

  public void setTipo_res(String tipo_res) {
    this.tipo_res = tipo_res;
  }

}
