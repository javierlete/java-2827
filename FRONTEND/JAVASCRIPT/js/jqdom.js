'use strict';

$(function () {
    console.log($('h1').text());

    $('h1').text('Prueba de JavaScript');

    console.log($('li'));

    let num = 1;

    $('li').each(function () {
        console.log($(this).text());
        $(this).text($(this).text() + num++);
    });

    $('li').each(function () {
        console.log($(this).html())
    });

    $('ul').append($('<li>').text('Cuatro').addClass('generado').css('background-color', 'red'));
    $('ul').append($('<li class="generado" style="background-color: red;">Cuatro</li>'));
});
