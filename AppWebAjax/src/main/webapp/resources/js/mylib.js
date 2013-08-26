function ajaxCall(){
	$.ajax({
		type: "get",
		url: "http://localhost:8080/webappajax/isWorking",
		cache: false,				
		success: function(response){
			$('#result').html("");
			$('#result').html("Mensagem: "+response);
		},
		error: function(response, status, error){
			$('#result').html("");
			$('#result').html("Error: "+error);
		}
	});
}

function ajaxGetLocal(){
	
	var val = $("#login").val();
	$.ajax({
		type: "post",
		url: "http://localhost:8080/webappajax/locais",
		cache: false,
		data:val,
		Accept : "application/json",
        contentType: "application/json",
		success: function(response){
			
			$('#local').find('option').remove().end();
			
			$.each(response,function(idx, obj){ 
		        $.each(obj, function(key, value){
		        	$("#local").append("<option value='" + value + "'>" + value + "</option>");
		        });
		    });
			
		},
		error: function(response, status, error){
			$('#result').html("");
			$('#result').html('Status'+status+"Error: "+error);
		}
	});
}