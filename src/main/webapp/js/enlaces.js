$(function () {
    $("a.enlace").on("click", function (ev) {
        ev.preventDefault();

        var $enlace = $(this);
        var url = $enlace.attr("href");
        var $cargando = $("span.cargando");
        var $resultado = $("div.resultado");

        $.ajax(url, {
            beforeSend: function () {
                $cargando.show();
            }
        }).done(function (data) {
            $resultado.html(data);
        }).fail(function (xhr, status, error) {
            alert("Ha ocurrido un error: " + error);
        }).always(function () {
            $cargando.hide();
        });
    });
});
