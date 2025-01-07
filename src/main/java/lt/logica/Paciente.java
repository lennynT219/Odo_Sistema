package lt.logica;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Paciente extends Persona {

  private boolean tiene_OS;
  private String tipo_sangre;
  @OneToOne
  private Responsable responsable;
  @OneToMany(mappedBy = "paciente")
  private List<Turno> listaTurnos;

  public Paciente() {
  }

  public Paciente(int id, String ci, String nombre, String apellido, String telefono, String direccion,
      LocalDate fecha_nac, boolean tiene_OS, String tipo_sangre, Responsable responsable,
      List<Turno> listaTurnos) {
    super(id, ci, nombre, apellido, telefono, direccion, fecha_nac);
    this.tiene_OS = tiene_OS;
    this.tipo_sangre = tipo_sangre;
    this.responsable = responsable;
    this.listaTurnos = listaTurnos;
  }

  public boolean isTiene_OS() {
    return tiene_OS;
  }

  public void setTiene_OS(boolean tiene_OS) {
    this.tiene_OS = tiene_OS;
  }

  public String getTipo_sangre() {
    return tipo_sangre;
  }

  public void setTipo_sangre(String tipo_sangre) {
    this.tipo_sangre = tipo_sangre;
  }

  public Responsable getResponsable() {
    return responsable;
  }

  public void setResponsable(Responsable responsable) {
    this.responsable = responsable;
  }

  public List<Turno> getListaTurnos() {
    return listaTurnos;
  }

  public void setListaTurnos(List<Turno> listaTurnos) {
    this.listaTurnos = listaTurnos;
  }

}
