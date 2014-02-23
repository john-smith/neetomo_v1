function chat() {
	var wakaiVal = document.getElementById("wakai").value;
	
	if(wakaiVal == "") {
		return;
	}

	wakaiVal = wakaiVal.split("&").join("&amp;");
	wakaiVal = wakaiVal.split("<").join("&lt;");
	wakaiVal = wakaiVal.split(">").join("&gt;");
	wakaiVal = wakaiVal.split("\"").join("&quot;");
	wakaiVal = wakaiVal.split("\n").join("<br />");	
	
	document.getElementById("load").innerHTML = '<img src="view/img/load2.gif" />';
	document.getElementById("wakai2").disabled = true;
	Hoge.talk(wakaiVal, func);
	
}

function func(hogeBean) {
	document.getElementById("load").innerHTML = "";
	
	document.getElementById("cpu").innerHTML = hogeBean.wakai;
	
	var wakaiVal = document.getElementById("wakai").value;
	wakaiVal = wakaiVal.split("&").join("&amp;");
	wakaiVal = wakaiVal.split("<").join("&lt;");
	wakaiVal = wakaiVal.split(">").join("&gt;");
	wakaiVal = wakaiVal.split("\"").join("&quot;");
	wakaiVal = wakaiVal.split("\n").join("<br />");
	document.getElementById("you").innerHTML = wakaiVal;
	document.getElementById("wakai").value = "";
	
	document.getElementById("wakai2").disabled = false;
}
