package lt.logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id_usuario;
  private String nombre_usuario, contrasena, rol;

  public Usuario() {
  }

  public Usuario(int id_usuario, String nombre_usuario, String contrasena, String rol) {
    this.id_usuario = id_usuario;
    this.nombre_usuario = nombre_usuario;
    this.contrasena = contrasena;
    this.rol = rol;
  }

  public int getId_usuario() {
    return id_usuario;
  }

  public void setId_usuario(int id_usuario) {
    this.id_usuario = id_usuario;
  }

  public String getNombre_usuario() {
    return nombre_usuario;
  }

  public void setNombre_usuario(String nombre_usuario) {
    this.nombre_usuario = nombre_usuario;
  }

  public String getContrasena() {
    return contrasena;
  }

  public void setContrasena(String contrasena) {
    this.contrasena = contrasena;
  }

  public String getRol() {
    return rol;
  }

  public void setRol(String rol) {
    this.rol = rol;
  }

}
