<!doctype html>
<html lang="en">
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
							<h3 class="panel-title">Clientes</h3>
                            <hr>
                        </div>
                        <div class="panel-body">


                                <button class="btn btn-primary" data-toggle="modal" data-target="#modalClientes">Crear Cliente</button>
								<form enctype='multipart/form-data'>
                                    <div class="modal fade" id="modalClientes" tabindex="-1" role="dialog" aria-labelledby="modalClientesLabel" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="modalCLientesLabel">Crear Cliente</h5>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">
                                                    <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre">
                                                    <input type="text" class="form-control" id="cedula" name="cedula" placeholder="Cedula">
                                                    <input type="date"  class="date" min="2018-01-01" max="2018-12-31" id="fechaNacimiento" name="fechaNacimiento">
                                                    <input type="file"  accept="image/png, image/jpeg" id="foto" name="foto">

                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                                    <button type="button" class="btn btn-primary">Guardar</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>

                            <div class="table-responsive">
                                <table id="clientstable" class="table table-striped table-bordered table-condensed table-hover table-sm">
                                    <thead>
                                    <th class="text-center">Cedula</th>
                                    <th class="text-center">Nombre</th>
                                    <th class="text-center">Apellido</th>
                                    <th class="text-center">Fecha Nacimiento</th>
                                    <th class="text-center">Opciones</th>


                                <#list clientes as cliente>
                                <tr>

                                    <td class="text-center">${cliente.getCedula()}</td>
                                    <td class="text-center">${cliente.getNombre()}</td>
                                    <td class="text-center">${cliente.getApellido()}</td>
                                    <td class="text-center">${cliente.getFechaNacimiento()}</td>

                                    <td class="text-center">
                                        <div class="btn-group">
                                            <a href="#" class="btn btn-success"><i class="fa fa-eye" aria-hidden="true"></i></a>
                                            <a href="#" class="btn btn-primary"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                                            <a href="#" class="btn btn-danger"><i class="fa fa-trash aria-hidden="true"></i></
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
