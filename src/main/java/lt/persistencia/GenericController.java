package lt.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class GenericController<T> {
  private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Odo_Sistema_PU");
  private Class<T> entityClass;

  public GenericController(Class<T> entityClass) {
    this.entityClass = entityClass;
  }

  protected EntityManager getEntityManager() {
    return emf.createEntityManager();
  }

  public void create(T entity) {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.persist(entity);
      em.getTransaction().commit();
    } catch (Exception e) {
      if (em != null && em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
      e.printStackTrace();
      throw new RuntimeException("Error al crear " + entityClass.getSimpleName() +
          ": " + e.getMessage(), e);
    } finally {
      if (em != null && em.isOpen()) {
        em.close();
      }
    }
  }

  public T find(int id) {
    EntityManager em = null;
    try {
      em = getEntityManager();
      return em.find(entityClass, id);
    } catch (Exception e) {
      throw new RuntimeException("Error al buscar " + entityClass.getSimpleName() +
          ": " + e.getMessage(), e);
    } finally {
      if (em != null && em.isOpen()) {
        em.close();
      }
    }
  }

  public List<T> findAll() {
    EntityManager em = null;
    try {
      em = getEntityManager();
      return em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e",
          entityClass).getResultList();
    } catch (Exception e) {
      throw new RuntimeException("Error al buscar todos los " +
          entityClass.getSimpleName() + "s: " + e.getMessage(),
          e);
    } finally {
      if (em != null && em.isOpen()) {
        em.close();
      }
    }
  }

  public void update(T entity) {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.merge(entity);
      em.getTransaction().commit();
    } catch (Exception e) {
      if (em != null && em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
      throw new RuntimeException("Error al actualizar " +
          entityClass.getSimpleName() + ": " + e.getMessage(), e);
    } finally {
      if (em != null && em.isOpen()) {
        em.close();
      }
    }
  }

  public void delete(int id) {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      T entity = em.find(entityClass, id);
      if (entity != null) {
        em.remove(entity);
        em.getTransaction().commit();
      } else {
        throw new IllegalArgumentException(
            "La entidad " + entityClass.getSimpleName() + " con ID " + id + " no es válida");
      }
    } catch (Exception e) {
      if (em != null && em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
      throw new RuntimeException("Error al eliminar " + entityClass.getSimpleName()
          + ": " + e.getMessage(), e);
    } finally {
      if (em != null && em.isOpen()) {
        em.close();
      }
    }
  }
}
