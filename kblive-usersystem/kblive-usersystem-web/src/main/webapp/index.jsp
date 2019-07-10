<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML >
<html>
  	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>KB直播-主播认证</title>
		
		<link rel="shortcut icon" href="img/kblivelogo.png" type="image/x-icon" />
		<link rel="stylesheet" type="text/css" href="css/jquery.vidbacking.min.css">
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
		<link rel="stylesheet" href="css/live.css" type="text/css" />
		
		<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="js/jquery.vidbacking.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('body').vidbacking({
			'masked' : true
		});
		var videoBox=$("#video-box").get(0);
		//$("#video-box").volume+=1;
		$('#mute').click(function() {
			if (videoBox.muted) {
				videoBox.muted = false;
				$('#mute').get(0).src="img/unmute.png";
			} else {
				videoBox.muted = true;
				$('#mute').get(0).src="img/mute.png";
			}
		})
	});
</script>
</head>

	<body>
	             <!--
                	作者：2671242147@qq.com
                	时间：2019-01-14
                	描述：头部开始
                -->
	    <jsp:include page="top.jsp"></jsp:include>
				<!--
                	作者：2671242147@qq.com
                	时间：2019-01-14
                	描述：头部结束
                -->	    
		<video id="video-box" poster="img/background.jpg" autoplay muted loop class="vidbacking" >
			<source src="//s3.pstatp.com/aweme/resource/web/static/image/index/tvc-v2_30097df.mp4" type="video/mp4">
		           你的浏览器不支持该视频播放
		</video>	
		<div class="container-fluid">
			    <div style="margin-right: 50px; float:right;">
                	<img id='mute' src="img/mute.png" width='24px' alt="静音" style="margin-top: 10px;"/>
                </div>
                <div style="margin: 40px 0px 45px 0px;">
                	<h1 id="kb-title">认证看吧主播</h1>
                </div>
                
                <div class="row" align="center" style="height: 500px; overflow-y: auto;">
						<div class="col-md-4">
							<h1 id="kb-title-step">STEP1</h1>
							<img src="img/bindPhone.png" alt="绑定手机" style="margin-top: 10px;"/>
							<h1 id="kb-title-step-info" >绑定手机号</h1>
							<a class="btn btn-warning btn-lg" href="#" role="button">认证教程</a>
						</div>
						<div class="col-md-4">
							<h1 id="kb-title-step">STEP2</h1>
							<img src="img/realName.png" alt="实名认证" style="margin-top: 12px;"/>
							<h1 id="kb-title-step-info">实名认证</h1>
							<a class="btn btn-warning btn-lg" href="#" role="button" style="margin-top: 7px;">去认证</a>
						</div>
						<div class="col-md-4">
							<h1 id="kb-title-step">STEP3</h1>
							<img src="img/fillout.png" alt="填写直播间信息" style="margin-top: 16px;"/>
							<h1 id="kb-title-step-info">填写直播间信息</h1>
							<a class="btn btn-warning btn-lg" href="#" role="button" style="margin-top: 10px;">去开播</a>
						</div>
				</div>	
		</div>			
	</body>
</html>
