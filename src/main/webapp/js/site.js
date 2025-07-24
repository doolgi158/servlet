$("#btn").on("click", function(){
	if(!$("input[name='site']").is(":checked")){
		alert("이동할 사이트를 선택해 주세요");
		return;
	}
	$("#siteForm").attr({
		"action": "/servletExample/portalSite",
		"method": "get"
	});
	$("#siteForm").submit();
});