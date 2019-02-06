$(function(){
    $("#bg").hide();
    $("button[name='send']").click(function(){
        $("#bg").fadeIn(1000);
    });
        
    $("button[id='ok']").click(function(){
        $("form").submit();
    });
    $("button[id='no']").click(function(){
        $("#bg").hide();
    });
});