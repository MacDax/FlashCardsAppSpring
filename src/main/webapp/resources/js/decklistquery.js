$(document).ready(function() {
	
	$.ajax({
		url: "http://localhost:8080/flashcardapp/webservices/flashcardapp/decklist"
	}).then(function(decklistdata) {
		/*var txt;
		
		$.each(decklistdata, function(i, item) {
			txt = txt+i;
			txt = $("<div></div>").text(decklistdata[i].title);
			$("#decklistdiv").append(txt);
		});*/
		
		var txt;
		var cardurl = "http://localhost:8080/flashcardapp/webservices/flashcardapp/deckcard/";
		$.each(decklistdata, function(i, item) {
			txt = txt+i;
			//txt = $("<div></div>").text(decklistdata[i].title);
			//cardurl = cardurl + decklistdata[i].deckid;
			//txt = $('<a>').attr('href', cardurl+decklistdata[i].deckid).text(decklistdata[i].title);
			//txt = $("<a></a>").text(decklistdata[i].title);
			txt = $('<a>', {
				text: decklistdata[i].title,
				title: 'decktitle',
				href: cardurl+decklistdata[i].deckid,
				click: function(e) {
					e.preventDefault();
					$.ajax({
	    				url: cardurl + decklistdata[i].deckid,
	    			}).then(function(cardlistdata) {
	    				$("#cardlistdiv").text("");
	    				var cardtxt;
	    				var qdiv;
	    				var ansdiv;
	    				var no;
	    				$.each(cardlistdata, function(j, card) {
	    					console.log(card.question);
	    					cardtxt = cardtxt + j;
	    					no = j+1;
	    					cardtxt = $("<span></span>").text("Question " + no + " ").addClass("qcolor");
	    					$("#cardlistdiv").append(cardtxt);
	    					qdiv = qdiv + j;
	    					qdiv = $("<span></span>").text(card.question);
	    					$("#cardlistdiv").append(qdiv);
	    					ansdiv = ansdiv + j;
	    					ansdiv = $("<p></p>").text(card.answer);
	    					$("#cardlistdiv").append(ansdiv);
	    				})
	    			});
					return false;
				}
				
			});
			
			txt.append('</a><br/>');
			$("#decklistdiv").append(txt);
			
		});
		
	})
})