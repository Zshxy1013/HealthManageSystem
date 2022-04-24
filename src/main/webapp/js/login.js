function isEmpty() {
 //   var url = "login"
    var stuID = document.getElementById("stuID").value
    var stuPwd = document.getElementById("stuPwd").value

  /*  var postData = "stuID=" + stuID + "&stuPwd=" + stuPwd

    fetch(url, {method: "POST", body: new URLSearchParams(postData)})
    .then((response) => response.json())
    .then(function(data) {
        console.log(data)
        if (data.success === true) {
            // 登录成功
            alert(data.msg)
            window.location.href = "."
        } else {
            // 后期应该通过HTML5 CANVAS弹窗的方式来显示错误信息
            alert(data.msg)
        }
    })
    return false */

	if(stuID.length==0||stuPwd==0){
        alert("用户名和密码都不能为空!");
        window.location.href="login.jsp"
		return false;
		}
	else{
		return true;
	}
}

function stuIDEmpty(){
    var stuID = document.getElementById("stuID")
     var stuID_err = document.getElementById("stuID_err");
     if(stuID.value.length==0){
         stuID_err.style.display='';
     }
     else{
         stuID_err.style.display='none';
     }
}

function stuPwdEmpty(){
        var stuPwd_err = document.getElementById("stuPwd_err");
    var stuPwd = document.getElementById("stuPwd")
     if(stuPwd.value.length==0){
         stuPwd_err.style.display='';
     }
     else{
          stuPwd_err.style.display='none';
     }
}

function returnStudentIndex(){
    location.href="login.jsp";
}
