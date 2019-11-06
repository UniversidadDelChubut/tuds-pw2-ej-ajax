<h3>Verificación de token</h3>

<#if error?has_content>
 <div class="alert alert-error">${error}</div>
</#if>
 
 <#if token_verificado?has_content>
<div style="width: 30%">
<fieldset>
    <legend>Token verificado.</legend>
    <p>Issuer: ${token_verificado.issuer}</p>
    <p>Subject: ${token_verificado.subject}</p>
    
</fieldset>    
</div>
</#if>
 
<a href="${context_path}/otras_cosas">Volver</a>
 
<style>
    div.alert {padding: 5px;}
    div.alert-error {background-color: #ff5c5c;}
    div.alert-success {background-color: #b0ff82;}
</style>