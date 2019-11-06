<script src="${context_path}/js/jquery-3.4.1.min.js"></script>
<script src="${context_path}/js/enlaces.js"></script>
<h2>Ejemplo AJAX</h2>
<#list 1..5 as item>
<a href="${context_path}/home/seccion${item}" class="enlace enlace-${item}" data-numero="${item}">Sección ${item}</a><#sep> | 
</#list>
 | <a href="${context_path}/contacto">Contacto</a>

<span class="cargando">Cargando...</span>

<hr>
<div class="resultado">Seleccione un elemento.</div>
<style>
    span.cargando { display:none; color: white; background-color: #ff2626; padding: 10px; margin-left: 10px;} 
    div.resultado {padding: 10px;}
</style>
