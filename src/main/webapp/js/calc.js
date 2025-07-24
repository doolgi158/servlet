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
	if($("#operator").val() === "/"){
		if($("#num1").val() == "0" || $("#num2").val() == "0"){
			alert("0으로 나눌 수 없습니다.")
			return;
		}
	}

	$("#frm").attr({
		"method": "post",
		"action": "/servletExample/calcServlet"
	});
	$("#frm").submit();
	
	/*$.ajax({
		url: "/servletExample/calcServlet2",	// 요청 url
		method: "post",	// 전송방식(get/post)
		data: {
			"num1": $("#num1").val(),
			"operator": $("#operator").val(),
			"num2": $("#num2").val()
		},
		//data : $("#frm").serialize(),	// 서버에 전달한 파라미터(serialize(): 폼 전체 데이터 전송하는 메서드)
		dataType: "text"	// 서버로부터 응답받을 문서 타입(text/json/xml)
	}).done(function (data){
		console.log(data);
		$("#result").val(data);
	}).fail(function(xhr, status){
		alert(status + " 발생.\n상태: " + xhr.status);
	});*/
});