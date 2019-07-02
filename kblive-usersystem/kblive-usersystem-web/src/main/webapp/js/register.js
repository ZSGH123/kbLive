var times=null;
var codetimer=null; 

var body=null;
var phone=null;
var userName=null;
var pwd=null;
var repwd=null;
var code=null;
var getCodeBtn=null;
var registerBtn=null;

var one=null;
var two=null;
var three=null;
var four=null;
var five=null;
var six=null;
var seven=null;
var eight=null;
var nine=null;

function init(){
	body=document.getElementById("body");
	phone=document.getElementById("phone");
	userName=document.getElementById("userName");
	pwd=document.getElementById("pwd");
	repwd=document.getElementById("repwd");
	code=document.getElementById("code");
	getCodeBtn=document.getElementById("getcode");
	registerBtn=document.getElementById("register");
	
	one=document.getElementById("one");
    two=document.getElementById("two");
    three=document.getElementById("three");
    four=document.getElementById("four");
    five=document.getElementById("five");
    six=document.getElementById("six");
    seven=document.getElementById("seven");
    eight=document.getElementById("eight");
    nine=document.getElementById("nine");
    
	//注册获得焦点事件
	phone.onfocus=adjustInput;
	userName.onfocus=adjustInput;
	pwd.onfocus=adjustInput;
	repwd.onfocus=adjustInput;
	code.onfocus=adjustInput;
	//注册失去焦点事件
	phone.onblur=checkPhone;
	userName.onblur=checkUserName;
	pwd.onblur=checkPwd;
	repwd.onblur=checkRePwd;
	code.onblur=function(){this.style.borderColor="#D3D3D3";};
	
	registerBtn.onsubmit=function(){
		return register();
	};
	body.addEventListener("click",handleSendCode);
	getCodeBtn.disabled=true;
}

window.onload=init;

/**
 * 显示提示信息，并改变输入框风格
 * @param {Object} parent
 * @param {Object} str
 * @param {Object} inputp
 * @param {Object} tipColor
 * @param {Object} isAddImg
 * @param {Object} borderColor
 */
function showTip(parent,str,inputp,tipColor,isAddImg,borderColor){
	removeAllChild(parent);
	parent.style.color=tipColor;
	if(isAddImg){
	  var inode=document.createElement("img");
	  inode.src="img/红叉.png";
	  inode.align="center";
	  var tnode=document.createTextNode(" "+str);
	  parent.appendChild(inode);
	  parent.appendChild(tnode);
	}else{
	  var tnode=document.createTextNode(" "+str);
	  parent.appendChild(tnode);
	}
	inputp.style.borderColor=borderColor;	
}

/**
 * //alert(childnode.length);
 * //alert(childnode[0].nodeValue);
 * 删除所有儿子节点
 * @param {Object} parnet
 */
function removeAllChild(parnet){
	var childnode=parnet.childNodes;
	var len=childnode.length;
	for(var i=0;i<len;i++){	
		parnet.removeChild(childnode[0]);
	}
}

/**
 * 调整输入框的风格
 */
function adjustInput(){
	this.style.borderColor="dodgerblue";	
}

/**
 * 11位移动电话号码的第一位和第二位为"13“，”15”，”18”
 */
function checkPhone(){
	var value=phone.value;
	var regex=/^((13)|(15)|(18))\d{9}$/;
	if(value.length==0){
		showTip(two,"请输入您的手机号",phone,"crimson",true,"red");
		getCodeBtn.disabled=true;
		return false;
	}else{
	  if(regex.test(value)){
	  	  showTip(one,"√ 通过",phone,"mediumseagreen",false,"#D3D3D3");
	  	  removeAllChild(two);  
	  	  getCodeBtn.disabled=false;
		  return true;
	   }else{
	   	  showTip(two,"请输入正确格式手机号",phone,"crimson",true,"red");
	   	  getCodeBtn.disabled=true;
		  return false;
	   }
	}
}

/**
 * 验证用户名 ：中、英文均可，最长18个英文或9个汉字
 */
function checkUserName(){
	var value=userName.value;
	//var regex=/[\u4e00-\u9fa5]/;//汉字正则表达式
	var regex=/^.{6,18}$/;
	if(value.length==0){
		showTip(four,"请输入您的用户名",userName,"crimson",true,"red");
		return false;
	}else{
	  if(regex.test(value)){
	  	  showTip(three,"√ 通过",userName,"mediumseagreen",false,"#D3D3D3");
	  	  removeAllChild(four);
		  return true;
	   }else{
	   	  showTip(four,"请输入正确格式的用户名",userName,"crimson",true,"red");
		  return false;
	   }
	}
}

/**
 * 验证密码 ：6-20位要至少要包含一个大小写字母，及一个数字
 */
function checkPwd(){
	var value=pwd.value.trim();
	var regex=/^(?![0-9a-z]+$)(?![0-9A-Z]+$)(?![A-Za-z]+$)[A-Za-z0-9]{8,20}$/;
	if(value.length==0){
		showTip(six,"请输入您的密码",pwd,"crimson",true,"red");
		return false;
	}else{
	  if(regex.test(value)){
	  	  showTip(five,"√ 通过",pwd,"mediumseagreen",false,"#D3D3D3");
	  	  removeAllChild(six);
		  return true;
	   }else{
	   	  showTip(six,"请输入正确格式的密码",pwd,"crimson",true,"red");
		  return false;
	   }
	}
}

/**
 * 验证重复密码 ：6-20位要至少要包含一个大小写字母，及一个数字
 */
function checkRePwd(){
	var pwdvalue=pwd.value.trim();
	var value=repwd.value.trim();
	var regex=/^(?![0-9a-z]+$)(?![0-9A-Z]+$)(?![A-Za-z]+$)[A-Za-z0-9]{6,20}$/;
	if(value.length==0){
		showTip(eight,"请再次输入您的密码",repwd,"crimson",true,"red");
		return false;
	}else{
	  if(regex.test(value)){
	  	  if(pwdvalue==value){
	  	    showTip(seven,"√ 通过",repwd,"mediumseagreen",false,"#D3D3D3");
	  	    removeAllChild(eight);
		    return true;
		  }else{
		    showTip(eight,"两次输入的密码不一致",repwd,"crimson",true,"red");
		    return false;
		  }
	   }else{
	   	  showTip(eight,"请输入正确格式的重复密码",repwd,"crimson",true,"red");
		  return false;
	   }
	}
}

/**
 * 检查验证码 ：6位数字
 */
function checkCode(){
	var value=code.value;
	var regex=/^\d{6}$/;
	if(value.length==0){
		showTip(nine,"请输入您的验证码",code,"crimson",true,"red");
		return false;
	}else{
	  if(regex.test(value)){
	  	    showTip(ten,"√ 通过",code,"mediumseagreen",false,"#D3D3D3");
	  	    removeAllChild(nine);
		    return true;
	   }else{
	   	  showTip(nine,"请输入正确格式的验证码",code,"crimson",true,"red");
		  return false;
	   }
	}
}
/**
 * 注册
 */
function register(){
	if(checkPhone()&&checkUserName()&&checkPwd()&&checkRePwd()&&checkCode()){
		alert("通过");
		return true;
	}else{
		alert("不通过");
		return false;	
	}
}

function sendcode(){
 	alert(document.registerform.phone.value);
 	times=60;
 	getCode(document.registerform.phone.value);
 	getCodeBtn.value=times+"S后重新获取验证码";
 	getCodeBtn.disabled=true;
    codetimer=setInterval(changeTime,1000);
}

/**
 *刷新倒计时
 */
function changeTime(){
	times--;
	getCodeBtn.value=times+"S后重新获取验证码";
	if(times<=0){
		getCodeBtn.value="重新获取验证码";
		clearInterval(codetimer);
		getCodeBtn.disabled=false;
	}
}

function handleSendCode(e){
	if(e.target.name=="getcode"){
	if(!e.target.disabled){
	   sendcode();
	 }
	}
}

function getCode(phone){
	var xmlhttp=null;
	if(window.XMLHttpRequest) { // code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else { // code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.open("GET", "RegisterAction?phone="+phone, true);
	xmlhttp.send();
	//alert(xmlhttp.responseText);
}
//String.prototype.trim1=function(){
//	var re=/^\s*/;
//	var str=this.replace(re,"");
//	re=/\s*$/
//	return str.replace(re,"");
//}

//8388
//8388
//8388
//var str="  8388  ";
//str1=str.trim();
//alert(str);
//alert(str1);

//var pattern =/^((13)|(15)|(18))\d{9}$/g;
//
//alert( pattern.test("18873269672"));   // 返回 true
//
//alert(pattern.test("ECMAScript"));   // 返回 false