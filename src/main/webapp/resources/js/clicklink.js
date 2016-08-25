$(document).ready(function() {

	$("#decklist").click(function(event){
		/*console.log($(this).attr('href'))
		 createCardlist($(this).attr('href'));
	 	  return false;*/
	 	  
	var inurl = "http://localhost:8080/flashcardapp/webservices/flashcardapp/";
	var link = $(this).attr('href');
	var link1 = link.slice(0,8);
	var link2 = link.slice(link.length()-1); 
	inurl = inurl+"/"+ link1 + link2;
	console.log( " inue " + $(this).attr('href'));
	event.preventDefault();	  
    event.stopPropagation();
	return false;
	});
});
	/*$.get(inurl, function(decklistdata) {
		var txt;
		$.each(decklistdata, function(i, item) {
			txt = txt+i;
			txt = $("<div></div>").text(decklistdata[i].title);
			$("#decklistdiv").append(txt);
		});
		return false;
	})*/
	
	/*$.ajax({
		url:   inurl
	}).then(function(decklistdata) {
		var txt;
		$.each(decklistdata, function(i, item) {
			txt = txt+i;
			txt = $("<div></div>").text(decklistdata[i].title);
			$("#decklistdiv").append(txt);
		});
		event.preventDefault();	  
	    event.stopPropagation();
		return false;
	})
		event.preventDefault();	  
	    event.stopPropagation();
	    
	});*/
	
//});

/*function createCardList(uid) {
	var inurl = "http://localhost:8080/flashcardapp/webservices/flashcardapp/";
	inurl = inurl+"/"+ uid;
	console.log(inurl);
	$.ajax({
		url:   inurl
	}).then(function(decklistdata) {
		var txt;
		$.each(decklistdata, function(i, item) {
			txt = txt+i;
			txt = $("<div></div>").text(decklistdata[i].title);
			$("#decklistdiv").append(txt);
		});
	})*/
