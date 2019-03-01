<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html lang="ja"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
 <meta http-equiv="content-style-type" content="text/css">
 <title>掲示板名</title>
 <link rel="stylesheet" type="text/css" href="index.jsp">
</head>
<body>
<center><table width="800px" bgcolor="#000000" cellspacing="1" cellpadding="5"><tbody><tr><td bgcolor="#aaaaaa" align="center">ここは進級のための掲示板です。<br>
<br>
<b>【掲示板利用規約】</b>

</center>
 <div id="body" align="center">

    <form method='Post' action ='Threadservlet'> 
        <table>
        <tr><td>${ThreadRes.thread}</td></tr>
        <tr><td>${ThreadRes.res_con}</td></tr>
        </table>
        <input class="button" type="submit" value="投稿する">
    </form>


</div>
</body>
