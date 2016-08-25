 $(document).ready(function(){
  var updateurl;
    $("#decklist").click(function(e) {
    	e.preventDefault();
    	console.log("click");
    	var link = $(this).attr('href');
    	console.log(link);
    	var link2 = link.slice(-1); 
    	//console.log( " inue " + link2);
    	var inurl = "http://localhost:8080/flashcardapp/webservices/flashcardapp/usersdecks/" + link2;
    	console.log( " inurl " + inurl);
    	$.ajax({
    		url: inurl,
    	}).then(function(decklistdata) {
    		var txt;
    		var spand;
    		var cardurl = "http://localhost:8080/flashcardapp/webservices/flashcardapp/deckcard/";
    		$.each(decklistdata, function(i, item) {
    			txt = txt+i;
    			
    			//updaeturl = updatedeck.html; //+ decklistdata[i].deckid;
    			//txt = $('<a>').attr('href', cardurl+decklistdata[i].deckid).text(decklistdata[i].title);
    			//txt = $("<a></a>").text(decklistdata[i].title);
    			txt = $('<a></a>', {
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
    			
    			//txt.append('</a>');
    			/*spand = spand +i;
    			spand = $("<span></span>").text("    UPDATE");
    			txt.append(spand);*/
    			txt.append('<br/>');
    			
    			$("#decklistdiv").append(txt);
    			
    		});
    		
    	})
    })
    
});