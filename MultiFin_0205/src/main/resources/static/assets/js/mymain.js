// 첫 번째 section의 배경색이 어두우면 헤더 글씨 밝게, 밝으면 어둡게
window.addEventListener('load', function(){
    const windowMode = document.querySelectorAll('.section');
    const navbar = document.querySelector('.navbar');

    // if(windowMode[0].classList.contains('bg-soft') || windowMode[0].classList.contains('bg-white')){
    //     navbar.classList.remove('navbar-dark');
    //     navbar.classList.add('navbar-light');
    // }
    if(windowMode[0].classList.contains('bg-dark') || windowMode[0].classList.contains('bg-primary') || windowMode[0].classList.contains('bg-tertiary')){
        navbar.classList.remove('navbar-light');
        navbar.classList.add('navbar-dark');
    } else{
        navbar.classList.remove('navbar-dark');
        navbar.classList.add('navbar-light');
    }
});




// Background images for sections
$('[data-background]').each(function () {
  $(this).css('background-image', 'url(' + $(this).attr('data-background') + ')');
});

$('[data-background-inner]').each(function () {
    $(this).find('.inner-bg').css('background-image', 'url(' + $(this).attr('data-background-inner') + ')');
});

$('[data-background-color]').each(function () {
    $(this).css('background-color', $(this).attr('data-background-color'));
});

$('[data-color]').each(function () {
    $(this).css('color', $(this).attr('data-color'));
});
