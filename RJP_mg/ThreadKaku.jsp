<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core ƒ^ƒOƒ‰ƒCƒuƒ‰ƒŠ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html lang="ja"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
 <meta http-equiv="content-style-type" content="text/css">
 <title>Œf¦”Â–¼</title>
 <link rel="stylesheet" href="./Œf¦”Â–¼_files/jlisting.css" type="text/css">
 <link rel="stylesheet" href="./Œf¦”Â–¼_files/745617.css" type="text/css">
 
 <style type="text/css">
 <!--
 body {
	margin: 0;
	padding: 0;

 #change_mobile {
	position: relative;
	z-index: 1001;
	top: 0px;
	left: 0px;
	width: 100%;
	height: 90px;
	background-color: rgb(160, 180, 198);
	border-top: 1px solid rgb(205, 213, 223);
	border-bottom: 1px solid rgb(46, 55, 68);
 }
 #change_mobile_body {
	text-align: center;
	position: absolute;
	width: 100%;
	padding-top: 7px;
 }-->
 </style>

</head>
<body>
<center><table width="800px" bgcolor="#000000" cellspacing="1" cellpadding="5"><tbody><tr><td bgcolor="#aaaaaa" align="center">‚±‚±‚Íi‹‰‚Ì‚½‚ß‚ÌŒf¦”Â‚Å‚·B<br>
<br>
<b>yŒf¦”Â—˜—p‹K–ñz</b>

</center>
 <div id="body" align="center">

    <form method='Post' action ='Threadservlet'> 
        <table>
        <tr><td>${ThreadRes.thread}</td></tr>
        <tr><td>${ThreadRes.res_con}</td></tr>
        </table>
        <input class="button" type="submit" value="“Še‚·‚é">
    </form>


</div>
</body>
