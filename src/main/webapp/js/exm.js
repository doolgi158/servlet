$("#sub").on("click", function(){
	$("#fm").attr({
		"method": "post",
		"action": "/servletExample/exm"
	});
	
	$("#fm").submit();
});