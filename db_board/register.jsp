<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	 <link href="css/login.css" rel="stylesheet" type="text/css"/>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
     <script type="text/javascript" src="js/register.js"></script>
</head>
<body>

	<c:forEach var="regi" items="${regierrors}">
	<p>${regi}</p>
	</c:forEach>
	
	<!-- <form action="registerservlet" method="post">
		���O<input type="text"  name="username" maxlength="20" placeholder="���O�̓���" required><br>
		password<input type="password" name="password" maxlength="20" placeholder="�p�X���[�h�̓���" pattern="^[0-9A-Za-z]+$" required><br>
		mailaddress<input type="text" name="mailaddress">
		<input type="submit" value="�o�^!"><br>
		
	</form> -->
	
	<!-- <a href="firstservlet">�g�b�v�֖߂�</a> -->
	
	
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
					<li><form action="result">
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
	
	
	
	
	<div class="loginform">
        <form action="registerservlet" method="POST" id="login_form">
        	<input type="hidden" name="registerhantei" value="registerhantei">
            <p class="first">�V�K�o�^</p>
            <p class="login_line">
                <label>���[�U�[��<br>
                    <input type="text" name="username" maxlength="20" placeholder="���O�̓���" required></label>
            </p>
            <p class="login_line">
                <label>�p�X���[�h<br>
                    <input type="password" name="password" maxlength="20" placeholder="�p�X���[�h�̓���" pattern="^[0-9A-Za-z]+$" required></label>
            </p>
            <p class="login_line"><button type="button" name="send">�o�^</button></p>
            
        </form>
    </div>
    
    <div id="bg">
        <div id="alertBox">
            <p class="kakunin">�o�^���Ă���낵���ł���?</p>
            <button id="ok" type="button">�o�^</button>
            <button id="no" type="button">�߂�</button>
        </div>
    </div>
	
	
	<a href="firstservlet" class="totop"><img src="toptop.png"></a>
	
	
</body>
</html>