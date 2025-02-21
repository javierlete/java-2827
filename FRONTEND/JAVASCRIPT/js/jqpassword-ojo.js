'use strict';

$(function () {
    $('[type=password]').each(function () {
        var $password = $(this);
        $password.addClass('border-end-0');

        var $ojo = $('<button type="button" class="input-group-text border-start-0"><i class="bi bi-eye-slash"></i></button>').css('background-color', $password.css('background-color'));

        $ojo.on('click', function () {
            $password.attr('type', $password.attr('type') === 'password' ? 'text' : 'password');
            $ojo.html(type === 'password' ? '<i class="bi bi-eye-slash"></i>' : '<i class="bi bi-eye"></i>');
        });

        var $inputGroup = $('<div class="input-group mb-3">');

        $password.after($inputGroup);
        $inputGroup.append($password).append($ojo);
    });
});
