package lt.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import lt.logica.Horario;
import lt.logica.Odontologo;
import lt.logica.Paciente;
import lt.logica.Persona;
import lt.logica.Responsable;
import lt.logica.Secretario;
import lt.logica.Turno;
import lt.logica.Usuario;

import java.util.Map;
import java.util.HashMap;

/**
 * Clase que se encarga de la persistencia de los datos en la base de datos.
 *
 * @author lennynT02
 * @version 1.0
 */
public class PersistenceController {
  private GenericController<Usuario> usuarioController = new GenericController<>(Usuario.class);
  private GenericController<Horario> horarioController = new GenericController<>(Horario.class);
  private GenericController<Odontologo> odontologoController = new GenericController<>(Odontologo.class);
  private GenericController<Paciente> pacienteController = new GenericController<>(Paciente.class);
  private GenericController<Persona> personaController = new GenericController<>(Persona.class);
  private GenericController<Responsable> responsableController = new GenericController<>(Responsable.class);
  private GenericController<Secretario> secretarioController = new GenericController<>(Secretario.class);
  private GenericController<Turno> turnoController = new GenericController<>(Turno.class);
  private Map<String, GenericController<?>> controllers = new HashMap<String, GenericController<?>>() {
    {
      put("Usuario", usuarioController);
      put("Horario", horarioController);
      put("Odontologo", odontologoController);
      put("Paciente", pacienteController);
      put("Responsable", responsableController);
      put("Secretario", secretarioController);
      put("Turno", turnoController);
      put("Persona", personaController);
    }
  };

  /**
   * Crea un objeto en la base de datos.
   * 
   * @param entity Objeto a crear.
   * @param name   Nombre de la entidad.
   */
  public <T> void crear(T entity, String name) {
    try {
      GenericController<T> controller = getController(name);
      controller.create(entity);
    } catch (Exception e) {
      Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE,
          null, e);
    }
  }

  /**
   * Elimina un objeto de la base de datos.
   * 
   * @param id   Identificador del objeto.
   * @param name Nombre de la entidad.
   */
  public <T> void delete(int id, String name) {
    try {
      GenericController<T> controller = getController(name);
      controller.delete(id);
    } catch (Exception e) {
      Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE,
          null, e);
    }
  }

  /**
   * Actualiza un objeto en la base de datos.
   * 
   * @param entity Objeto a actualizar.
   * @param name   Nombre de la entidad.
   */
  public <T> void update(T entity, String name) {
    try {
      GenericController<T> controller = getController(name);
      controller.update(entity);
    } catch (Exception e) {
      Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE,
          null, e);
    }
  }

  /**
   * Busca un objeto en la base de datos.
   * 
   * @param id   Identificador del objeto.
   * @param name Nombre de la entidad.
   * @return Objeto encontrado.
   */
  public <T> T find(int id, String name) {
    GenericController<T> controller = getController(name);
    return controller.find(id);
  }

  /**
   * Busca un objeto en la base de datos.
   * 
   * @param id   Identificador del objeto.
   * @param name Nombre de la entidad.
   * @return Objeto encontrado.
   */
  public <T> ArrayList<T> findAll(String name) {
    GenericController<T> controller = getController(name);
    List<T> lista = controller.findAll();
    return new ArrayList<T>(lista);
  }

  @SuppressWarnings("unchecked")
  private <T> GenericController<T> getController(String name) {
    return (GenericController<T>) controllers.get(name);
  }
}
