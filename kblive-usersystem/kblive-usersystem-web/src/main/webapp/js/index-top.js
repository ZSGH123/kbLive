$(function(){
	$("#shouyetop").click(
		function(){
			location.href="index.jsp";
		}	
	);
	
	$("#zhibo").click(
			function(){
				location.href="liveIndexAction.do";
			}	
	);
	
	$("#fenlei").click(
			function(){
				location.href="liveIndexAction.do?command=toAllLiveTypeIndex";
			}	
	);
	
});


