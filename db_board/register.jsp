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
		名前<input type="text"  name="username" maxlength="20" placeholder="名前の入力" required><br>
		password<input type="password" name="password" maxlength="20" placeholder="パスワードの入力" pattern="^[0-9A-Za-z]+$" required><br>
		mailaddress<input type="text" name="mailaddress">
		<input type="submit" value="登録!"><br>
		
	</form> -->
	
	<!-- <a href="firstservlet">トップへ戻る</a> -->
	
	
	<div class="head">
			
			<div class="ue">
				<a class="rogo" href="firstservlet"><img src="k.png"></a>
				
				<div class="account">
					<c:choose>
						<c:when test="${user!=null}">
									 <a href="logout"><p>ログアウト</p></a></c:when>
						<c:otherwise><a href="login"><p>ログインする</p></a></c:otherwise>
					</c:choose>
					
					<a href="register"><p>新規登録する</p></a>
					
				</div>
			</div>
			
			<div class="sita">
				<ul>
					<li><form action="result">
					<input type="serch" name="serch" value="" placeholder="検索ワードを入力" style="border-radius:3px; border:1px solid #ccc"/>
					<input class="kirikae" type="submit" name="submit" value="検索"/>
					</form></li>
			
					<c:choose>
						<c:when test="${user!=null}"><li>${user.u_UserName}がログインしています</li></c:when>
						</c:choose>

					<c:if test="${user!=null}"><li><a href="create">スレッドを立てる</a></li></c:if>

					<c:if test="${user!=null}"><li><a href="editservlet?editname=${user.u_UserName}">スレッドを削除する</a></li></c:if>
				</ul>
			</div>
		</div>
	
	
	
	
	<div class="loginform">
        <form action="registerservlet" method="POST" id="login_form">
        	<input type="hidden" name="registerhantei" value="registerhantei">
            <p class="first">新規登録</p>
            <p class="login_line">
                <label>ユーザー名<br>
                    <input type="text" name="username" maxlength="20" placeholder="名前の入力" required></label>
            </p>
            <p class="login_line">
                <label>パスワード<br>
                    <input type="password" name="password" maxlength="20" placeholder="パスワードの入力" pattern="^[0-9A-Za-z]+$" required></label>
            </p>
            <p class="login_line"><button type="button" name="send">登録</button></p>
            
        </form>
    </div>
    
    <div id="bg">
        <div id="alertBox">
            <p class="kakunin">登録してもよろしいですか?</p>
            <button id="ok" type="button">登録</button>
            <button id="no" type="button">戻る</button>
        </div>
    </div>
	
	
	<a href="firstservlet" class="totop"><img src="toptop.png"></a>
	
	
</body>
</html>