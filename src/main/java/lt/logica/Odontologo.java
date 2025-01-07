package lt.logica;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Odontologo extends Persona {
  private String especialidad;
  @OneToMany(mappedBy = "odontologo")
  private List<Turno> listaTurnos;
  @OneToOne
  private Usuario usuario;
  @OneToOne
  private Horario horario;

  public Odontologo() {
  }

  public Odontologo(int id, String ci, String nombre, String apellido, String telefono, String direccion,
      LocalDate fecha_nac, String especialidad, List<Turno> listaTurnos, Usuario usuario,
      Horario horario) {
    super(id, ci, nombre, apellido, telefono, direccion, fecha_nac);
    this.especialidad = especialidad;
    this.listaTurnos = listaTurnos;
    this.usuario = usuario;
    this.horario = horario;
  }

  public String getEspecialidad() {
    return especialidad;
  }

  public void setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
  }

  public List<Turno> getListaTurnos() {
    return listaTurnos;
  }

  public void setListaTurnos(List<Turno> listaTurnos) {
    this.listaTurnos = listaTurnos;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public Horario getHorario() {
    return horario;
  }

  public void setHorario(Horario horario) {
    this.horario = horario;
  }

}