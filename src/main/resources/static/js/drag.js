$(document).ready(function () { //页面加载完后执行
    $('.dragclose').click(function () {
        $('.drag').css('display','none');
        location.reload();
    })


    $('.dragtop').mousedown(function(e){
        dragbox = $('.drag');
        var x = e.pageX - parseInt(dragbox.css('left'));
        var y = e.pageY - parseInt(dragbox.css('top'));;
        dragbox.mousemove(function (ev) {
            dragbox.css( 'left',ev.pageX - x );
            dragbox.css('top',ev.pageY - y );
        })
    });

    $('.dragtop').mouseup(function(){
        $('.drag').unbind("mousemove");
    });

    $('.dragshow').click(function(){
        $('.drag').css("display","inline-block");
    });


})
