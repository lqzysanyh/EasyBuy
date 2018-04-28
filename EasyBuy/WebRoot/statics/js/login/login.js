/**
 * 登录
 */
function login(){
	
	var loginName=$("#loginName").val();
	var password=$("#password").val();

	if(loginName==null || loginName==""){
        showMessage("用户名不能为空.");
        return;
    }
	if(password==null || password==""){
        showMessage("密码不能为空.");
        return;
    }
	
    $.ajax({
        url:contextPath+"/Login",
        method:"post",
        data:{loginName:loginName,password:password,action:"login"},
        success:function(jsonStr){
            var result=eval("("+jsonStr+")");
            if(result.status==1){
                window.location.href=contextPath+"/Home?action=index";
            }else{
                showMessage(result.message)
            }
        }
    })
}