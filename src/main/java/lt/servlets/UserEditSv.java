package lt.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lt.logica.LogicaController;
import lt.logica.Usuario;

@WebServlet(name = "UserEditSv", urlPatterns = { "/UserEditSv" })
public class UserEditSv extends HttpServlet {

  LogicaController lc = new LogicaController();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    int id = Integer.parseInt(req.getParameter("id_usuario"));
    Usuario usuario = lc.findUser(id);

    HttpSession session = req.getSession();
    session.setAttribute("usuario", usuario);

    res.sendRedirect("edit-user.jsp");

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String nameUser = req.getParameter("usuario");
    String password = req.getParameter("contrasena");
    String rol = req.getParameter("rol");

    Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
    usuario.setNombre_usuario(nameUser);
    usuario.setContrasena(password);
    usuario.setRol(rol);

    lc.updateUser(usuario);

    resp.sendRedirect("UsuarioSv");
  }
}
