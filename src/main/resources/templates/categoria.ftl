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
                    <h3 class="panel-title">Familias</h3>
                    <hr>
                </div>
                <div class="panel-body">


                    <button class="btn btn-primary" data-toggle="modal" data-target="#modalCategorias">Crear Familia</button>
                    <form method="POST" action="/categorias/">
                        <div class="modal fade" id="modalCategorias" tabindex="-1" role="dialog" aria-labelledby="modalCategoriasLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="modalCategoriasLabel">Crear Familia</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre Familia">
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                        <input type="submit" value="Guardar" class="btn btn-primary" />
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>

                    <div class="table-responsive">
                        <table id="categoriastable" class="table table-striped table-bordered table-condensed table-hover table-sm">
                            <thead>
                            <th class="text-center">Codigo</th>
                            <th class="text-center">Nombre de Familia</th>
                            <th class="text-center">Opciones</th>


                                <#list categorias as categoria>
                                <tr>
                                    <td class="text-center">${categoria.getId()}</td>
                                    <td class="text-center">${categoria.getNombreCategoria()}</td>
                                    <td class="text-center">
                                        <div class="btn-group">
                                            <a href="/categorias/${categoria.getId()}" class="btn btn-danger"><i class="fa fa-trash aria-hidden="true"></i></a>
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
