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
    <div class="main">
        <div classs="main-contents">
            <p class="edit">検索結果</p>

            <c:forEach var="search" items="${result}">
	            <div class="contents">
	                <!--<p>${edit.threadName}</p>
	                <p>${edit.resCount}</p>
	                <p>${edit.createdDate}</p> -->
	                <!-- 	スレッドidを取り出してない-->
	                <p><!--threadiD:-->スレッドNo.${search.t_Thread_id}</p>
					<p><!--threadname:-->${search.threadName}</p>
					<p><!--threadname:-->${search.threadSentence}</p>
					<p><!--threadusername:-->${search.t_UserName}</p>
					<p><!--datecreated:-->作成日:${search.createdDate}</p>
                    <p><!--lastseen:-->最終更新日:${search.lastUpdate}</p>
					
                    <p><!--countingres:-->レスの数:${search.resCount}</p>
                   
	            </div>
	            <div class="space"></div>
                
            </c:forEach>
	     	
    	</div>
</div>
    
	<a href="firstservlet" class="totop"><img src="toptop.png"></a>
	<p id="pagetop"><a href="#"><img src="totop.png"></a></p>
	
</body>
</html>
