package lt.logica;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Turno {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id_turno;
  private LocalDate fecha_turno;
  private String hora_turno, afeccion;
  @ManyToOne
  @JoinColumn(name = "id_odontologo")
  private Odontologo odontologo;
  @ManyToOne
  @JoinColumn(name = "id_paciente")
  private Paciente paciente;

  public Turno() {
  }

  public Turno(int id_turno, LocalDate fecha_turno, String hora_turno, String afeccion) {
    this.id_turno = id_turno;
    this.fecha_turno = fecha_turno;
    this.hora_turno = hora_turno;
    this.afeccion = afeccion;
  }

  public int getId_turno() {
    return id_turno;
  }

  public void setId_turno(int id_turno) {
    this.id_turno = id_turno;
  }

  public String getHora_turno() {
    return hora_turno;
  }

  public void setHora_turno(String hora_turno) {
    this.hora_turno = hora_turno;
  }

  public String getAfeccion() {
    return afeccion;
  }

  public void setAfeccion(String afeccion) {
    this.afeccion = afeccion;
  }

  public LocalDate getFecha_turno() {
    return fecha_turno;
  }

  public void setFecha_turno(LocalDate fecha_turno) {
    this.fecha_turno = fecha_turno;
  }

  public Odontologo getOdontologo() {
    return odontologo;
  }

  public void setOdontologo(Odontologo odontologo) {
    this.odontologo = odontologo;
  }

  public Paciente getPaciente() {
    return paciente;
  }

  public void setPaciente(Paciente paciente) {
    this.paciente = paciente;
  }

}
