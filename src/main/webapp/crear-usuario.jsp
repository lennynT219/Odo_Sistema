<%@ page contentType="text/html" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <%@ include file="./components/head.jsp" %>
    <html lang="es">

    <body>
      <%@ include file="./components/firtsbody.jsp" %>

        <form class="user" action="UsuarioSv" method="post">
          <div class="form-group col">
            <div class="col-sm-6 mb-3">
              <input type="text" class="form-control form-control-user" name="usuario" placeholder="Usuario">
            </div>
            <div class="col-sm-6 mb-3">
              <input type="password" class="form-control form-control-user" name="contrasena" placeholder="Contraseña">
            </div>
            <div class="col-sm-6 mb-3">
              <input type="text" class="form-control form-control-user" name="rol" placeholder="Rol">
            </div>
          </div>
          <button class="btn btn-primary btn-user btn-block" type="submit">
            Registrar Usuario
          </button>
        </form>

        <%@ include file="./components/secondbody.jsp" %>

    </body>

    </html>
