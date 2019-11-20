$(function () {
    $("form.contacto").on("submit", function (ev) {
        ev.preventDefault();

        var $form = $(this);
        var url = $form.attr("action");
        var $cargando = $("span.cargando");
        var $errores = $("div.errores");

        $.ajax({
            type: "POST",
            url: url,
            data: $form.serialize(),
            beforeSend: function () {
                $cargando.show();
            }
        }).done(function (data) {
            $errores.html("").hide();
            window.top.location = "/ej_ajax/contacto/gracias";
        }).fail(function (xhr, status, error) {
            var data = {"global": "Ocurrió un error en la aplicación: " + error};
            if(xhr.status === 400) {
                try {
                    data = JSON.parse(xhr.responseText);
                } catch (e) {
                    data = {"global": "No se pudo procesar la respuesta del servidor."};
                }
            }
            
            var $ul_errores = $("<ul></ul>");
            $.each(data, function(key, value) {
                var $li = $("<li></li>");
                $li.text(value);
                $ul_errores.append($li);
            });            
            $errores.html($ul_errores).show();
            
        }).always(function () {
            $cargando.hide();
        });
    });
});
