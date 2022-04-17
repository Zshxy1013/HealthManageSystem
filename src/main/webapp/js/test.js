function isLogin() {
    var url = "login"
    var stuID = document.getElementById("stuID").value
    var stuPwd = document.getElementById("stuPwd").value

    var postData = "stuID=" + stuID + "&stuPwd=" + stuPwd

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
    return false
}