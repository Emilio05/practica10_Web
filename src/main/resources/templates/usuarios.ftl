<!doctype html>
<html lang="fr">
<#include "layout.ftl">
<body>
		<!-- MAIN -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">
					<!-- OVERVIEW -->
					<div class="panel panel-headline">
						<div class="panel-heading">
							<h3 class="panel-title">Usuarios</h3>
                            <hr>
                        </div>

						<div class="panel-body">

                                <button class="btn btn-primary" data-toggle="modal" data-target="#modalUsuario">Crear Usuario</button>
								<form action="/usuarios/" method="POST">
                                    <div class="modal fade" id="modalUsuario" tabindex="-1" role="dialog" aria-labelledby="modalUsuarioLabel" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="modalUsuarioLabel">Crear Usuario</h5>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">
                                                    <input type="text" class="form-control" id="username" name="username" placeholder="Nombre de Usuario">

                                                    <input type="password" class="form-control" id="password" name="password" placeholder="Contrasena">
                                                    <input type="email" class="form-control" id="email" name="email" placeholder="E-Mail">

                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                                    <button type="submit" class="btn btn-primary">Guardar</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>

                            <div class="table-responsive">
                                <table id="userstable" class="table table-striped table-bordered table-condensed table-hover table-sm">
                                    <thead>
                                    <th class="text-center">Nombre de Usuario</th>
                                    <th class="text-center">Contraseña</th>
                                    <th class="text-center">E-Mail</th>
                                    <th class="text-center">Opciones</th>


                                <#list usuarios as usuario>
                                <tr>

                                    <td class="text-center">${usuario.getUsername()}</td>
                                    <td class="text-center">${usuario.getPassword()}</td>
                                    <td class="text-center">${usuario.getEmail()}</td>
                                    <td class="text-center">
                                        <div class="btn-group">
                                            <a href="#" class="btn btn-success"><i class="fa fa-eye" aria-hidden="true"></i></a>
                                            <a href="#" class="btn btn-primary"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                                            <a href="/usuarios/eliminar/${usuario.getId()}" class="btn btn-danger"><i class="fa fa-trash aria-hidden="true"></i></a>
                                        </div>
                                    </td>


                                </tr>
                                </#list>
                                </table>
                            </div>
							<!-- END REALTIME CHART -->
						</div>
					</div>
				</div>
			</div>

			<!-- END MAIN CONTENT -->
		</div>

		</div>
	<!-- END WRAPPER -->
</body>

</html>
