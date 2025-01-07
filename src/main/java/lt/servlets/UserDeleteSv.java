package lt.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lt.logica.LogicaController;

@WebServlet(name = "UserDeleteSv", urlPatterns = { "/UserDeleteSv" })
public class UserDeleteSv extends HttpServlet {
  LogicaController lc = new LogicaController();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    int id = Integer.parseInt(req.getParameter("id_usuario"));
    lc.deleteUser(id);
    res.sendRedirect("UsuarioSv");
  }
}
