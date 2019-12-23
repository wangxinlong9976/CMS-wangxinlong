
function getNewTime(){
	var currDate = new Date();
	var currTime = currDate.toLocaleString();
	$('#nowTime').html(currTime);
}
setInterval("getNewTime()",1000);
	



