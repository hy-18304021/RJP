<!--
�X���b�h�𗧂Ă邽�߂̃y�[�W�B
�@�\�I�ɂ�
�E�X���b�h�𗧂Ă邽�߂̏�����͂��đ��M�����邾���B
�E����̕����ȊO�͓��ꂳ���Ȃ��B��@�����������ꂳ����΂����Ƃ���ɕ�����Ƃ�����ꂳ���Ȃ��݂����ȁB
�E������͂��đ��M�{�^�����������Ƃ��ɖ����͕���������Ȃ�_�C�A���O�{�b�N�X���ԕ����Ȃǂ�\��������
���͂�����B
�E��񂪗ǂ����thread.jsp�ɔ�΂��B�������̓T�[�u���b�g�̎d���B���̔��f��threadLogic�N���X��ʂ��B
����Ƃ��ẮA
���͏����L����creatboardservlet.java�ɑ��M�B�����M���ꂽ�f�[�^��new����threadbeans.java�ɒl���i�[
������new����threadbeans.java��new����threadLogic.java�ɓ����B�������𖞂����Ă���̂ł���΂��̂܂�
�f�[�^�x�[�X�ɓo�^�B�������Ă��Ȃ���΍ē��͂�����B
-->


<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <title>�f���쐬</title>
	<link href="css/createboard.css" rel="stylesheet" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/createboard.js"></script>
	
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
	
	<c:choose>
		<c:when test="${user==null}"><c:set var="valueName" value="����������" ></c:set></c:when>
		<c:otherwise><c:set var="valueName" value="${user.u_UserName}" ></c:set></c:otherwise>
	</c:choose>
	<!-- ${user.u_UserName}-->
	
<!--
	<form action="threadservlet?creator=${valueName}" method="post">
		�薼:<input type="text" name="title" maxlength="50" placeholder="�^�C�g��"   required><br>
		����:<input type="text" name="titleSentence" maxlength="1000" required><br>
		���O:<c:out value="${valueName}"/><br>  �Z�b�V�����ɒl�������Ă����炻�̖��O�������łȂ���΁u����������v���f�t�H���g�œ����B
		<input type="submit" value="�X���b�h�𗧂Ă�I"><br>
	</form>
-->
<!--	<a href="firstservlet">�g�b�v�ɖ߂�</a>-->


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
		






    <div class="tema">
        <p>�f�����쐬����</p>
    </div>
    <div class="main">
        <div class="form">
            <div class="formcontent">
                <form action="threadservlet?creator=${user.u_UserName}" method="post">
                	<input type=hidden name="createthr" value="createthr">
                    <input type="text" name="title" maxlength="50" placeholder="�^�C�g��" required>
                    <textarea rows="10" cols="30"  placeholder="������" name="titleSentence"  maxlength="1000" required></textarea>
                    <p>�쐬��:${user.u_UserName}</p>
                </form>
                
            </div>
        </div>
        
    </div>
    <button type="button" name="send"><p>�m�F����</p></button>
    
    <div id="bg">
        <div id="alertBox">
            <p class="kakunin">�f�����쐬���Ă���낵���ł���?</p>
            <button id="ok" type="button">�쐬</button>
            <button id="no" type="button">�߂�</button>
        </div>
    </div>
    
    
    <a href="firstservlet" class="totop"><img src="toptop.png"></a>
    
    


</body>
</html>