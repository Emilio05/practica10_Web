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
							<div class="row">

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
                                                    <input type="date"  class="date" min="2018-01-01" max="2018-12-31" id="fechanacimiento" name="fechanacimiento">
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
