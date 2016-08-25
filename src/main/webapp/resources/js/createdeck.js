$document.ready(function() {
	/*$.ajax({
		url: "http://localhost:8080/flashcardapp/webservices/flashcardapp/decklist"
	}).then(function(deckdata){
		$("#successMessage").text("deckdata");
	}); */
	
	
})

function createDeck(deckData) {
	$.ajax({
		type:"POST",
		url: "http://localhost:8080/flashcardapp/webservices/flashcardapp/decklist",
		data: deckData.toJsonString(),
		contentType:"application/json; charset=utf-8",
		dataType:"json",
		success: function(data, status, jqXHR) {
			//do soemthing
		},
		
		error: function(jqXHR, status) {
			//error handler
		}
	})
}