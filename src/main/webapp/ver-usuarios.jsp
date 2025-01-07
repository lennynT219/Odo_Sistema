<%@ page import="java.util.List" %>
  <%@ page import="lt.logica.Usuario" %>
    <%@ page contentType="text/html" pageEncoding="UTF-8" %>
      <!DOCTYPE html>
      <%@ include file="./components/head.jsp" %>
        <html lang="es">

        <body id="page-top">
          <%@ include file="./components/firtsbody.jsp" %>

            <div class="container-fluid">

              <!-- DataTales Example -->
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">Usuarios</h6>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                      <thead>
                        <tr>
                          <th>Id</th>
                          <th>Usuario</th>
                          <th>Rol</th>
                          <th style="width: 210px;">Acción</th>
                        </tr>
                      </thead>
                      <% List<Usuario> usuarios = (List) request.getSession().getAttribute("usuarios"); %>
                        <tbody>
                          <% for (Usuario usuario : usuarios) { %>
                            <tr>
                              <td>
                                <%= usuario.getId_usuario()%>
                              </td>
                              <td>
                                <%=usuario.getNombre_usuario()%>
                              </td>
                              <td>
                                <%=usuario.getRol()%>
                              </td>
                              <td style="display: flex; width: 230px;">
                                <form name="delete" action="UserDeleteSv" method="post" style="margin-right: 5px;">
                                  <button type="submit" class="btn btn-primary btn-user btn-block"
                                    style="background-color: red; border: none;">
                                    <i class="fas fa-trash-alt" style="margin-right: 5px;"></i>Eliminar
                                  </button>
                                  <input type="hidden" name="id_usuario" value="<%=usuario.getId_usuario()%>">
                                </form>
                                <form name="edit" action="UserEditSv" method="get">
                                  <button type="submit" class="btn btn-primary btn-user btn-block">
                                    <i class="fas fa-pencil-alt" style="margin-right: 5px;"></i>Editar
                                  </button>
                                  <input type="hidden" name="id_usuario" value="<%=usuario.getId_usuario()%>">
                                </form>
                              </td>
                            </tr>
                            <% }; %>
                        </tbody>
                    </table>
                  </div>
                </div>
              </div>

            </div>
            <%@ include file="./components/secondbody.jsp" %>

              <!-- Page level plugins -->
              <script src="vendor/datatables/jquery.dataTables.min.js"></script>
              <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>
              <!-- Page level custom scripts -->
              <script src="js/demo/datatables-demo.js"></script>
        </body>

        </html>
