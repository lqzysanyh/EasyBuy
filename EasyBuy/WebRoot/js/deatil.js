$(function(){
	$("#des_ml li").click(function(){
		$(this).parent().find(".checked").removeClass("checked");
		$(this).addClass("checked");
	});
});