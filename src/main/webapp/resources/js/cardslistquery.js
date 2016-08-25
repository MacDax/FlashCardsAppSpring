$(document).ready(function() {
	
	$.ajax({
		url: "http://localhost:8080/flashcardapp/webservices/flashcardapp/cardslist"
	}).then(function(cardslistdata) {
		$("#cardlistdiv").text(cardslistdata);
	})
})