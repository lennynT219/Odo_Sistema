package lt.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lt.logica.LogicaController;
import lt.logica.Usuario;

@WebServlet(name = "UsuarioSv", urlPatterns = { "/UsuarioSv" })
public class UsuarioSv extends HttpServlet {
  LogicaController lc = new LogicaController();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    List<Usuario> usuarios = new ArrayList<Usuario>();
    usuarios = lc.findAllUsuario();

    HttpSession session = req.getSession();
    session.setAttribute("usuarios", usuarios);

    res.sendRedirect("ver-usuarios.jsp");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String usuario = req.getParameter("usuario");
    String contrasena = req.getParameter("contrasena");
    String rol = req.getParameter("rol");

    lc.crearUsuario(usuario, contrasena, rol);
    res.sendRedirect("index.jsp");
  }

}
