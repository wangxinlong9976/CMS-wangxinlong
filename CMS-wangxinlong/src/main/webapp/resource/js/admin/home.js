/**
 * 
 */

	var menus = $('#v-pills-tab .nav-link');
	var currUrl = menus.first().attr("url");
	$('#v-pills-tab .nav-link').click(function(){
		currUrl = $(this).attr("url");
		menus.removeClass("active");
		$(this).addClass("active");
		getHtml(currUrl);
	});
	
	//获取html
	function getHtml(url,params){
		if(url==""){
			url = currUrl;
		}
		$.get(url,params,function(html){
			$("#contentPointCut").html(html);
		},"html");
	}
	getHtml(currUrl);