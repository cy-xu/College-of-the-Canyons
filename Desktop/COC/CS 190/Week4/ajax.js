function getXMLHttpRequest() {
	try {
		try {
			return new ActiveXObject("Microsoft.XMLHTTP");
		}
		catch(e) {
			return new ActiveXObject("Msxml2.XMLHTTP");
		}
	}
	catch(e) {
		return new XMLHttpRequest();
	}
}
function callAjax() {
	var url = "clock.php";
	var myRandom = parseInt(Math.random()*99999999);
	myRequest.open("GET", url + "?rand=" + myRandom, true);
	myRequest.onreadystatechange = responseAjax; 
	myRequest.send(null);
}
function responseAjax() {
    if(myRequest.readyState == 4) {
        if(myRequest.status == 200) {
			var now = new Date();
			var localTime = now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds();
			var serverTime = myRequest.responseText;
			var serverDate = new Date();
			serverDate.setHours(myRequest.responseText.substring(0,2));
			serverDate.setMinutes(myRequest.responseText.substring(3,5));
			serverDate.setSeconds(myRequest.responseText.substring(6,8));
			//Check if local time is later than server time
			if (now > serverDate) {
				var differenceHours = now.getHours() - serverDate.getHours();
				var differenceMinutes = now.getMinutes() - serverDate.getMinutes();
				var differenceSeconds = now.getSeconds() - serverDate.getSeconds();
				if (differenceSeconds < 0) {
					differenceMinutes--;
					differenceSeconds += 60;
				}
				if (differenceMinutes < 0) {
					differenceHours--;
					differenceMinutes += 60;
				}
				if (differenceHours < 0) {
					throw new Error("Time difference is negative!");
				}
				if (differenceHours > 12) {
					differenceHours = (24 - now.getHours()) + serverDate.getHours();
				}
			}
			//Local time is not later than server time
			else {
				var differenceHours = serverDate.getHours() - now.getHours();
				var differenceMinutes = serverDate.getMinutes() - now.getMinutes();
				var differenceSeconds = serverDate.getSeconds() - now.getSeconds();
				if (differenceSeconds < 0) {
					differenceMinutes--;
					differenceSeconds += 60;
				}
				if (differenceMinutes < 0) {
					differenceHours--;
					differenceMinutes += 60;
				}
				if (differenceHours < 0) {
					throw new Error("Time difference is negative!");
				}
				if (differenceHours > 12) {
					differenceHours = (24 - serverDate.getHours()) + now.getHours();
				}
			}
			var differenceTime = differenceHours + ":" + differenceMinutes + ":" + differenceSeconds;
            document.getElementById("clock").innerHTML = "Server: " + serverTime + "<br />Local: " + localTime + "<br />Difference: " + differenceTime; 			
        } else {
            alert("An error has occurred: " + myRequest.statusText);
        }
    }
	setInterval(callAjax, 5000);
}
var myRequest = getXMLHttpRequest();
