$(function(){
    $("#bg").hide();
    //$("button[name='send']").click(function(){
        //$("#bg").fadeIn(1000);
    //});
        
    //$("button[id='ok']").click(function(){
       // window.location.href="editservlet?editTHREAD_ID=${edit.t_Thread_id}&action=delete";
    //});
    //$("button[id='no']").click(function(){
      //  $("#bg").hide();
    //});
    
    
    function sendClick(){
        $("#bg").fadeIn(1000);
    }
    function okClick(){
        window.location.href="editservlet?editTHREAD_ID=${edit.t_Thread_id}&action=delete";
    }
    function noClick(){
        $("bg").hide();
    }
});