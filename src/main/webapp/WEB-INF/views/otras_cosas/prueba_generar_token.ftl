<h3>Generación de Token JWT</h3>

<#if error?has_content>
 <div class="alert alert-error">${error}</div>
</#if>
 
<#if token?has_content>
<div style="width: 30%">
<fieldset>
    <legend>Verificar token</legend>
    <form action="${context_path}/otras_cosas/prueba_verificar_token" method="post">
        <p>Token generado:<br>
            <textarea name="token" rows="5" cols="80" required>${token}</textarea>
        <button type="submit">Validar token</button>
    </form>
</fieldset>
</div>
</#if>

<a href="${context_path}/otras_cosas">Volver</a>
 
<style>
    div.alert {padding: 5px;}
    div.alert-error {background-color: #ff5c5c;}
    div.alert-success {background-color: #b0ff82;}
</style>