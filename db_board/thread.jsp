<!-- ���̃t�@�C����index����X���b�h��I��������̃y�[�W�B
�@�\�I�ɂ�
�E�X���b�h�̓��e�̕\���B
�E���X�̓��e�@�\
�E���X�̓��e�̕\��
�E���X���ォ��V������or�Â����ɕ\��
�E���X�̍폜�@�\
�E���X�̐��̃J�E���g
�ȂǂȂǁB�����ǉ����l����B
����Ƃ��Ă͂ڂ��肵�������
���X�𓊍e�����e��resservlt.java�ɑ���B�������Ă������e��resbeans.java�ɓ����B��resbeans.java�̏���
�f�[�^�x�[�X�ɓo�^����B�����̌�f�[�^�x�[�X�̃��X�Ɋւ��镔�������ׂĕ\������B
���Ċ����ɂȂ�Ƃ͎v���B
-->



<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>





<!DOCTYPE html>
<html>
<head>
	<style type="text/css">
        #tokolog,#createthrlog{
            display:none;
        }
    </style>
	<title>�X���b�h</title>
	<meta charset="Windows-31J">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/thread.js"></script>
    <link href="css/thread.css" rel="stylesheet" type="text/css"/>
    <!-- <script type="text/javascript" src="login.js"></script> -->
    
	
	 
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
	<div hanteiid="${toko}" class="hantei"></div>
	<div create="${createthr}" class="createthr"></div>
	<script type="text/javascript">
    	
	</script>
	<c:choose>
		<c:when test="${user==null}"><c:set var="valueName" value="����������" ></c:set></c:when>
		<c:otherwise><c:set var="valueName" value="${user.u_UserName}" ></c:set></c:otherwise>
	</c:choose>
	
	<!-- 
		<p>�X���b�h��:${threadname}</p>
		<p>�X���b�h�i���o�[:${thread_id}</p>
		<p></p>
		<form action="resservlet?thread_id=${thread_id}&username=${valueName}" method="post" charset="Windows-31J">
			���O:<c:out value="${valueName}"/><br>
			�R�����g:<textarea rows="15" cols="100" name="coment" maxlength="1000"></textarea>
			<input type="hidden" name="otamesi" value=<% Calendar cl=Calendar.getInstance(); SimpleDateFormat sdf=new SimpleDateFormat("yyyy�NMM��dd��HH��ss��"); out.println(sdf.format(cl.getTime())); %>>
			<input type="submit" value="���e!"><br>-->
			
	<!-- </form>
		<a href="firstservlet">�g�b�v�ɖ߂�</a>
		<c:forEach var="list" items="${resList}">
			<p>�R�����g:${list.res}</p>
			<p>���M��:${list.r_UserName}</p>
			<p>���M����:${list.resTime}</p>
			<p>�R�����g�i���o�[:${list.res_id}</p>
			<p>�X���b�h��:${threadname}</p>

		</c:forEach>
	-->
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
					<li><form action="result">
					<input type="serch" name="serch" value="" placeholder="�������[�h�����" style="border-radius:3px; border:1px solid #ccc"/>
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
	
	
	<main>
		
		<div class="main-container">
			<div class="maincol">
				<div class="contents">
					<p><!-- �X���b�h�� -->${threadname}<!-- �^�C�g�� --></p>
					<!-- �X���b�hID���Ƃ��悤�ɂ���B-->
					 <!-- �X���b�hid�͍s���Ă�-->
					<p>${titleSentence}<!-- ���������� --></p>
					<p>${threadTime}<!-- ���������t --></p>
					<p>�쐬��${threadusername}<!--���������O --></p>
					<p>No.${thread_id}<!--������id --></p>
				</div>
				<div class="toukou">
					<form action="resservlet" method="post" charset="Windows-31J" id="login_form">
						<input type="hidden" name="thread_id" value="${thread_id}">
						<input type="hidden" name="username" value="${valueName}">
						<input type="hidden" name="toko" value="toko">
						<textarea required placeholder="�D���Ȃ��Ə������I" cols="30" rows="5" name="coment" required></textarea>

	                    <p class="toukou_line"><button type="button" name="send">���e</button></p>
					</form>
				</div>
				<c:forEach var="list" items="${resList}">
					<div class="sentence">
						<p>No:${list.res_id}</p>
						<p>���[�U�[:${list.r_UserName}</p>
						<p>���e����${list.resTime}</p>
						<div class="ppp"><p>${list.res}</p></div>
						<p>�X���b�h��:${threadname}</p>
					
					</div>
				</c:forEach>
				
			</div>
			
			
		
		</div>
		
		
		
		<div id="bg">
            <div id="alertBox">
           
                <p class="kakunin">���e���Ă��ǂ��ł���</p>
                <button id="ok" type="button"> ���e</button>
                <button id="no" type="button">�߂�</button>
            </div>
    
        </div>
        
        
        
        <div id="tokolog" >
	        <div id="tokologbox">
	            <p class="kakunin2">���e���܂���!</p>
	        </div>
    	</div>
    	
    	<div id="createthrlog" >
	        <div id="createthrbox">
	            <p class="kakunin2">�X���b�h�𗧂Ă܂����B</p>
	        </div>
    	</div>
		
	
	</main>
	
	<a href="firstservlet" class="totop"><img src="toptop.png"></a>
	<p id="pagetop"><a href="#"><img src="totop.png"></a></p>
	
	
<script>
	 var $hantei=$("div[class='hantei']").attr("hanteiid");
	var $hantei2=$("div[class='createthr']").attr("create");
    if($hantei=="toko"){
    	console.log("����͂��܂������Ă���B");
    	$("#tokolog").fadeIn(50);
    	$("#tokolog").fadeOut(3000);
    }
    
    if($hantei2=="createthr"){
    	console.log("$hantei2�̔���͂��܂������Ă���B")
    	$("#createthrlog").fadeIn(50);
    	$("#createthrlog").fadeOut(3000);
    }else{
    	console.log("$hantei2�̔��肪���܂������Ă��Ȃ��B");
    }
</script>

</body>
</html>