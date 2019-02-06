<!--
スレッドを立てるためのページ。
機能的には
・スレッドを立てるための情報を入力して送信させるだけ。
・既定の文字以外は入れさせない。例　数字だけ入れさせればいいところに文字列とかを入れさせないみたいな。
・情報を入力して送信ボタンを押したときに未入力部分があるならダイアログボックスやら赤文字などを表示させて
入力させる。
・情報が良ければthread.jspに飛ばす。←ここはサーブレットの仕事。情報の判断はthreadLogicクラスを通す。
流れとしては、
入力情報を記入→creatboardservlet.javaに送信。→送信されたデータをnewしたthreadbeans.javaに値を格納
→そのnewしたthreadbeans.javaをnewしたthreadLogic.javaに入れる。→条件を満たしているのであればそのまま
データベースに登録。満たしていなければ再入力させる。
-->


<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <title>掲示板作成</title>
	<link href="css/createboard.css" rel="stylesheet" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/createboard.js"></script>
	
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
	
	<c:choose>
		<c:when test="${user==null}"><c:set var="valueName" value="名無しさん" ></c:set></c:when>
		<c:otherwise><c:set var="valueName" value="${user.u_UserName}" ></c:set></c:otherwise>
	</c:choose>
	<!-- ${user.u_UserName}-->
	
<!--
	<form action="threadservlet?creator=${valueName}" method="post">
		題名:<input type="text" name="title" maxlength="50" placeholder="タイトル"   required><br>
		説明:<input type="text" name="titleSentence" maxlength="1000" required><br>
		名前:<c:out value="${valueName}"/><br>  セッションに値が入っていたらその名前をそうでなければ「名無しさん」をデフォルトで入れる。
		<input type="submit" value="スレッドを立てる！"><br>
	</form>
-->
<!--	<a href="firstservlet">トップに戻る</a>-->


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
		






    <div class="tema">
        <p>掲示板を作成する</p>
    </div>
    <div class="main">
        <div class="form">
            <div class="formcontent">
                <form action="threadservlet?creator=${user.u_UserName}" method="post">
                	<input type=hidden name="createthr" value="createthr">
                    <input type="text" name="title" maxlength="50" placeholder="タイトル" required>
                    <textarea rows="10" cols="30"  placeholder="説明文" name="titleSentence"  maxlength="1000" required></textarea>
                    <p>作成者:${user.u_UserName}</p>
                </form>
                
            </div>
        </div>
        
    </div>
    <button type="button" name="send"><p>確認する</p></button>
    
    <div id="bg">
        <div id="alertBox">
            <p class="kakunin">掲示板を作成してもよろしいですか?</p>
            <button id="ok" type="button">作成</button>
            <button id="no" type="button">戻る</button>
        </div>
    </div>
    
    
    <a href="firstservlet" class="totop"><img src="toptop.png"></a>
    
    


</body>
</html>