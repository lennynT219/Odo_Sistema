<%@ page contentType="text/html" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <%@ include file="./components/head.jsp" %>
    <html lang="es">

    <body>
      <%@ include file="./components/firtsbody.jsp" %>

        <form class="user">
          <div class="form-group col">
            <div class="col-sm-6 mb-3">
              <input type="text" class="form-control form-control-user" id="ci" placeholder="CI">
            </div>
            <div class="col-sm-6 mb-3">
              <input type="text" class="form-control form-control-user" id="nombre" placeholder="Nombre">
            </div>
            <div class="col-sm-6 mb-3">
              <input type="text" class="form-control form-control-user" id="apellido" placeholder="Apellido">
            </div>
            <div class="col-sm-6 mb-3">
              <input type="text" class="form-control form-control-user" id="telefono" placeholder="Telefono">
            </div>
            <div class="col-sm-6 mb-3">
              <input type="text" class="form-control form-control-user" id="direccion" placeholder="Direccion">
            </div>
            <div class="col-sm-6 mb-3">
              <input type="text" class="form-control form-control-user" id="nombre" placeholder="Nombre">
            </div>
            <div class="col-sm-6 mb-3">
              <input type="date" class="form-control form-control-user" id="fecha_nac"
                placeholder="Fecha de nacimiento">
            </div>
            <div class="col-sm-6 mb-3">
              <input type="text" class="form-control form-control-user" id="especialidad" placeholder="Especialidad">
            </div>
          </div>
          <a href="login.html" class="btn btn-primary btn-user btn-block">
            Registrar odontologo
          </a>
        </form>

        <%@ include file="./components/secondbody.jsp" %>

    </body>

    </html>
