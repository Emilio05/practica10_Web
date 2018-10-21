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
                    <h3 class="panel-title">SubFamilias</h3>
                    <hr>
                </div>

                <div class="panel-body">
                    <button class="btn btn-primary" data-toggle="modal" data-target="#modalSubFamilia">Crear SubFamilia</button>
                    <form method="POST" action="/subfamilias/" >
                        <div class="modal fade" id="modalSubFamilia" tabindex="-1" role="dialog" aria-labelledby="modalSubFamiliaLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="modalSubFamiliaLabel">Crear SubFamilia</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre de la SubFamilia" required>
                                        <select id="categoria" name="categoria" class="form-control select2 select2-hidden-accessible" required>
                                                    <#list categorias as category>
                                                        <option value="${category.getNombreCategoria()}">${category.getNombreCategoria()}</option>
                                                    </#list>
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
                        <table id="subfamiliastable" class="table table-striped table-bordered table-condensed table-hover table-sm">
                            <thead>
                            <th class="text-center">Codigo</th>
                            <th class="text-center">Nombre de SubFamilia</th>
                            <th class="text-center">Categoria</th>
                            <th class="text-center">Opciones</th>


                                <#list subFamilias as subfamilia>
                                <tr>

                                    <td class="text-center">${subfamilia.getId()}</td>
                                    <td class="text-center">${subfamilia.getNombreSubFamilia()}</td>
                                    <td class="text-center">${subfamilia.getCategoria().getNombreCategoria()}</td>
                                    <td class="text-center">
                                        <div class="btn-group">
                                            <a href="/subfamilias/${subfamilia.getId()}" class="btn btn-danger"><i class="fa fa-trash aria-hidden="true"></i></a>
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
