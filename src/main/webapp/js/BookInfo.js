$("#btn").on("click", function(){
	if($("#title").val().replace(/\s/g,"")=="") {
		alert("제목을 입력하세요.");
		$("#title").val("");
		$("#title").focus();
		return;
	}
	if($("#writer").val().replace(/\s/g,"")=="") {
		alert("저자를 입력하세요.");
		$("#writer").val("");
		$("#writer").focus();
		return;
	}
	if($("#publicer").val().replace(/\s/g,"")=="") {
		alert("출판사를 입력하세요.");
		$("#publicer").val("");
		$("#publicer").focus();
		return;
	}
	
	$("#fm").attr({
		"method": "post",
		"action": "/servletExample/bookInput"
	});
	
	$("#fm").submit();
});