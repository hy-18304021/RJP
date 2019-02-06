
<%@ page contentType="text/html;charset=Windows-31J" pageEncoding="Windows-31J" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<!DOCTYPE html>
<html>
<head><meta http-equiv="content-type" charset="Windows-31J">
	<style type="text/css">
        #deletethrlog{
            display:none;
        }
     </style>
	<link href="css/edit.css" rel="stylesheet" type="text/css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- <script type="text/javascript" src="edit.js"></script> -->
    <script type="text/javascript">
    	$(function(){
    		var tid;
			    $("#bg").hide();
			    $("button[name='send']").click(function(){
			    	tid = $(this).attr('tid');
			        $("#bg").fadeIn(1000);
			    });
			        
			    $("button[id='ok']").click(function(){
			       window.location.href="editservlet?editTHREAD_ID="+tid+"&action=delete&deletethr="+"deletethr";
			    });
			    $("button[id='no']").click(function(){
			        $("#bg").hide();
			    });
    	});
    		
			    
			    
			  
	
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
<div class="deletethr" delete=${deletethr}>
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
					<input type="serch" name="serch" value="" placeholder="�������[�h�����" style="border-radius:3px; border:1px solid #ccc"/>
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

					<c:if test="${user!=null}"><li><p><a href="editservlet?editname=${user.u_UserName}">�X���b�h���폜����</a></p></li></c:if>
				</ul>
			</div>
		</div>
		

<!-- <p><a href = "firstservlet">�g�b�v�ɖ߂�</a></p> -->

	<!-- <c:forEach var="edit" items="${EditList}">


			<p>�X���b�h��:${edit.threadName}</a></p>
			<p><a href = "editservlet?editTHREAD_ID=${edit.t_Thread_id}&action=delete">�폜</a></p>
			<p><a href = "editservlet">�ҏW</a></p>
			<p>-------------------------------------</p>

	</c:forEach> 
	-->
	<div class="main">
        <div classs="main-contents">
            <p class="edit">�X���b�h�̍폜</p>
            <c:forEach var="edit" items="${EditList}">
            
	            <div class="content">
	            	<a href="resservlet?thread_id=${edit.t_Thread_id}&threadname=${edit.threadName}&action=res">
		                <p>�X���b�h��:${edit.threadName}</p>
		                <p>���X��:${edit.resCount}</p>
						<p>�쐬��:${edit.createdDate}</p>
		            </a>
		                <button name="send" tid="${edit.t_Thread_id}">�폜</button>
						
		                <!--�X���b�hid�����o���ĂȂ�-->
		        	
	            </div>
				
				
	            <div class="space"></div>
	            
	     	</c:forEach>
	     	
    	</div>
    </div>
    
    <div id="bg">
        <div id="alertBox">
            <p class="kakunin">�{���ɍ폜���Ă���낵���ł����H</p>
            <button id="ok">�폜����</button>
            <button id="no">�߂�</button>
        </div>
    </div>
    
    <div id="deletethrlog" >
	        <div id="deletethrbox">
	            <p class="kakunin2">�폜���܂����B</p>
	        </div>
    </div>
    <script>
    	var $deletehantei=$("div[class='deletethr']").attr("delete");
    	if($deletehantei=="deletethr"){
    		console.log("����͂��܂������Ă���B");
	    	$("#deletethrlog").fadeIn(500);
	    	$("#deletethrlog").fadeOut(3000);
    	}
    </script>
	
	<a href="firstservlet" class="totop"><img src="toptop.png"></a>
	<p id="pagetop"><a href="#"><img src="totop.png"></a></p>

</body>
</html>



