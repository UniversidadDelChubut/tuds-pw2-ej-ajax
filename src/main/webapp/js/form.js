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
            if (xhr.status === 400) {
                $errores.html(xhr.responseText).show();
            } else {
                alert("Ha ocurrido un error: " + error);
            }
        }).always(function () {
            $cargando.hide();
        });
    });
});
