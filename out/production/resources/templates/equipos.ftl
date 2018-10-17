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
							<h3 class="panel-title">Equipos</h3>
                            <hr>
                        </div>

						<div class="panel-body">
                                <button class="btn btn-primary" data-toggle="modal" data-target="#modalEquipo">Crear Equipo</button>
								<form method="POST" action="/equipos"  enctype='multipart/form-data'>
                                    <div class="modal fade" id="modalEquipo" tabindex="-1" role="dialog" aria-labelledby="modalEquipoLabel" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="modalEquipoLabel">Crear Equipo</h5>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">
                                                    <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre del Equipo">
                                                    <input type="text" class="form-control" id="precio" name="precio" placeholder="Precio del Equipo">
                                                    <input type="text" class="form-control" id="existencia" name="existencia" placeholder="Existencia del Equipo">
                                                    <select id="categoria" name="categoria" class="form-control select2 select2-hidden-accessible">
                                                    <#list categorias as category>
                                                        <option value="${category}">${category.getNombreCategoria()}</option>
                                                    </#list>

                                                    <input type="file"  accept="image/png, image/jpeg" id="foto" name="foto">
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                                    <input type="submit" value="Guardar" class="btn btn-primary" />
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>

							<!-- END REALTIME CHART -->
                            <div class="table-responsive">
                                <table id="clientstable" class="table table-striped table-bordered table-condensed table-hover table-sm">
                                    <thead>
                                    <th class="text-center">Codigo</th>
                                    <th class="text-center">Nombre de Equipo</th>
                                    <th class="text-center">Precio</th>
                                    <th class="text-center">Existencia</th>
                                    <th class="text-center">Opciones</th>


                                <#list equipos as equipo>
                                <tr>

                                    <td class="text-center">${equipo.getId()}</td>
                                    <td class="text-center">${equipo.getNombreEquipo()}</td>
                                    <td class="text-center">${equipo.getPrecio()}</td>
                                    <td class="text-center">${equipo.getExistencia()}</td>

                                    <td class="text-center">
                                        <div class="btn-group">
                                            <a href="#" class="btn btn-success"><i class="fa fa-eye" aria-hidden="true"></i></a>
                                            <a href="#" class="btn btn-primary"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                                            <a href="/equipos/${equipo.getId()}" class="btn btn-danger"><i class="fa fa-trash aria-hidden="true"></i></
                                        </div>
                                    </td>


                                </tr>
                                </#list>
                                </table>
                            </div>
						</div>

					</div>
				</div>
			</div>

			<!-- END MAIN CONTENT -->
		</div>

		</div>
	<!-- END WRAPPER -->
</body>
<script>
    $('.datepicker').datepicker({format: "dd-mm-yyyy"});
</script>
</html>
