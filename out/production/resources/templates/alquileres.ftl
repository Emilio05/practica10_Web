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


                                                    <br />
                                                    <div class="box-header with-border">
                                                        <h3 id="numerofactura" name="numerofactura" class="box-title">Factura</h3>
                                                    </div>
                                                    <br>


                                                    <div class="row">
                                                        <div class="col-md-3">
                                                            <div class="form-group">
                                                                <label>Cliente</label>
                                                                <select id="client" name="client" class="form-control select2 select2-hidden-accessible" style="width: 100%;" tabindex="-1" aria-hidden="true" required >
                                                                    <option selected="selected">Seleccionar cliente</option>
                                                                    <#list clientes as cliente>
                                                                    <option value="${cliente}">${cliente.getNombre()}</option>
                                                                    </#list>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-5">
                                                            <div class="form-group">
                                                                <i class="fa fa-calendar"> </i> <label>Fecha</label>
                                                                <div class='input-group'>
                                                                    <div class='input-group date'>
                                                                        <input id="datepicker" name="fecha" class="form-control pull-right" type="date">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-3">

                                                            <div class="form-group">
                                                                <label>Fecha de promesa</label>

                                                                <input id="direccion" name="direccion" class="form-control" type="text" placeholder="Dirección" required/>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="row">
                                                        <div class="col-md-3">
                                                            <div class="form-group">
                                                                <label>Equipo</label>


                                                                <select id="product" name="product" class="form-control select2 select2-hidden-accessible" style="width: 100%" tabindex="-1" aria-hidden="true" required>
                                                                    <option selected="selected">Seleccionar producto</option>
                                                                    <#list equipos as equipo>
                                                                       <option value="${equipo}">${equipo.getNombreEquipo()}</option>

                                                                    </#list>

                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <div class="form-group">
                                                                <label>Cantidad</label>
                                                                <input id="quantity" name="quantity" class="form-control" type="number" value="1" style="width: 75px;" required>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <div class="form-group">
                                                                <label>Condiciones</label>
                                                                <select id="condiciones" name="condiciones" class="form-control" style="width: 100%;" tabindex="-1" aria-hidden="true">

                                                                    <option selected="selected">Al contado</option>
                                                                    <option>A credito</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <label>Añadir Producto</label>
                                                                <button id="addProduct" type="button" class="btn btn-md btn btn-info btn-block" style="width: 100px; height: 40px">
                                                                    <span> <i class="fa fa-plus bigicon"></i></span>
                                                                </button>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <div class="form-group">
                                                                <input type="hidden" id="idproducto" name="idproducto" type="text">
                                                                <input type="hidden" id="items" name="items" value="">
                                                                <input type="hidden" id="idcliente" name="idcliente">
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="table-responsive">
                                                                <table id="productsTable" class="table table-striped table-bordered table-condensed table-hover">
                                                                    <thead>
                                                                    <tr>
                                                                        <th style="width:40px;"></th>
                                                                        <th style="width:50px;">Codigo</th>
                                                                        <th style="width:700;">Descripcion</th>
                                                                        <th style="width:150px;">Cantidad</th>
                                                                        <th style="width:100px;">Precio/Unidad</th>
                                                                        <th style="width:100px;">Total</th>
                                                                    </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                    </tbody>
                                                                    <tfoot>
                                                                    <tr id="st">
                                                                    </tr>
                                                                    <tr id="itb">
                                                                    </tr>
                                                                    <tr id="tot">
                                                                    </tr>
                                                                    </tfoot>
                                                                </table>
                                                            </div>
                                                        </div>
                                                    </div>


                                                    <div class="modal-footer">
                                                        <button onclick="obtenerDatosTabla()" type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>


                                                        <button type="submit"  class="btn btn-info" data-backdrop="true">
                                                            Despachar
                                                        </button>

                                                    </div>


                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
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

<script>


    var arregloCantidad = [];
    var arregloPrecio = [];
    var arregloImpuesto = [];
    var arregloDescuento = [];
    var arregloSubTotal = [];
    var arregloTotal = [];
    var item;
    var items = [];
    var itemList = [];
    var address;
    var date;
    var result = 0;
    var totalFactura = 0;
    var subTotalFactura = 0;
    var itbisFactura = 0;

    function addProductToTable(){
        var rows = "";
        var nombreProducto = document.getElementById('product').value;
        var cantidadProducto = document.getElementById('quantity').value;
        var precioProducto = document.getElementById('price').value;
        var totalProducto = parseFloat(cantidadProducto) * parseFloat(precioProducto);
        rows += "<td><button class=\"btn btn-danger btn-xs btn-block\"\" onclick=\"removeProductFromTable(this)\">X</button></td><td>"+ nombreProducto +
                "</td><td>Consulta SQL</td><td>"+ cantidadProducto + "</td><td>"+ precioProducto + "</td><td> " + totalProducto + "</td>";

        var tbody = document.querySelector("#productsTable tbody");
        var tr = document.createElement("tr");
        tr.innerHTML = rows;
        tbody.appendChild(tr);

    }

    function calculateSubTotal(){

        var result = 0;
        var tbody = document.querySelector("#productsTable tbody");
        var rows = tbody.rows.length;
        for(var i = 0; i<rows; i++){
            var thisTrElem = tbody.rows[i];
            var thisTdElem = thisTrElem.cells[5];
            var thisTextNode = thisTdElem.childNodes.item(0);
            var thisNumber = parseFloat(thisTextNode.data);
            result+=thisNumber;
        }
        result = result.toLocaleString('en')
        //var itbis = result*0;
        var itbis = 0;
        itbisFactura = itbis;
        // var total = result + itbis;
        var total = result;
        total = total.toLocaleString('en')
        totalFactura = total;

        var row =  document.getElementById("st");
        var row2 = document.getElementById("itb");
        var row3 = document.getElementById("tot")
        row.innerHTML = "<td id=\"subtotal\" colspan=\"5\" class=\"text-right\"><b>Sub Total $</b></td><td class=\"text-left\">" + result +"</td>";
        row2.innerHTML = "<td colspan=\"5\" class=\"text-right\"><b>ITBIS $</b></td><td class=\"text-left\">" + itbis.toFixed(2) + "</td>";
        row3.innerHTML = "<td colspan=\"5\" class=\"text-right\"><b>Total $</b></td><td class=\"text-left\">" + total + "</td>";
    }

    function removeProductFromTable(btn){
        var row = btn.parentNode.parentNode;
        row.parentNode.removeChild(row);
        calculateSubTotal();
    }

    $(document).ready(function() {

        $('#client').on('change',function(){
            var address = $(this).val();
            var a = JSON.parse(address);
            $('#direccion').val(a.direccion);
        });
        $('#product').on('change',function(){
            var producto = $(this).val();
            var a = JSON.parse(producto);
            $('#idproducto').val(a.id);
        });

        $('#product').on('change',function(){
            var producto = $(this).val();
            var a = JSON.parse(producto);
            $('#price').val(a.precio1);
        });

    });


    $(document).ready(function(){

        $('.select2').select2();
        $("#addProduct").click(function(){

            var found = false;
            var cantidadProducto = $('#quantity').val();
            var precioProducto =$('#price').val();
            var totalProducto = parseFloat(cantidadProducto) * parseFloat(precioProducto);
            var descripcionaux = $('#product').val();
            var descripcion = JSON.parse(descripcionaux);
            var nombreProducto = $('#product').val();
            var nombreProducto2 = JSON.parse(nombreProducto);
            var impuestoaux = $('#product').val();
            var impuesto = JSON.parse(impuestoaux);

            var cliente = $('#client').val();
            var cliente2 = JSON.parse(cliente);
            // console.log(cliente);
            // arregloCantidad.push(cantidadProducto);
            // arregloTotal.push(totalProducto);
            // arregloPrecio.push(precioProducto);

            var result =  parseFloat(cantidadProducto);
            var tbody = document.querySelector("#productsTable tbody");
            var rowsn = tbody.rows.length;
            for(var i = 0; i<rowsn; i++){

                var thisTrElem = tbody.rows[i];
                var thisTdElem = thisTrElem.cells[1];

                if(thisTdElem.childNodes.item(0).data == nombreProducto2.id){
                    result+=parseFloat(thisTrElem.cells[3].childNodes.item(0).data);
                    found = true;

                }
            }

            var totalProducto2 = parseFloat(result) * parseFloat(precioProducto);
            var cliente = $('#client').val();
            var cliente2 = JSON.parse(cliente);
            $('#idcliente').val(JSON.stringify(cliente2.id));
            // console.log(cliente);

            // arregloCantidad.push(cantidadProducto);
            // arregloTotal.push(totalProducto);
            // arregloPrecio.push(precioProducto);
            if(found == false){
                var markup ="<tr><td><button class=\"btn btn-danger btn-xs btn-block\"\" onclick=\"removeProductFromTable(this)\">X</button></td><td>"+ nombreProducto2.id +
                        "</td><td>"+descripcion.descripcion+"</td><td>"+ result + "</td><td>"+ precioProducto + "</td><td> " + totalProducto2 + "</td></tr>";



                $("#productsTable tbody").append(markup);
            }

            else{

                var tableRow = $("td").filter(function() {
                    return $(this).text() == nombreProducto2.id;
                }).closest("tr");

                var markup ="<tr><td><button class=\"btn btn-danger btn-xs btn-block\"\" onclick=\"removeProductFromTable(this)\">X</button></td><td>"+ nombreProducto2.id +
                        "</td><td>"+descripcion.descripcion+"</td><td>"+ result + "</td><td>"+ precioProducto + "</td><td> " + totalProducto2 + "</td></tr>";



                $(tableRow).replaceWith(markup);

            }

            calculateSubTotal();

            //  item = {
            //   idcliente: cliente2.id,
            //   idproducto: descripcion.id,
            //   nombre: nombreProducto,
            //   descripcion: descripcion.descripcion,
            //   cantidad: cantidadProducto,
            //   precio: precioProducto,
            //   subtotal: totalProducto,
            //   impuesto: impuesto.impuestos,
            //   total: totalProducto,
            //   totalFactura: totalFactura,
            //   itbis: itbisFactura
            // };

            // items.push(item);

            //  $('#items').val(JSON.stringify(items));

        });

    });

    function obtenerDatosTabla() {


        var oTable = document.getElementById('productsTable');

        //gets rows of table
        var rowLength = oTable.rows.length;

        //loops through rows
        for (i = 1; i < rowLength; i++){

            items = [];
            //gets cells of current row
            var oCells = oTable.rows.item(i).cells;

            //gets amount of cells of current row
            var cellLength = oCells.length;

            //loops through each cell in current row
            for(var j = 1; j < cellLength; j++){

                // get your cell info here

                var cellVal = oCells.item(j).innerHTML;

                items.push(cellVal);


            }
            itemList.push(items);
            //alert(itemList[i-1]);
        }
        $('#items').val(JSON.stringify(itemList));

    }





</script>
