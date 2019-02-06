<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<!-- <link rel="stylesheet"type="text/css"href="styl.css"> -->
	<title>ログイン</title>
    <link href="css/login.css" rel="stylesheet" type="text/css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/login.js"></script>
	
	
	<script>
		$(window).on('load scroll', function () {
		//現在のスクロールの位置を取る
			var sc = $(window).scrollTop();
			//ヘッダーのオブジェクト
			var fnav = $('.head');
			//var border = $('header').offset().top + $('header').outerHeight() - fnav.outerHeight();
			//scrollが xxx以上だったら active
			if(80 <= sc && $('body').hasClass('active')==false){
				//classを付ける
				$('body').addClass('active');
			}else if(80 > sc && $('body').hasClass('active')==true){
				$('body').removeClass('active');
			}
		});
	</script>
	
	
	
</head>
<body>
	<!-- 2月11日野澤-->
	<!--  <c:forEach var="error" items="${errors}">
		<p>${error}</p>
		</c:forEach>
	-->
	
	
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
					<li><form action="searchservlet">
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
		<form action="loginservlet" method="post" id="login_form">
		<input type="hidden" name="loginlog" value="loginlog">
			<p class="first">ログイン</p>
			<p class="login_line">
				<label>ユーザー名<br>
					<input type="text" name="username" maxlength="20" placeholder="ユーザー名" required>
				</label>
			</p>
			<p class="login_line">
				<label>パスワード<br>
					<input type="password" name="password" maxlength="20" placeholder="パスワード" pattern="^[0-9A-Za-z]+$" required>
				</label>
			</p>
			<p class="login_line">
				<button type="button" name="send">ログイン</button>
			</p>
			
			<!-- 名前<input type="text" name="username" maxlength="20" placeholder="名前の入力" required><br>
			password<input type="password" name="password" maxlength="20" placeholder="パスワードの入力" pattern="^[0-9A-Za-z]+$" required><br>
			<input type="submit" value="ログイン!"><br> -->
		
		</form>
	</div>
	<div id="bg">
		<div id="alertBox">
			<p class="kakunin">ログインしても良いですか？</p>
            <button id="ok" type="button"> ログインする</button>
            <button id="no" type="button">戻る</button>
		</div>
	</div>
	
	<a href="firstservlet" class="totop"><img src="toptop.png"></a>
	
</body>
</html>