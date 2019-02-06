
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
<div class="deletethr" delete=${deletethr}>
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

					<c:if test="${user!=null}"><li><p><a href="editservlet?editname=${user.u_UserName}">スレッドを削除する</a></p></li></c:if>
				</ul>
			</div>
		</div>
		

<!-- <p><a href = "firstservlet">トップに戻る</a></p> -->

	<!-- <c:forEach var="edit" items="${EditList}">


			<p>スレッド名:${edit.threadName}</a></p>
			<p><a href = "editservlet?editTHREAD_ID=${edit.t_Thread_id}&action=delete">削除</a></p>
			<p><a href = "editservlet">編集</a></p>
			<p>-------------------------------------</p>

	</c:forEach> 
	-->
	<div class="main">
        <div classs="main-contents">
            <p class="edit">スレッドの削除</p>
            <c:forEach var="edit" items="${EditList}">
            
	            <div class="content">
	            	<a href="resservlet?thread_id=${edit.t_Thread_id}&threadname=${edit.threadName}&action=res">
		                <p>スレッド名:${edit.threadName}</p>
		                <p>レス数:${edit.resCount}</p>
						<p>作成日:${edit.createdDate}</p>
		            </a>
		                <button name="send" tid="${edit.t_Thread_id}">削除</button>
						
		                <!--スレッドidを取り出してない-->
		        	
	            </div>
				
				
	            <div class="space"></div>
	            
	     	</c:forEach>
	     	
    	</div>
    </div>
    
    <div id="bg">
        <div id="alertBox">
            <p class="kakunin">本当に削除してもよろしいですか？</p>
            <button id="ok">削除する</button>
            <button id="no">戻る</button>
        </div>
    </div>
    
    <div id="deletethrlog" >
	        <div id="deletethrbox">
	            <p class="kakunin2">削除しました。</p>
	        </div>
    </div>
    <script>
    	var $deletehantei=$("div[class='deletethr']").attr("delete");
    	if($deletehantei=="deletethr"){
    		console.log("判定はうまくいっている。");
	    	$("#deletethrlog").fadeIn(500);
	    	$("#deletethrlog").fadeOut(3000);
    	}
    </script>
	
	<a href="firstservlet" class="totop"><img src="toptop.png"></a>
	<p id="pagetop"><a href="#"><img src="totop.png"></a></p>

</body>
</html>



