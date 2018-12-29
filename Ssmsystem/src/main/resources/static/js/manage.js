
var params = {};
params=windos.document.getElementById("sin").options[index].value;
$.ajax({
    async:false,
    type: "POST",
    url: "/managecontroller/update",
//注意路径
    data:params,
    dataType:"json",
    success:function(data){
        if(data.result=='SUCCESS'){
            alert("修改成功");
        }else{
            alert("修改失败，失败原因【" + data + "】");
        }
        },
    error:function(data){
        alert(data.result);
    }
});
