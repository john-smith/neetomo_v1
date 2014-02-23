function split() {
	for(i = 0;i < size;i++) {
		if(i < index || i >= index + range) {
			document.getElementById(i).style.display = "none";
		} else {
			if(navigator.userAgent.indexOf("MSIE") >= 0) {
				document.getElementById(i).style.display = "block";
			} else {
				document.getElementById(i).style.display = "table-row";
			}
		}
	}
	createPage();
}

function nextList() {
	index += range;
	split();
	checkIndex();
}

function prevList() {
	index -= range;
	split();
	checkIndex();
}

function lastList() {
	index = size - (size % range);
	if(index >= size) {
		index = size - range;
	}
	split();
	checkIndex();
}

function firstList() {
	index = 0;
	split();
	checkIndex();
}

function createPage() {
	noLink = (index / range) + 1;
	str = "";
	j = (size / range); 
	for(i = 0;i < j;i++) {
		if(i + 1 == noLink) {
			str += ' <span style="color:#999999">' + (i + 1) +  '</span> ';
		} else {
			str += ' <a href="javascript:changeIndex(' + (i * range) + ')">' + (i + 1) + '</a> ';
		}
	}
	document.getElementById("page").innerHTML = str;
}

function changeIndex(newIndex) {
	index = newIndex;
	checkIndex();
	split();
}

function checkIndex() {
	if(index <= 0) {
		document.getElementById("prev").innerHTML = " &lt; ";
		document.getElementById("prev").style.color = "#999999";
		document.getElementById("first").innerHTML = " &lt;&lt ";
		document.getElementById("first").style.color = "#999999";
	} else {
		document.getElementById("prev").innerHTML = ' <a href="javascript:prevList()">&lt;</a> ';
		document.getElementById("first").innerHTML = ' <a href="javascript:firstList()">&lt;&lt;</a> '; 
	}
	
	if(index + range >= size) {
		document.getElementById("next").innerHTML = " &gt; ";
		document.getElementById("next").style.color = "#999999";
		document.getElementById("last").innerHTML = " &gt;&gt ";
		document.getElementById("last").style.color = "#999999";
	} else {
		document.getElementById("next").innerHTML = ' <a href="javascript:nextList()">&gt;</a> ';
		document.getElementById("last").innerHTML = ' <a href="javascript:lastList()">&gt;&gt;</a> ';
	}
}


function changeRange(newRange) {
	range = newRange;
	index = 0;
	checkIndex();
	split();
}

function inputChange() {
	wakai1 = document.getElementById("input").value;
	wakai1 = parseInt(wakai1, 10);
	if(isNaN(wakai1) || wakai1 <= 0) {
		return;
	} else {
		changeRange(wakai1);
	}
}

function all() {
	for(i = 0;i < size;i++) {
		if(navigator.userAgent.indexOf("MSIE") >= 0) {
			document.getElementById(i).style.display = "block";
		} else {
			document.getElementById(i).style.display = "table-row";
		}		
	}
	document.getElementById("next").innerHTML = "";
	document.getElementById("prev").innerHTML = "";
	document.getElementById("first").innerHTML = "";
	document.getElementById("last").innerHTML = "";
	document.getElementById("page").innerHTML = "";
}

function init() {
	checkIndex();
	split();
}