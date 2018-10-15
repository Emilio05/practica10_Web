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
							<h3 class="panel-title">Alquiler</h3>
                            <hr>
                        </div>

						<div class="panel-body">
							<div class="row">

                                <button class="btn btn-primary" data-toggle="modal" data-target="#modalUsuario">Crear Usuario</button>
								<form>
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
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                    <button type="button" class="btn btn-primary">Save changes</button>
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
