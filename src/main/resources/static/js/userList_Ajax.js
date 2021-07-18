console.log("userlist");

//1.为用户名绑定失去焦点事件
$("#addOne").click(function (){
    console.log("add");
    let list =[];
    let userBean ={};
    let index =0;
    userBean["name"] = $("input[name='name']")[index].value;
    userBean["age"] = $("input[name='age']")[index].value;
    list.push(userBean);
    list.push(userBean);
    console.log(JSON.stringify(list));
    // let testList = [{"name":"张三","age":"23"},{"name":"李四","age":"24"}];
    //2.jQuery的通用方式实现AJAX
    $.ajax({
        //请求资源路径
        url:"/addUser",
        //是否异步
        async:true,
        //请求方式
        type:"POST",
        //内容编码类型
        contentType:"application/json",
        //数据形式
        dataType:"json",
        //请求参数
        data:JSON.stringify(list),
        cash:false,
        timeout:60000,
        //请求成功后调用的回调函数
        success:function (data) {
            console.log("SUCCESS : ", data);
            //将响应的数据显示到span标签
            let json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data)+ "</pre>";
            $('#feedback').html(json);

            //delete list from the table
            $("#userListTable tbody").html("");

            //create new list according to the response JSON
            for (let i=0;i<data.length;i++){
                //创建td并添加内容
                var $td_id = $("<td></td>").html("<input name=name value="+data[i].age+" />");
                /*var $td_name = $("<td></td>").html("<input name=userList["+length+"].name />");
                var $td_age = $("<td></td>").html("<input name=userList["+length+"].age />");
                var $td_career = $("<td></td>").html("<input name=userList["+length+"].career />");*/

                //创建tr并添加td
                /*var $tr = $("<tr></tr>").append($td_id).append($td_name)
                    .append($td_age).append($td_career);*/
                var $tr = $("<tr></tr>").append($td_id);

                //表格最后一行增加tr
                $("#userListTable").append($tr);
            }

        },
        //请求失败后调用的回调函数
        error:function () {
            alert("操作失败...");
        }
    });
});

//delete one from the list;
$("#deleteOne").click(function (){
    console.log("delete");
    $("table tr:last").remove();
});
