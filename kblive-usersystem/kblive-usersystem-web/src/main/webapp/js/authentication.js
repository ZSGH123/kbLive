/**
 * 作者：2671242147@qq.com
 * 时间：2019-01-06
 * 主播审核资料上传
 */
$(
				function() {
					$("#idcardfile_upload").uploadify({
						'debug': true,
						//'buttonClass': 'btn btn-success btn-sm', //按钮的css
						'buttonCursor': 'hand',
						'buttonText': '请选择图片文件',
						'height': 30,
						'width': 120,
						'swf': "misc/uploadify.swf",
						'uploader': 'misc/uploadify.php',
						'cancelImg': '/img/YYLive-max.png',
						'folder': 'UploadFile', //上传到哪个文件夹
						'queueID': 'fileQueue',
						'auto': false,
						'multi': true,
						'fileTypeDesc': '请选择*.jpg;*.jpge;*.gif;*.png文件',
						'fileTypeExts': '*.jpg;*.jpge;*.gif;*.png',
						'fileSizeLimit': '3MB',
						'queueSizeLimit': 5,
						//'onInit':function(){alert("1");},
						'onDialogClose': function(queueData) {
							alert(queueData.filesQueued + ' 文件队列 ' +
								queueData.filesSelected + ' 文件已选择. 总共有 ' +
								queueData.queueLength + ' 文件在这个队列中');
						},
						//'onDialogOpen' : function() {
						//            alert("打开对话框");
						//       },
						'onFallback': function() {
							alert("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试。");
						},
						'onSelectError': function(file, errorCode, errorMsg) {
							switch(errorCode) {
								case -100:
									alert("上传的文件数量已经超出系统限制的" + $('#idcardfile_upload').uploadify('settings', 'queueSizeLimit') + "个文件！");
									break;
								case -110:
									alert("文件 [" + file.name + "] 大小超出系统限制的" + $('#idcardfile_upload').uploadify('settings', 'fileSizeLimit') + "大小！");
									break;
								case -120:
									alert("文件 [" + file.name + "] 大小异常！");
									break;
								case -130:
									alert("文件 [" + file.name + "] 类型不正确！");
									break;
							}
						},
						'onSelect': function(file) {
							alert(
								"文件名：" + file.name + "\r\n" +
								"文件大小：" + file.size + "\r\n" +
								"创建时间：" + file.creationDate + "\r\n" +
								"最后修改时间：" + file.modificationDate + "\r\n" +
								"文件类型：" + file.type);
						}
					});

					$("#upload").click(
						function() {
							alert("上传");
							alert(document.getElementById("upload").form.id);
							$("#idcardfile_upload").uploadify('upload', '*');
						});
					$($("#progressid").get(0).contentWindow.document.body).css({
						'padding': '0',
						'margin': '0'
					});
					$($("#progressid").get(0).contentWindow.document.body).text("fsdfsf");
					//$(window.frames["progressid"].document).find('body').css({'padding':'0','margin':'0'});
					//					$("#upload").click(
					//						function() {
					//							//$("sureform").submit();
					//							//主动提交表单不会触发表单的onsubmit事件
					//							document.getElementById("sureform").submit();
					//						}
					//					);
					//					document.sureform.onsubmit=function(){
					//		                    alert("通过");
					//		                    return true;
					//	                };

				}
			);