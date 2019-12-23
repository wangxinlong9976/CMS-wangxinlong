/**
 * 
 */

	var menus = $('#v-pills-tab .nav-link');
	var currUrl = menus.first().attr("url");
//	console.log("当前url:"+currUrl);
	$('#v-pills-tab .nav-link').click(function(){
		currUrl = $(this).attr("url");
		menus.removeClass("active");
		$(this).addClass("active");
		getHtml(currUrl);
	});
	
	function getCookie(){
		var cookieArr = document.cookie.split("; ");
		var cookieObj = {};
		for(var index in cookieArr){
			var cArr = cookieArr[index].split("=");
			cookieObj[cArr[0]]=cArr[1];
		}
		return cookieObj;
	}
	
	//获取html
	function getHtml(url,params){
		if(url==""){
			url = currUrl;
		}
		
		
		var cookieObj = getCookie();
		document.cookie="currUrl="+url;
		document.cookie="aaa=aaa";
		
		
		if(cookieObj.currUrl!=""){
			currUrl = cookieObj.currUrl;
			
//			menus.removeClass("active");
//			$("[url="+currUrl+"]").addClass("active");
		}
		
		
//		console.log(document.cookie);
		alert(url);
		
		$.get(url,params,function(html){
			$("#contentPointCut").html(html);
		},"html");
	}

	getHtml(currUrl);