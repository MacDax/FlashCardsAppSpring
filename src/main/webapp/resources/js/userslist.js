$(document).ready(function() {
	
	$.ajax({
		url: "http://localhost:8080/flashcardapp/webservices/flashcardapp/users",
	}).then(function(userslistdata) {
		var txt;
		
		$.each(userslistdata, function(i, item) {
			txt = txt+i;
			txt = $("<div></div>").text(userslistdata[i].fname);
			$("#userslistdiv").append(txt);
		});
		
	})
})