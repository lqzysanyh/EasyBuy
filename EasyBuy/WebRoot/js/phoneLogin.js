/**
 * 登录
 */
function login(){
	
	var phone=$("#phone").val();
	var checkNum=$("#checkNum").val();

	var reg = /^[1][0-9]{10}$/; 
	if(phone==null || phone==""){
        alert("用户名不能为空!");
        return;
    }
	if(reg.test(phone)==false){
		alert("请输入正确的手机号码!");
        return;
	}
	if(checkNum==null || checkNum==""){
		alert("验证码不能为空.");
        return;
    }
	
    $.ajax({
        url:contextPath+"/PLogin",
        method:"post",
        data:{phone:phone,checkNum:checkNum,action:"phoneLogin"},
        success:function(jsonStr){
            var result=eval("("+jsonStr+")");
            if(result.status==1){
                window.location.href=contextPath+"/PHome?action=index";
            }else{
            	alert(result.message);
            }
        }
    })
}
var num;
var second=60;
function daoJiShi(){
		second--;
		if(second==0){
			clearInterval(loop);
		}
		$("#DaoJiShi").text(second+"秒继续发送");
}

var loop ;

function getNum(){
	var phone=$("#phone").val();
	
	var reg = /^[1][0-9]{10}$/; 
	if(phone.length==0){
        alert("用户名不能为空!");
        return;
    }
	if(reg.test(phone)==false){
		alert("请输入正确的手机号码!");
        return;
	}
	$("#getNum").hide();
	$("#DJS").show();
	loop = setInterval(daoJiShi,1000);
	if(second==0){
		second=60;
		$("#getNum").show();
		$("#DJS").hide();
	}
	
	
	
	$.ajax({
        url:contextPath+"/PLogin",
        method:"post",
        data:{phone:phone,action:"sendCheckNum"},
        dateType:"json",
        success:function(jsonStr){
            if(result.status==1){
                
            }else{
            	alert(result.message);
            }
        }
    });
	
}
