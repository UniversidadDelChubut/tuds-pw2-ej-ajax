<script src="${context_path}/bower_components/jquery/dist/jquery.min.js"></script>
<script src="${context_path}/js/form.js"></script>
<h2>Contacto</h2>
<fieldset>
    <legend>Complete la siguiente información.</legend>
    <div class="errores"></div>
    <form action="${context_path}/contacto/enviar" method="post" class="contacto">
    <div class="fila">Su nombre:<br> <input type="text" name="nombre"/></div>
    <div class="fila">Su email: <br><input type="email" name="email"/></div>
    <div class="fila">
        Motivo de su consulta: <br>
        <select name="motivo">
            <option value="">Seleccione</option>
        <#list motivos as item>
            <option value="${item.id}">${item.value}</option>
        </#list>
        </select>
        </div>
    <div class="fila">Su comentario: <br><textarea name="comentario" rows="5" cols="60"></textarea></div>
    <a href="${context_path}">Volver al inicio</a> &nbsp;&nbsp;&nbsp;
    <button type="submit">Enviar información</button> <span class="cargando">Cargando...</span>
</fieldset>

<style>
    fieldset {width: 600px;}
    div.fila { margin-bottom: 20px; }
    div.errores {padding: 20px; background-color: #f05b5b; margin: 10px; display: none;}
    span.cargando {display: none; font-weignt: bold;}
</style>
