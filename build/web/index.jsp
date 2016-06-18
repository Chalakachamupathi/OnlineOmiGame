

<!DOCTYPE HTML>
<html>
    <head>
        <style>
        div.position {
            background-color: yellow;
                width:80px;height:100px;padding:10px;border:1px solid #aaaaaa;
                display:inline-block;
        }
        </style>

        <script src="knockout-3.4.0.js"></script>
        <script src="jquery-1.12.3.min.js"></script>
       
    </head>
<body background="image.jpg">

<script>
     <%@ page session="false" %>




(function poll() {
    $.ajax({
        url: "OpenServlet",
        type: "GET",
        contentType: "application/json",
        success: function(data) {
            Update(JSON.stringify(data));
        },
        dataType: "json",
        complete: setTimeout(function() {poll();}, 5000),
        timeout: 2000
    });
})();

function PlayCard(card)
{
    $.ajax({
        
    type: 'get', 
    url: 'PlayCardsServlet',
    contentType: "application/json",
    data: { 
      name : JSON.stringify(card)
    },
    success: function(data) {

         Update(JSON.stringify(data));
    },
    error: function(data) {
      
        alert('fail');
        
    }
});
	
}
/******************************************************/

</script>


<h3 style="color:#ffffff"  >Network card game</h3>
<span  style="color:#ffffff" data-bind="text: message"></span> 

<!--cards-->

<div>   
<div style="margin-left: 100px;">
    
<div data-bind="visible: shouldShowPlayedCards">
       
            <div style="color:#ffffff ;margin-left: 700px;"> 
       
                 <span  style="color:#ffffff" >PLAYER1 :</span>
                 <span  style="color:#ffffff" data-bind="text: player1"></span><br/>
                 <span  style="color:#ffffff" >PLAYER2 :</span>
                 <span  style="color:#ffffff" data-bind="text: player2"></span><br/>
                 <span  style="color:#ffffff" >PLAYER3 :</span>
                 <span  style="color:#ffffff" data-bind="text: player3"></span><br/>
                 <span  style="color:#ffffff" >YOU____ :</span>
                 <span  style="color:#ffffff" data-bind="text: player0"></span>

             </div>
      
        
    
	<div class = "position" style = "margin-left: 110px;" >
	<img data-bind="attr: { src: card2 }" >
	</div>
    
        <div class = "position" style = "margin-left: 120px;" >
            <img data-bind="attr: { src: trump }" >
	</div>

	<br/>
      
	
	<div class = "position">
	<img data-bind="attr: { src: card1 }">
	</div>



	<div class = "position" style = "margin-left: 110px;">
	<img data-bind="attr: { src: card3 }">
	</div>

	<br/>

	<!-- Player's Card -->
	<div class = "position" style = "margin-left: 110px;">
	<img data-bind="attr: { src: mycard }">
	</div>
</div> 
    
<br/>
	<div data-bind="foreach: cards , visible: shouldShowHand">
		<img data-bind="attr: { src: image }, click: function(data, event) { PlayCard(image)}"/>
	</div>
<br/>

</div>
     
    
    </div>
<script>

function AppViewModel() {
    var self = this;
    self.cards = ko.observableArray([
        { image: 'cards/0_1.png' },
        { image: 'cards/1_2.png' },
        { image: 'cards/0_3.png' }
    ])
	self.card1 = ko.observable("cards/0_1.png");
	self.card2 = ko.observable("cards/0_1.png");
	self.card3 = ko.observable("cards/0_1.png");
	self.mycard = ko.observable("cards/0_1.png");
        self.trump = ko.observable("cards/0_1.png");
	self.shouldShowHand = ko.observable(false);
	self.shouldShowPlayedCards = ko.observable(false);	
	self.message = ko.observable("waiting for others to connect ...");
        self.player1 = ko.observable("0");
        self.player2 = ko.observable("0");
        self.player3 = ko.observable("0");
        self.player0 = ko.observable("0");
}

var viewModel = new AppViewModel();
ko.applyBindings(viewModel);

function Update(statusJSON)
{
	var parsed = JSON.parse(statusJSON);
	viewModel.cards(parsed.cards);
	viewModel.card1(parsed.card1);
	viewModel.card2(parsed.card2);
	viewModel.card3(parsed.card3);
	viewModel.mycard(parsed.mycard);
        viewModel.trump(parsed.trump);
	viewModel.shouldShowHand(parsed.showHand);
	viewModel.shouldShowPlayedCards(parsed.showCards);
	viewModel.message(parsed.message);
        viewModel.player0(parsed.player0);
        viewModel.player1(parsed.player1);
        viewModel.player2(parsed.player2);
        viewModel.player3(parsed.player3);
}

</script>

</body>
</html>
