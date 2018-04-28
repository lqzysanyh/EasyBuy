/**
 * 登录
 */
function login(){
	
	var loginName=$("#loginName").val();
	var password=$("#password").val();

	if(loginName==null || loginName==""){
        alert("用户名不能为空.");
        return;
    }
	if(password==null || password==""){
		alert("密码不能为空.");
        return;
    }
    $.ajax({
        url:contextPath+"/PLogin",
        method:"post",
        data:{loginName:loginName,password:password,action:"login"},
        success:function(jsonStr){
            var result=eval("("+jsonStr+")");
            if(result.status==1){
                window.location.href=contextPath+"/PHome?action=index";
            }else{
            	alert(result.message)
            }
        }
    })
}