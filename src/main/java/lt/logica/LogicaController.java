package lt.logica;

import java.util.ArrayList;

import lt.persistencia.PersistenceController;

public class LogicaController {
  private PersistenceController pc = new PersistenceController();

  public void crearUsuario(String nombreUsuario, String contrasena, String rol) {
    Usuario usuario = new Usuario();
    usuario.setNombre_usuario(nombreUsuario);
    usuario.setContrasena(contrasena);
    usuario.setRol(rol);
    pc.crear(usuario, "Usuario");
  }

  public ArrayList<Usuario> findAllUsuario() {
    return pc.findAll("Usuario");
  }

  public void deleteUser(int id) {
    pc.delete(id, "Usuario");
  }

  public Usuario findUser(int id) {
    return pc.find(id, "Usuario");
  }

  public void updateUser(Usuario usuario) {
    pc.update(usuario, "Usuario");
  }

  public boolean login(String usuario, String contrasena) {
    ArrayList<Usuario> usuarios = pc.findAll("Usuario");
    for (Usuario u : usuarios) {
      if (u.getNombre_usuario().equals(usuario) && u.getContrasena().equals(contrasena)) {
        return true;
      }
    }
    return false;
  }
}
