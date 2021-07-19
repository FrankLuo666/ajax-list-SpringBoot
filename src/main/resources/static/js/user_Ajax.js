console.log("userJson");
//1.为用户名绑定失去焦点事件
$("#Ajax_Test").click(function (){
    console.log("user Ajax Test");
    let userBean ={};
    userBean["username"] = $("input[name='name']")[0].value;
    console.log(JSON.stringify(userBean));
    //2.jQuery的通用方式实现AJAX
    $.ajax({
        //请求资源路径
        url:"/userAjax",
        //是否异步
        async:true,
        //请求方式
        type:"POST",
        //内容编码类型
        contentType:"application/json",
        //数据形式
        dataType:"json",
        //请求参数
        // data:JSON.stringify(userBean),
        data:JSON.stringify(userBean),
        cash:false,
        timeout:60000,
        //请求成功后调用的回调函数
        success:function (data) {
            //将响应的数据显示到span标签
            let json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data,null,4) + "</pre>";
            let username = json + "<br>username : "+ data.username;
            $('#feedback').html(username);
            console.log("SUCCESS : ", data);
        },
        //请求失败后调用的回调函数
        error:function () {
            alert("操作失败...");
        }
    });
});