<h3>Otras cosas</h3>

<@flash name="error">
 <div class="alert alert-error"><@flash name="error"/></div>
</@flash>
 
 <@flash name="mensaje">
 <div class="alert alert-success"><@flash name="mensaje"/></div>
</@flash>
<div style="width: 30%">
<fieldset>
    <legend>Envío de correo</legend>
    <form action="${context_path}/otras_cosas/mandarMail" method="post">
        <p>Su nombre: <br><input type="text" name="su_nombre" value="${request.su_nombre!}" required/></p>
        <p>Su correo: <br><input type="email" name="su_email" value="${request.su_email!}" required/></p>
        <p>Su comentario:<br>
            <textarea name="su_comentario" rows="5" required>${request.su_comentario!}</textarea>
        <button type="submit">Enviar correo</button>
    </form>
</fieldset>    
</div>

<style>
    div.alert {padding: 5px;}
    div.alert-error {background-color: #ff5c5c;}
    div.alert-success {background-color: #b0ff82;}
</style>