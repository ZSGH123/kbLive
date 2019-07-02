<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>看吧登陆</title>
		<link href="css/login.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.6.0/css/font-awesome.min.css">
        <script type="text/javascript" src="js/login.js" ></script>
	</head>
	<body>
		<div id="box">
		      <!--
              	作者：2671242147@qq.com
              	时间：2018-12-14
              	描述：顶部
              -->
			  <div id="top">
			  	我是顶部
			  </div>
			  <!--
              	作者：2671242147@qq.com
              	时间：2018-12-14
              	描述：中间
              -->
			  <div id="center">
			  	<div id="centerbox">
			  		<br />
			  		<p class="myp">登陆账号</p>
			  		<div align="center">
			  			<form name="loginform" method="post" action="#">
			  				<table border="0" cellpadding="1" bordercolor="burlywood">
			  					<!--
                                  	作者：2671242147@qq.com
                                  	时间：2018-12-14
                                  	描述：账号
                                  -->
			  					<tr align="left"><td colspan="2">账号</td></tr>
			  					<tr>
			                       <td align="left" ><input id="phone" type="text" name="phone" placeholder="请填写你手机号码作为登录帐号"/></td>	
			                       <td align="left" width="52px" >
			                       	<span id="one" style="color: limegreen;"></span>
			                       </td>	
			                    </tr>
			  					<tr align="left"><td colspan="2">
			  						<span id="two" style="font-size: 13px;color: crimson;"></span>
			  					</td></tr>

			  					<tr align="left" height="25"><td colspan="2"></td></tr>
			  					
			  					<!--
                                  	作者：2671242147@qq.com
                                  	时间：2018-12-14
                                  	描述：密码
                                  -->			  					
			  					<tr align="left"><td colspan="2">密码</td></tr>
			  					<tr>
			                       <td align="left" ><input id="password" type="password" name="password" placeholder="请填写您的登陆密码"/></td>	
			                       <td align="left" width="52px" id="three">
			                       	<span id="three" style="color: limegreen;"></span>
			                       </td>	
			                    </tr>
			  					<tr align="left"><td colspan="2">
			  						<span id="four" style="font-size: 13px;color: crimson;"></span>
			  					</td></tr>	
			  					
			  					<tr align="left" height="25"><td colspan="2"></td></tr>
			  					
			  					<!--
                                  	作者：2671242147@qq.com
                                  	时间：2018-12-14
                                  	描述：记住密码
                                  -->			  					
			  					<tr align="left">
			  						<td colspan="2" >
			  						  <input id="remeberpassword" type="checkbox" name="remeberpassword"/><font size="2px">记住密码</font>
			  					    </td>
			  					</tr>
			  					
			  					<tr align="left" height="25"><td colspan="2"></td></tr>	
			  					
			  					<!--
                                  	作者：2671242147@qq.com
                                  	时间：2018-12-14
                                  	描述：登陆
                                  -->						  					
			  					<tr>
			                     <td align="center"  colspan="2">
			  	                   <input id="login" class="mybtn" type="button" name="submit" value="登陆" />
			                     </td>	
			                    </tr>

			  					<tr align="left" height="25"><td colspan="2"></td></tr>	
			  					
			  					<!--
                                  	作者：2671242147@qq.com
                                  	时间：2018-12-14
                                  	描述：找回密码
                                  -->				  					
			  					<tr>
			                     <td align="center"  colspan="2">
			  	                   <a href="#">找回密码</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;还没注册账号?&nbsp;&nbsp;&nbsp;
			  	                   <a href="#">立即注册</a>
			                     </td>	
			                    </tr>	
			                    
			  					<tr align="left" height="25"><td colspan="2"></td></tr>	
			  				
			  					
			  					<!--
                                  	作者：2671242147@qq.com
                                  	时间：2018-12-14
                                  	描述：三方登陆
                                  -->	
			  					<tr height="30px">
			                     <td align="center"  colspan="2">
			  	                   <a href="WeiBoAction" class="weibo"><i class="fa fa-weibo fa-2x" aria-hidden="true"></i></a>&nbsp;&nbsp;&nbsp;
			  	                   <a href="#" class="qq"><i class="fa fa-qq fa-2x" aria-hidden="true"></i></a>&nbsp;&nbsp;&nbsp;
			  	                   <a href="#" class="wenxin"><i class="fa fa-weixin fa-2x" aria-hidden="true"></i></a>&nbsp;&nbsp;&nbsp;
			                     </td>	
			                    </tr>                                  
			  					<tr>
			                     <td align="center"  colspan="2">
			  	                        <font size="1px">第三方登陆</font>
			                     </td>	
			                    </tr>	    
			  				</table>
			  			</form>
			  		</div>
			  	</div>
			  </div>             
              <!--
              	作者：2671242147@qq.com
              	时间：2018-12-14
              	描述：底部上
              -->
			  <div id="bottomtop">
			  	我是底部上  
			  </div>              
              
			  <!--
              	作者：2671242147@qq.com
              	时间：2018-12-14
              	描述：底部下
              -->              
			  <div id="bottom">
			  	我是底部下
			  </div>			  
		</div>
	</body>
</html>
