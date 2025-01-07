package lt.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lt.logica.LogicaController;

@WebServlet(name = "UserLoginSV", urlPatterns = { "/UserLoginSV" })
public class UserLoginSV extends HttpServlet {

  LogicaController lc = new LogicaController();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String usuario = req.getParameter("usuario");
    String contrasena = req.getParameter("contrasena");
    boolean login = false;

    login = lc.login(usuario, contrasena);

    if (login) {
      HttpSession session = req.getSession(true);
      session.setAttribute("currentUser", usuario);
      resp.sendRedirect("index.jsp");
    } else {
      resp.sendRedirect("login.jsp");

    }
  }
}
