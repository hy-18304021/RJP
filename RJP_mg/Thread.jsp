<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- saved from url=(0027)http://musouon.bbs.fc2.com/ -->
<html lang="ja"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
 <meta http-equiv="content-style-type" content="text/css">
 <title>掲示板名</title>
 <link rel="stylesheet" type="text/css" href="index.jsp">

</head>
<body>
<center><table width="800px" bgcolor="#000000" cellspacing="1" cellpadding="5"><tbody><tr><td bgcolor="#aaaaaa" align="center">ここは進級のための掲示板です。<br>
<br>
<b>【掲示板利用規約】</b>

<b></b><br>
<center></center>
<br>
<font color="#FF0000"><br>

<script type="text/javascript" src="./掲示板名_files/analyze.js.ダウンロード" charset="utf-8"></script>
</center></td>
<form var="Title" items="${title}" method="Post" action ='titlehyoji'> 
        ${Title.thread_Name}<br>
    </form>

<c:forEach var="res" items="${resindx}"> 
    <table>
      <tr class="td">
       <td>${res.res_Number}</td><td>${res.res_Cont_Time}</td>
       <td>${res.res_Con}</td>
      </tr>
      </c:forEach>
    </table>

	<from method='Post' action='Resservlet'>
    <table border="0">
     <tbody>
     <tr>
      <td colspan="2">
       <textarea name='Res' rows="7" cols="48"></textarea>
      </td>
     </tr>
     <tr>
      <td colspan="2" align="center">
		<input class="button" type='submit' value="投稿">
		<input class="button" type='reset' value="リセット">
     </tr>
	</td>
    </tbody></table>
  </form>
    </body>
    </html>
