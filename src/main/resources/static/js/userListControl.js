$("#addOne").click(function (){
    console.log("add");
    //tr length
    var length = $("#userListTable tr").length;
    console.log(length);
    //创建td并添加内容
    var $td_id = $("<td></td>").html("<input name=userList["+length+"].id />");
    var $td_name = $("<td></td>").html("<input name=userList["+length+"].name />");
    var $td_age = $("<td></td>").html("<input name=userList["+length+"].age />");
    var $td_career = $("<td></td>").html("<input name=userList["+length+"].career />");

    //创建tr并添加td
    var $tr = $("<tr></tr>").append($td_id).append($td_name)
        .append($td_age).append($td_career);

    //表格最后一行增加tr
    $("#userListTable").append($tr);

});

$("#deleteOne").click(function (){
    console.log("delete");
    $("table tr:last").remove();
});