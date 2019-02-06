$(function(){

	// var $hantei=$("div[class='hantei']").attr("hanteiid");
	
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
    
    // if($hantei=="toko"){
    	// console.log("îªíËÇÕÇ§Ç‹Ç≠Ç¢Ç¡ÇƒÇ¢ÇÈÅB");
    	// $("#tokolog").fadeIn(50);
    	// $("#tokolog").fadeOut(3000);
    // }
    
    
    
    
    
});