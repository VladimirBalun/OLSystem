$(document).ready(function(){

    var i = 0;

    function timer() {
        $(".timer").html(i++);
    }

    $("button[name='btn_sign_in']").click(function () {
        setInterval(timer, 1000);
    });

});