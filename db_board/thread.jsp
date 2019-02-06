<!-- このファイルはindexからスレッドを選択した後のページ。
機能的には
・スレッドの内容の表示。
・レスの投稿機能
・レスの内容の表示
・レスを上から新しい順or古い順に表示
・レスの削除機能
・レスの数のカウント
などなど。随時追加も考える。
流れとしてはぼんやりした流れは
レスを投稿→内容はresservlt.javaに送る。→送られてきた内容をresbeans.javaに入れる。→resbeans.javaの情報を
データベースに登録する。→その後データベースのレスに関する部分をすべて表示する。
って感じになるとは思う。
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
	<title>スレッド</title>
	<meta charset="Windows-31J">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/thread.js"></script>
    <link href="css/thread.css" rel="stylesheet" type="text/css"/>
    <!-- <script type="text/javascript" src="login.js"></script> -->
    
	
	 
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
	<div hanteiid="${toko}" class="hantei"></div>
	<div create="${createthr}" class="createthr"></div>
	<script type="text/javascript">
    	
	</script>
	<c:choose>
		<c:when test="${user==null}"><c:set var="valueName" value="名無しさん" ></c:set></c:when>
		<c:otherwise><c:set var="valueName" value="${user.u_UserName}" ></c:set></c:otherwise>
	</c:choose>
	
	<!-- 
		<p>スレッド名:${threadname}</p>
		<p>スレッドナンバー:${thread_id}</p>
		<p></p>
		<form action="resservlet?thread_id=${thread_id}&username=${valueName}" method="post" charset="Windows-31J">
			名前:<c:out value="${valueName}"/><br>
			コメント:<textarea rows="15" cols="100" name="coment" maxlength="1000"></textarea>
			<input type="hidden" name="otamesi" value=<% Calendar cl=Calendar.getInstance(); SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日HH時ss分"); out.println(sdf.format(cl.getTime())); %>>
			<input type="submit" value="投稿!"><br>-->
			
	<!-- </form>
		<a href="firstservlet">トップに戻る</a>
		<c:forEach var="list" items="${resList}">
			<p>コメント:${list.res}</p>
			<p>発信者:${list.r_UserName}</p>
			<p>発信時間:${list.resTime}</p>
			<p>コメントナンバー:${list.res_id}</p>
			<p>スレッド名:${threadname}</p>

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
					<input type="serch" name="serch" value="" placeholder="検索ワードを入力" style="border-radius:3px; border:1px solid #ccc" required />
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
		<div class="head2">
			
			<div class="sita">
				<ul>
					<li><form action="result">
					<input type="serch" name="serch" value="" placeholder="検索ワードを入力" style="border-radius:3px; border:1px solid #ccc"/>
					<input class="kirikae" type="submit" name="submit" value="検索"/>
					</form></li>
					
					<c:choose>
						<c:when test="${user!=null}"><li><p>${user.u_UserName}がログインしています</p></li></c:when>
						</c:choose>

					<c:if test="${user!=null}"><li><p><a href="create">スレッドを立てる</a></p></li></c:if>

					<c:if test="${user!=null}"><li><p><a href="editservlet?editname=${user.u_UserName}">スレッドを編集する</a></p></li></c:if>
				</ul>
			</div>
		</div>
	
	
	<main>
		
		<div class="main-container">
			<div class="maincol">
				<div class="contents">
					<p><!-- スレッド名 -->${threadname}<!-- タイトル --></p>
					<!-- スレッドIDをとれるようにする。-->
					 <!-- スレッドidは行けてる-->
					<p>${titleSentence}<!-- ここが説明 --></p>
					<p>${threadTime}<!-- ここが日付 --></p>
					<p>作成者${threadusername}<!--ここが名前 --></p>
					<p>No.${thread_id}<!--ここがid --></p>
				</div>
				<div class="toukou">
					<form action="resservlet" method="post" charset="Windows-31J" id="login_form">
						<input type="hidden" name="thread_id" value="${thread_id}">
						<input type="hidden" name="username" value="${valueName}">
						<input type="hidden" name="toko" value="toko">
						<textarea required placeholder="好きなこと書こう！" cols="30" rows="5" name="coment" required></textarea>

	                    <p class="toukou_line"><button type="button" name="send">投稿</button></p>
					</form>
				</div>
				<c:forEach var="list" items="${resList}">
					<div class="sentence">
						<p>No:${list.res_id}</p>
						<p>ユーザー:${list.r_UserName}</p>
						<p>投稿時間${list.resTime}</p>
						<div class="ppp"><p>${list.res}</p></div>
						<p>スレッド名:${threadname}</p>
					
					</div>
				</c:forEach>
				
			</div>
			
			
		
		</div>
		
		
		
		<div id="bg">
            <div id="alertBox">
           
                <p class="kakunin">投稿しても良いですか</p>
                <button id="ok" type="button"> 投稿</button>
                <button id="no" type="button">戻る</button>
            </div>
    
        </div>
        
        
        
        <div id="tokolog" >
	        <div id="tokologbox">
	            <p class="kakunin2">投稿しました!</p>
	        </div>
    	</div>
    	
    	<div id="createthrlog" >
	        <div id="createthrbox">
	            <p class="kakunin2">スレッドを立てました。</p>
	        </div>
    	</div>
		
	
	</main>
	
	<a href="firstservlet" class="totop"><img src="toptop.png"></a>
	<p id="pagetop"><a href="#"><img src="totop.png"></a></p>
	
	
<script>
	 var $hantei=$("div[class='hantei']").attr("hanteiid");
	var $hantei2=$("div[class='createthr']").attr("create");
    if($hantei=="toko"){
    	console.log("判定はうまくいっている。");
    	$("#tokolog").fadeIn(50);
    	$("#tokolog").fadeOut(3000);
    }
    
    if($hantei2=="createthr"){
    	console.log("$hantei2の判定はうまくいっている。")
    	$("#createthrlog").fadeIn(50);
    	$("#createthrlog").fadeOut(3000);
    }else{
    	console.log("$hantei2の判定がうまくいっていない。");
    }
</script>

</body>
</html>