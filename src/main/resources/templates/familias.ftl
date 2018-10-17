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
							<h3 class="panel-title">Roles</h3>
                            <hr>
                        </div>

						<div class="panel-body">

                                <button class="btn btn-primary" data-toggle="modal" data-target="#modalFamilia">Crear Familia</button>
								<form action="/familias/" method="POST">
                                    <div class="modal fade" id="modalFamilia" tabindex="-1" role="dialog" aria-labelledby="modalFamiliaLabel" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="modalFamiliaLabel">Crear Familia</h5>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">
                                                    <input type="text" class="form-control" id="nombrerol" name="familia" placeholder="Familia">


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
                                <table id="rolestable" class="table table-striped table-bordered table-condensed table-hover table-sm">
                                    <thead>
                                    <th class="text-center">ID</th>
                                    <th class="text-center">Familia</th>
                                    <th class="text-center">Opciones</th>


                                <#list familias as familia>
                                <tr>

                                    <td class="text-center">${familia.getId()}</td>
                                    <td class="text-center">${familia.getNombreCategoria()}</td>
                                    <td class="text-center">
                                        <div class="btn-group">
                                            <div class="btn-group">
                                                <form action="/familias/ver/${familia.getId()}" method="GET">
                                                    <button type="submit" class="btn btn-success"><i class="fa fa-eye" aria-hidden="true"></i></button>
                                                </form>
                                            </div>
                                            <div class="btn-group">
                                                    <button type="button" data-toggle="modal" data-target="#modalFamilia2" class="btn btn-primary"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>

                                            </div>
                                            <div class="btn-group">
                                                <form action="/familias/eliminar/${familia.getId()}" method="POST">
                                                    <button type="submit" class="btn btn-danger"><i class="fa fa-trash aria-hidden="true"></i></button>
                                                </form>

                                            </div>
                                        </div>
                                    </td>


                                </tr>
                                </#list>
                                </table>
                            </div>
							<!-- END REALTIME CHART -->
                            <form action="/familias/modificar/" method="POST">
                                <div class="modal fade" id="modalFamilia2" tabindex="-1" role="dialog" aria-labelledby="modalFamilia2Label" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="modalFamiliaL2abel">Modificar Familia</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <input type="hidden" name="id" id="id">
                                                <input type="text" class="form-control" id="nombrerol" name="familia" placeholder="Familia">


                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                                <button type="submit" class="btn btn-primary">Guardar</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
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
