
var loginbtn=null;
var phone=null;
var pwd=null;

var one=null;
var two=null;
var three=null;
var four=null;


function init(){
	phone=document.getElementById("phone");
	pwd=document.getElementById("password");
	loginbtn=document.getElementById("login");
	
	one=document.getElementById("one");
    two=document.getElementById("two");
    three=document.getElementById("three");
    four=document.getElementById("four");
	//注册获得焦点事件
	phone.onfocus=adjustInput;
	pwd.onfocus=adjustInput;
	//注册失去焦点事件
	phone.onblur=checkPhone;
	pwd.onblur=checkPwd;
	
	loginbtn.onsubmit=function(){
		return login();
	};
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
		return false;
	}else{
	  if(regex.test(value)){
	  	  showTip(one,"√ 通过",phone,"mediumseagreen",false,"#D3D3D3");
	  	  removeAllChild(two);
		  return true;
	   }else{
	   	  showTip(two,"请输入正确格式手机号",phone,"crimson",true,"red");
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
		showTip(two,"请输入您的用户名",userName,"crimson",true,"red");
		return false;
	}else{
	  if(regex.test(value)){
	  	  showTip(one,"√ 通过",userName,"mediumseagreen",false,"#D3D3D3");
		  return true;
	   }else{
	   	  showTip(two,"请输入正确格式的用户名",userName,"crimson",true,"red");
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
		showTip(four,"请输入您的密码",pwd,"crimson",true,"red");
		return false;
	}else{
	  if(regex.test(value)){
	  	  showTip(three,"√ 通过",pwd,"mediumseagreen",false,"#D3D3D3");
	  	  removeAllChild(four);
		  return true;
	   }else{
	   	  showTip(four,"请输入正确格式的密码",pwd,"crimson",true,"red");
		  return false;
	   }
	}
}

/**
 * 登陆
 */
function login(){
	if(checkPhone()&&checkPwd()){
		alert("通过");
		return true;
	}else{
		alert("不通过");
		return false;	
	}
}
