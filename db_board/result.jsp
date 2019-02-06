<%@ page contentType="text/html;charset=Windows-31J" pageEncoding="Windows-31J" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet"type="text/css"href="css/result.css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	
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
    <div class="main">
        <div classs="main-contents">
            <p class="edit">��������</p>

            <c:forEach var="search" items="${result}">
	            <div class="contents">
	                <!--<p>${edit.threadName}</p>
	                <p>${edit.resCount}</p>
	                <p>${edit.createdDate}</p> -->
	                <!-- 	�X���b�hid�����o���ĂȂ�-->
	                <p><!--threadiD:-->�X���b�hNo.${search.t_Thread_id}</p>
					<p><!--threadname:-->${search.threadName}</p>
					<p><!--threadname:-->${search.threadSentence}</p>
					<p><!--threadusername:-->${search.t_UserName}</p>
					<p><!--datecreated:-->�쐬��:${search.createdDate}</p>
                    <p><!--lastseen:-->�ŏI�X�V��:${search.lastUpdate}</p>
					
                    <p><!--countingres:-->���X�̐�:${search.resCount}</p>
                   
	            </div>
	            <div class="space"></div>
                
            </c:forEach>
	     	
    	</div>
</div>
    
	<a href="firstservlet" class="totop"><img src="toptop.png"></a>
	<p id="pagetop"><a href="#"><img src="totop.png"></a></p>
	
</body>
</html>
