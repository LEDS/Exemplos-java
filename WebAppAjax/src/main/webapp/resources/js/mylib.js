//Funcao responsavel por buscar os locais que um usuario esta habilitado
function ajaxGetLocation(){
	
	var val = $("#login").val();
	
	$.ajax({
		type: "post",
		url: "http://localhost:8080/webappajax/locais",
		cache: false,
		data:val,
		Accept : "application/json",
        contentType: "application/json",
		success: function(response){
			
			//Apagando os option que foram preenchidos
			$('#local').find('option').remove().end();
			//Preenchendo o select com os valores do serviço
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

function verifyYear()
{
	var idade = $("#idade").val();
	
	if (idade == 900)
	{
		$('#result').html("<strong>Vc é o YODA</strong>");
	}
	else{
		$('#result').html("<strong>Vc não é o YODA</strong>");
	}
	
}