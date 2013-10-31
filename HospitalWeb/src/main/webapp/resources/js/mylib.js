function ajaxDeletarHospital(id) {

	$.ajax({
		type : "post",
		url : "http://localhost:8080/hospitalweb/remover/" + id,
		cache : false,
		Accept : "application/json",
		contentType : "application/json",
		success : function(response) {
			location.href = "http://localhost:8080/hospitalweb/visualizar"; //Atualiza a pagina apos a exclusao do Hospital.
		},
		error : function(response, status, error) {
			alert('Status' + status + "Error: " + error);
		}
	});
}