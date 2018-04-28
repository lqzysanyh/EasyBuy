$(function(){
	$(".level1").toggle(function(){
		$(this).find(".level2").css("display","block");
	},function(){
		$(this).find(".level2").css("display","none");
	}
);
var panDing = 0;
$(window).scroll(function() {
    /*if ($(document).scrollTop()<=0){
      alert("滚动条已经到达顶部为0");
    }*/
    var doc_height = $(document).height();
	var scroll_top = $(document).scrollTop(); 
	var window_height = $(window).height();
	
	if(scroll_top + window_height >= doc_height-1){
		var count = $(".fresh_mid ul li").length;
		var address = location.href;
		//alert(location.host)
		if(address=="http://"+location.host+"/EasyBuy/PHome?action=index"){
		$.post("POther","count="+count,success,"JSON");
		function success(data){			
			var last = $("#content ul");/*.children("li:last-child")*/
			var $html = '';
			for(var i in data){
				$html+='<li>'+
				'<div class="img">'+
				'<a href="'+contextPath+'/PProduct?action=queryProductDeatil&id='+data[i].id+'">'+
                   ' <img src="'+contextPath+'/files/'+data[i].fileName+'" width="185"  height="155"/>'+
                '</a>'+
            '</div>'+
           ' <div class="name"><span class="price">'+
                '<font>￥<span>'+data[i].price+'</span></font> &nbsp;'+
               ' </span>'+
                '<a href="#">'+data[i].name+'</a>'+
           '</div>'+
            '</li>';
			}
			last.append($html);
		}
		
	}
	}
});

});