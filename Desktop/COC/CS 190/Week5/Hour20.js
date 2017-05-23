$(document).ready(function() {
	function ssEnable(mySheet) {
		var change = false;
		var oldSheet = 0;
		for (var i = 0; i < document.styleSheets.length; i++) {
			if(document.styleSheets[i].disabled == false) {
				oldSheet = i;
			}
			document.styleSheets[i].disabled = true;
			if(document.styleSheets[i].title == mySheet) {
				document.styleSheets[i].disabled = false;
				change = true;
			}
		}
		if(!change) document.styleSheets[oldSheet].disabled = false;
		return change;
	}
	$("#btn1").click(function() {
		var sheetName = prompt("Stylesheet Name?");
		if(!ssEnable(sheetName)) alert("Not found - original stylesheet retained.");
	});
});