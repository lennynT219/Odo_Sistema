<%@ page contentType="text/html" pageEncoding="UTF-8" %>
  <%@ page import="lt.logica.Usuario" %>
    <!DOCTYPE html>
    <%@ include file="./components/head.jsp" %>
      <html lang="es">

      <body>
        <%@ include file="./components/firtsbody.jsp" %>

          <% Usuario usuario=(Usuario) request.getSession().getAttribute("usuario"); %>
            <form class="user" action="UserEditSv" method="post">
              <div class="form-group col">
                <div class="col-sm-6 mb-3">
                  <input type="text" class="form-control form-control-user" name="usuario" placeholder="Usuario"
                    value="<%=usuario.getNombre_usuario()%>">
                </div>
                <div class="col-sm-6 mb-3">
                  <input type="password" class="form-control form-control-user" name="contrasena"
                    placeholder="Contraseña" value="<%=usuario.getContrasena()%>">
                </div>
                <div class="col-sm-6 mb-3">
                  <input type="text" class="form-control form-control-user" name="rol" placeholder="Rol"
                    value="<%=usuario.getRol()%>">
                </div>
              </div>
              <button class="btn btn-primary btn-user btn-block" type="submit">
                Modificar Usuario
              </button>
            </form>
            <%@ include file="./components/secondbody.jsp" %>
      </body>

      </html>
