var timer1 = null;
var timer2 = null;
var el = null;
el2 = null;
var score = 0; // number of 'hits'
var shots = 0; // total 'shots'
var counter = 0;
var count = 0;
var diag = 0;
function moveIt() {
	// animate the image
	//left to right
	if(counter == 0){
		/*if(parseInt(el.style.left) > (screen.width - 50)) {
			el.style.left = 0;
			counter++
			alert("This1");
		}*/
		el.style.left = parseInt(el.style.left) + 6 + 'px';
		el.style.top = 100 + (80 * Math.sin(parseInt(el.style.left)/50)) + 'px';
		if(parseInt(el.style.left) > (screen.width - 50)) {
			counter++;
		}
		// set the timer			
		timer1 = setTimeout(moveIt, 25);
	}
	//right to left
	else if(counter == 1){
		el.style.left = parseInt(el.style.left) - 6 + 'px';
		el.style.top = 100 + (80 * Math.sin(parseInt(el.style.left)/50)) + 'px';
		if(parseInt(el.style.left) < (50)) {
			counter++;
		}
		// set the timer			
		timer1 = setTimeout(moveIt, 25);
	}
	//top to bottom
	else if(counter==2){
		el.style.top = parseInt(el.style.top) + 6 + 'px';
		el.style.left = 100 + (80 * Math.sin(parseInt(el.style.top)/50)) + 'px';
		if(parseInt(el.style.top) > (screen.height - 50)) {
			counter++;
		}
		// set the timer			
		timer1 = setTimeout(moveIt, 25);
	}
	//bottom to top
	else if(counter==3){
		el.style.top = parseInt(el.style.top) - 6 + 'px';
		el.style.left = 100 + (80 * Math.sin(parseInt(el.style.top)/50)) + 'px';
		if(parseInt(el.style.top) < (50)) {
			counter = 0;
		}
		// set the timer			
		timer1 = setTimeout(moveIt, 25);
	}
}

function moveRocket() {
	/*if (count==0) {
		el2.style.top = parseInt(el2.style.top) - 6 + 'px';//bottom to top
		el2.style.left = parseInt(el2.style.left) - 6 + 'px';//right to left
		if( (parseInt(el2.style.top) < 50) || (parseInt(el2.style.left) < 50)) {
			count++;
		}
		timer2 = setTimeout(moveRocket, 25);
	}
	else if (count==1) {
		el2.style.top = parseInt(el2.style.top) + 6 + 'px';//top to bottom
		el2.style.left = parseInt(el2.style.left) + 6 + 'px';//left to right
		if( (parseInt(el2.style.top) > (screen.height - 50)) || (parseInt(el2.style.left) > (screen.width - 50))) {
			count--;
		}
		timer2 = setTimeout(moveRocket, 25);
	}*/
	if(count == 0){
		el2.style.left = parseInt(el2.style.left) + 6 + 'px';
		el2.style.top = 100;
		if(parseInt(el2.style.left) > (screen.width - 50)) {
			count++;
		}
		// set the timer			
		timer2 = setTimeout(moveRocket, 25);
	}
	//right to left
	else if(count == 1){
		el2.style.left = parseInt(el2.style.left) - 6 + 'px';
		el2.style.top = 100;
		if(parseInt(el2.style.left) < (50)) {
			count++;
		}
		// set the timer			
		timer2 = setTimeout(moveRocket, 25);
	}
	//top to bottom
	else if(count==2){
		el2.style.top = parseInt(el2.style.top) + 6 + 'px';
		el2.style.left = 100;
		if(parseInt(el2.style.top) > (screen.height - 50)) {
			count++;
		}
		// set the timer			
		timer2 = setTimeout(moveRocket, 25);
	}
	//bottom to top
	else if(count==3){
		el2.style.top = parseInt(el2.style.top) - 6 + 'px';
		el2.style.left = 100;
		if(parseInt(el2.style.top) < (50)) {
			count = 0;
		}
		// set the timer			
		timer2 = setTimeout(moveRocket, 25);
	}
}
function scoreUp() {
	// increment the player's score
	score++;
}
function scoreboard() {
	// display the scorebaord
	document.getElementById("score").innerHTML = "Shots: " + shots + " Score: " + score;
}
window.onload = function() {
	el = document.getElementById("img1");
	el2 = document.getElementById("img2");
	// onClick handler calls scoreUp()
	// when the image is clicked
	el.onclick = scoreUp;
	el2.onclick = scoreUp;
	// update total number of shots
	// for every click within play field
	document.getElementById("range").onclick = function() { 
		shots++; 
		// update scoreboard
		scoreboard();
		}
	// initialize game
	scoreboard();
	el.style.left = '0px';
	el2.style.left= '0px';
	moveIt();
	moveRocket();
}
