/*$(function(){
	$("#des_ml li").click(function(){
		$(this).parent().find(".checked").css("border","1px solid orange");
		$(this).css("border","0px solid orange");
	});
});*/

$(function(){
	$("#des_ml li").click(function(){
		$(this).parent().find(".checked").removeClass("checked");
		$(this).addClass("checked");
	});
});