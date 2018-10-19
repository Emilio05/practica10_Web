<!doctype html>
<html lang="en">

<br>
<br>
<br>
<br>
<br>
<div class="row">
    <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-default">
            <div class="panel-heading">LOGIN</div>
            <div class="panel-body">
                <form action="/login" method="post">
                    <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />-->
                    <fieldset>
                        <div class="form-group">
                            <input class="form-control" placeholder="Usuario" name="username" id="username" type="text"
                                   autofocus="">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Contrasena" name="password" id="password" type="password"
                                   value="">
                        </div>
                    </fieldset>
                    <div>
                        <button type="submit" class="btn btn-primary" name="submit" id="submit">Iniciar Sesion</button>
                    </div>
                </form>
            </div>
        </div>
    </div><!-- /.col-->
</div>
</html>