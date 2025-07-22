$("#btn").on("click",function(){
	if($("#num1").val().replace(/\s/g,"")==""){
		alert("숫자를 입력하세요.");
		$("#num1").val("")
		$("#num1").focus();
		return;
	}
	if($("#num2").val().replace(/\s/g,"")==""){
		alert("숫자를 입력하세요.");
		$("#num2").val("")
		$("#num2").focus();
		return;
	}

	$("#frm").attr({
		"method": "post",
		"action": "/servletExample/calcServlet"
	});
	$("#frm").submit();
});