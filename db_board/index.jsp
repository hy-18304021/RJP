<!--
��ԍŏ��ɖK�����
�@�\�I�ɂ�
�E�X���b�h�̕\��
�E�\������Ƃ��ɐl�C���A�V�����Ƀ\�[�g
-->

<%@ page contentType="text/html;charset=Windows-31J" pageEncoding="Windows-31J" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<style type="text/css">
        #loginlog,#logoutlog,#registerlog{
            display:none;
        }
     </style>
	<meta http-equiv="content-type" charset="Windows-31J">
	<link rel="stylesheet"type="text/css"href="css/index.css"/>
	<!-- <script type="text/javascript" src="js/index.js"></script> -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<script>
	function thread1(){
		$("#1_area").show();
		$("#2_area").hide();
		$('#thread1').addClass('active');
		$('#thread2').removeClass('active');
	}
	function thread2(){
		$("#2_area").show();
		$("#1_area").hide();
		$('#thread2').addClass('active');
		$('#thread1').removeClass('active');
	}
	</script>
	
	<script>
		$(window).on('load scroll', function () {
		//���݂̃X�N���[���̈ʒu�����
			var sc = $(window).scrollTop();
			//�w�b�_�[�̃I�u�W�F�N�g
			var fnav = $('.head');
			//var border = $('header').offset().top + $('header').outerHeight() - fnav.outerHeight();
			//scroll�� xxx�ȏゾ������ active
			if(80 <= sc && $('body').hasClass('active')==false){
				//class��t����
				$('body').addClass('active');
			}else if(80 > sc && $('body').hasClass('active')==true){
				$('body').removeClass('active');
			}
		});
	</script>
	
</head>
<body>
<div class="loginhantei" log="${loginlogg}"></div>
<div class="logouthantei" loglog="${logoutlogg}"></div>
<div class="registerhantei" logloglog=${registerhantei}></div>
	
	<div class="wrapper">
		<div class="head">
			
			<div class="ue">
				<a class="rogo" href="firstservlet"><img src="k.png"></a>
				
				<div class="account">
					<c:choose>
						<c:when test="${user!=null}">
									 <a href="logout"><p>���O�A�E�g</p></a></c:when>
						<c:otherwise><a href="login"><p>���O�C������</p></a></c:otherwise>
					</c:choose>
					
					<a href="register"><p>�V�K�o�^����</p></a>
					
				</div>
			</div>
			
			<div class="sita">
				<ul>
					<li><form action="searchservlet">
					<input type="serch" name="serch" value="" placeholder="�������[�h�����" style="border-radius:3px; border:1px solid #ccc" required />
					<input class="kirikae" type="submit" name="submit" value="����"/>
					</form></li>
			
					<c:choose>
						<c:when test="${user!=null}"><li>${user.u_UserName}�����O�C�����Ă��܂�</li></c:when>
						</c:choose>

					<c:if test="${user!=null}"><li><a href="create">�X���b�h�𗧂Ă�</a></li></c:if>

					<c:if test="${user!=null}"><li><a href="editservlet?editname=${user.u_UserName}">�X���b�h���폜����</a></li></c:if>
				</ul>
			</div>
		</div>
		<div class="head2">
			
			<div class="sita">
				<ul>
					<li><form action="searchservlet">
					<input type="serch" name="serch" value="" placeholder="�������[�h�����"  style="border-radius:3px; border:1px solid #ccc"/>
					<input class="kirikae" type="submit" name="submit" value="����"/>
					</form></li>
					
					<c:choose>
						<c:when test="${user!=null}"><li><p>${user.u_UserName}�����O�C�����Ă��܂�</p></li></c:when>
						</c:choose>

					<c:if test="${user!=null}"><li><p><a href="create">�X���b�h�𗧂Ă�</a></p></li></c:if>

					<c:if test="${user!=null}"><li><p><a href="editservlet?editname=${user.u_UserName}">�X���b�h��ҏW����</a></p></li></c:if>
				</ul>
			</div>
		</div>
		
		<p class="title">�X���b�h�ꗗ</p>
	
		<div class="thread">
			<button id="thread1" onclick="thread1()" class="kirikae active">�ꗗ</button>
			<button id="thread2" onclick="thread2()" class="kirikae">�l�C��</button>
			
			<ul id="1_area" class="thread1 on">
			<c:forEach var="thr" items="${thrList}">
				<li>
					<div class="enpitu">
					<a href="resservlet?thread_id=${thr.t_Thread_id}&threadname=${thr.threadName}&creator=${thr.t_UserName}&action=res">
						<div class="a">
						<p>No:${thr.t_Thread_id}</p>
						<p>�X���b�h��:${thr.threadName}</p>
						</div>
						
						<div class="b">
						<p>�쐬��:${thr.t_UserName}</p>
						<p>����:${thr.threadSentence}</p>
						</div>
						
						<div class="c">
						<p>�쐬��:${thr.createdDate}</p>
						<p>���X��:${thr.resCount}</p>
						<p>�ŏI�X�V��:${thr.lastUpdate}</p>
						</div>
					</a>
					</div>
					</li>
				
				</c:forEach>
				</ul>
			
			<ul id="2_area" class="thread2 off">
			<c:forEach var="pthr" items="${popList}">
				<li>
					<div class="enpitu">
					<a href="resservlet?thread_id=${pthr.t_Thread_id}&threadname=${pthr.threadName}&action=res">
						<div class="a">
							<p>No:${pthr.t_Thread_id}</p>
							<p>�X���b�h��:${pthr.threadName}</p>
							</div>
							
							<div class="b">
							<p>�쐬��:${pthr.t_UserName}</p>
							<p>����:${pthr.threadSentence}</p>
							</div>
							
							<div class="c">
							<p>�쐬��:${pthr.createdDate}</p>
							<p>���X��:${pthr.resCount}</p>
							<p>�ŏI�X�V��:${pthr.lastUpdate}</p>
							</div>
					</a>
					</div>
					</li>
				
				</c:forEach>
				
				</ul>
		</div>
				
			
	
		<!-- doGet���\�b�h�̓A�v���P�[�V�����T�[�o�[�Ȃǂɍ��E�����B
			tomcat��utf-8�ŃG���R�[�f�B���O����̂��f�t�H���g�����炻���
			server.xml�ŕς���BURIEncoding="Windows-31J"�Ƃ����tomcat�̃f�t�H���g��
			�G���R�[�f�B���O����Ƃ��̕����R�[�h��utf-8����windows-31j�ɂ��邱�Ƃ��ł���B
			�{���͂����ŃX���b�hid��get�ő����ăX���b�hid�Ō�����������悤�ɂ���ΊȒP����
			���m�B���̂܂܂��Ɠ����X���b�h���������炻�̃X���b�h���Ɋւ���R�����g�����������B
			�������������X���b�h���𗧂Ă�Ȃ��悤�ɂ����Ȃ��Ƃ����Ȃ��B
		-->
	</div>
	
	<div id="loginlog" >
	        <div id="loginlogbox">
	            <p class="kakunin2">���O�C�����܂����I</p>
	        </div>
    </div>
    <div id="logoutlog" >
	        <div id="logoutbox">
	            <p class="kakunin2">���O�A�E�g���܂����I</p>
	        </div>
    </div>
    <div id="registerlog" >
	        <div id="registerbox">
	            <p class="kakunin2">�V�K�o�^�ł��܂����I</p>
	        </div>
    </div>
<script>
		//���̃X�N���v�g�^�O�̒���ǉ������B
		var $hanteii=$("div[class='loginhantei']").attr("log");
	    if($hanteii=="loginlog"){
	    	console.log("����͂��܂������Ă���B");
	    	$("#loginlog").fadeIn(500);
	    	$("#loginlog").fadeOut(3000);
	    }
	    else{
	    	console.log("���肪�Ԉ���Ă���B");
	    	console.log($hanteii);
	    }
	    var $hanteii2=$("div[class='logouthantei']").attr("loglog");
	    if($hanteii2=="logoutlog"){
	    	console.log("����͂��܂������Ă���B");
	    	$("#logoutlog").fadeIn(500);
	    	$("#logoutlog").fadeOut(3000);
	    }
	    var $hanteii3=$("div[class='registerhantei']").attr("logloglog");
	    if($hanteii3=="registerhantei"){
	    	$("#registerlog").fadeIn(500);
	    	$("#registerlog").fadeOut(3000);
	    }
</script>

<p id="pagetop"><a href="#"><img src="totop.png"></a></p>


</body>
</html>