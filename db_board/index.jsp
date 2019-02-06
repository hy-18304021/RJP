<!--
一番最初に訪れる画面
機能的には
・スレッドの表示
・表示するときに人気順、新着順にソート
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
					<li><form action="searchservlet">
					<input type="serch" name="serch" value="" placeholder="検索ワードを入力"  style="border-radius:3px; border:1px solid #ccc"/>
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
		
		<p class="title">スレッド一覧</p>
	
		<div class="thread">
			<button id="thread1" onclick="thread1()" class="kirikae active">一覧</button>
			<button id="thread2" onclick="thread2()" class="kirikae">人気順</button>
			
			<ul id="1_area" class="thread1 on">
			<c:forEach var="thr" items="${thrList}">
				<li>
					<div class="enpitu">
					<a href="resservlet?thread_id=${thr.t_Thread_id}&threadname=${thr.threadName}&creator=${thr.t_UserName}&action=res">
						<div class="a">
						<p>No:${thr.t_Thread_id}</p>
						<p>スレッド名:${thr.threadName}</p>
						</div>
						
						<div class="b">
						<p>作成者:${thr.t_UserName}</p>
						<p>説明:${thr.threadSentence}</p>
						</div>
						
						<div class="c">
						<p>作成日:${thr.createdDate}</p>
						<p>レス数:${thr.resCount}</p>
						<p>最終更新日:${thr.lastUpdate}</p>
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
							<p>スレッド名:${pthr.threadName}</p>
							</div>
							
							<div class="b">
							<p>作成者:${pthr.t_UserName}</p>
							<p>説明:${pthr.threadSentence}</p>
							</div>
							
							<div class="c">
							<p>作成日:${pthr.createdDate}</p>
							<p>レス数:${pthr.resCount}</p>
							<p>最終更新日:${pthr.lastUpdate}</p>
							</div>
					</a>
					</div>
					</li>
				
				</c:forEach>
				
				</ul>
		</div>
				
			
	
		<!-- doGetメソッドはアプリケーションサーバーなどに左右される。
			tomcatはutf-8でエンコーディングするのがデフォルトだからそれを
			server.xmlで変える。URIEncoding="Windows-31J"とすればtomcatのデフォルトの
			エンコーディングするときの文字コードがutf-8からwindows-31jにすることができる。
			本当はここでスレッドidをgetで送ってスレッドidで検索をかけるようにすれば簡単だし
			正確。今のままだと同じスレッド名だったらそのスレッド名に関するコメントが検索される。
			そもそも同じスレッド名を立てれないようにもしないといけない。
		-->
	</div>
	
	<div id="loginlog" >
	        <div id="loginlogbox">
	            <p class="kakunin2">ログインしました！</p>
	        </div>
    </div>
    <div id="logoutlog" >
	        <div id="logoutbox">
	            <p class="kakunin2">ログアウトしました！</p>
	        </div>
    </div>
    <div id="registerlog" >
	        <div id="registerbox">
	            <p class="kakunin2">新規登録できました！</p>
	        </div>
    </div>
<script>
		//このスクリプトタグの中を追加した。
		var $hanteii=$("div[class='loginhantei']").attr("log");
	    if($hanteii=="loginlog"){
	    	console.log("判定はうまくいっている。");
	    	$("#loginlog").fadeIn(500);
	    	$("#loginlog").fadeOut(3000);
	    }
	    else{
	    	console.log("判定が間違っている。");
	    	console.log($hanteii);
	    }
	    var $hanteii2=$("div[class='logouthantei']").attr("loglog");
	    if($hanteii2=="logoutlog"){
	    	console.log("判定はうまくいっている。");
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