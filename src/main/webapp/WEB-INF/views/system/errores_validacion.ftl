<div class="row">
    <div class="col-lg-5">
        <div class="alert alert-danger">
            <h5>Error al procesar los datos de la solicitud.</h5>
            <ul>
            <#list errores as key, value>
                <li>${key}: ${value?no_esc}.<#sep>,</#sep>
            </#list>
            </ul>
        </div>
        <a href="#" onclick="history.back()" class="btn btn-danger btn-lg">Volver</a>
    </div>
</div>