<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>看吧直播-技术驱动娱乐-弹幕式互动直播平台</title>

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="css/kBLiveIndex.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />

<!-- 外界引入时记得引入js/jquery-3.3.1.min.js -->
<script type="text/javascript" src="js/index-top.js"></script>

</head>
<body>
	<div class="container" style="height:70px;">
		<nav class="navbar navbar-default navbar-fixed-top" style="height:70px;">
			<div class="container" id="container">
				<div class="row">
					<div class="col-md-2" id="logo">
						<a href="indexAction.do"><img src="img/birdlogo.png"
							height="40px"></a>
					</div>
					<div class="col-md-3" id="list">
						<div class="row" id="xialaList">

							<div class="col-md-3">
								<ul id="menu">
									<li id="but"><input type="button" name="shouye"
										id="shouyetop" value="首页"></li>
								</ul>
							</div>
							<div class="col-md-3">
								<ul id="menu">
									<li id="but"><input type="button" name="shouye" id="zhibo"
										value="直播" /></li>
								</ul>
							</div>
							<div class="col-md-3">
								<ul id="menu">
									<li id="but"><input type="button" name="shouye"
										id="fenlei" value="分类" />
									<div class="dropdown_3columns">
											<!-- Begin 2 columns container -->

											<div class="col_3">
												<h2>热门分类</h2>
											</div>
											<div class="col_1">
												<ul class="greybox">
													<c:forEach items="${liveContents0}" var="item" begin='0'
														end='3'>
														<li><a
															href="LiveContentAction.do?liveContentId=${item.liveContentId}">${item.liveContentName}</a></li>
													</c:forEach>
												</ul>
											</div>
											<div class="col_1">
												<ul class="greybox">
													<c:forEach items="${liveContents1}" var="item" begin='0'
														end='3'>
														<li><a
															href="LiveContentAction.do?liveContentId=${item.liveContentId}">${item.liveContentName}</a></li>
													</c:forEach>
												</ul>
											</div>
											<div class="col_1">
												<ul class="greybox">
													<c:forEach items="${liveContents2}" var="item" begin='0'
														end='2'>
														<li><a
															href="LiveContentAction.do?liveContentId=${item.liveContentId}">${item.liveContentName}</a></li>
													</c:forEach>
													<li><a
														href="liveIndexAction.do?command=toAllLiveTypeIndex">更多>></a></li>
												</ul>
											</div>


										</div></li>
								</ul>
							</div>
							<div class="col-md-3">
								<ul id="menu">
									<li id="but"><input type="button" name="shouye"
										id="shouye" value="视频" />
										<div class="dropdown_3columns">
											<!-- Begin 2 columns container -->

											<div class="col_3">
												<h2>热门视频</h2>
											</div>
											<div class="col_1">

												<ul class="greybox">
													<li><a href="#">pdd回归</a></li>
													<li><a href="#">绝地求生</a></li>
													<li><a href="#">地下城</a></li>

												</ul>

											</div>

											<div class="col_1">

												<ul class="greybox">
													<li><a href="#">王者荣耀</a></li>
													<li><a href="#">饥荒</a></li>
													<li><a href="#">刺激战场</a></li>

												</ul>

											</div>

											<div class="col_1">

												<ul class="greybox">
													<li><a href="#">星秀</a></li>
													<li><a href="#">一起看</a></li>

													<li><a href="#">更多>></a></li>
												</ul>

											</div>
										</div></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-md-3" style="margin-left: 10px; ">

						<div class="input-group" style="width: 200px;">
							<form id="findform" method="post" class="form-horizontal"
								action="indexAction.do?command=toSearch">
								<div class="form-group">
									<div class="input-group">
										<input type="text" class="form-control" placeholder="房间号/姓名/直播内容"
											style="width:100px height=40px; border-bottom-left-radius: 20px; border-top-left-radius: 20px;"
											name="content"> <span class="input-group-btn">
											<button class="btn btn-default" type="submit" style="height: 34px;">
												<i class="fa fa-search" aria-hidden="true"></i>
											</button>
										</span>
									</div>
								</div>
							</form>
						</div>
						<!-- /input-group -->
					</div>
					<div class="col-md-1"></div>
					<div class="col-md-3" id="logn">
						<a href="${empty loginUser ?  'login.jsp' : 'userAction.do?command=toAnchorCenter'}">
						   <img src='img/attentionuser.png' style="border-radius:50% ;" width='20px'>关注
						</a>&nbsp;&nbsp;&nbsp;					     
						<a href="${empty loginUser ?  'login.jsp' : 'userAction.do?command=toAnchorCenter'}">
						   <i class="fa fa-video-camera" aria-hidden="true" style="color: #999999;"></i>开播
						</a>&nbsp;&nbsp;&nbsp;
						<a href='${empty loginUser ?  "login.jsp" : "userAction.do?command=persional"}'>
						    <c:choose>
							<c:when test="${empty loginUser}">
							      <i class="fa fa-user-o" aria-hidden="true"></i>登录
							</c:when>
							<c:otherwise>
							    <img src='${empty loginUser.userIcon ? "img/defaultusericon.png":loginUser.userIcon}' style="border-radius:50% ;" width='20px'>
							     ${empty loginUser ? "登录":loginUser.userName}
							</c:otherwise>
							</c:choose>
					    </a>
					    
						<a href="${empty loginUser ?  'userAction.do?command=toRegister' : 'login.jsp'}">
						    &nbsp;&nbsp;|&nbsp;&nbsp;${empty loginUser ? "注册":'退出'}
						</a>
					</div>
				</div>
			</div>
		</nav>
	</div>
</body>
</html>
