<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- saved from url=(0027)http://musouon.bbs.fc2.com/ -->
<html lang="ja"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
 <meta http-equiv="content-style-type" content="text/css">
 <title>�f����</title>
 <link rel="stylesheet" href="./�f����_files/jlisting.css" type="text/css">
 <link rel="stylesheet" href="./�f����_files/745617.css" type="text/css">
 <link rel="alternate" type="application/rss+xml" title="rss" href="http://musouon.bbs.fc2.com/rss/">
 
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
<center><table width="800px" bgcolor="#000000" cellspacing="1" cellpadding="5"><tbody><tr><td bgcolor="#aaaaaa" align="center">�����͐i���̂��߂̌f���ł��B<br>
<br>
<b>�y�f�����p�K��z</b>

<b></b><br>
<center></center>
<br>
<font color="#FF0000"><br>

<script type="text/javascript" src="./�f����_files/analyze.js.�_�E�����[�h" charset="utf-8"></script>

<form var="Title" items="${title}" method="Post" action ='titlehyoji'> 
        ${Title.threadName}<br>
    </form>

<c:forEach var="res" items="${resindx}"> 
    <table>
      <tr class="td">
       <td>${resu.number}</td><td>${resu.time}</td>
       <td>${resu.naiyou}</td>
      </tr>
      </c:forEach>
    </table>

    <table border="0" method = 'Post' action ='topp'>
     <tbody>
     <tr>
      <td>
       <noscript>JavaScript��L���ɂ���ƁA�G�����ȒP�E�B���h�E���g���܂�</noscript>
       </small>
      </td>
     </tr>
     <tr>
      <td colspan="2">
       <textarea name="msg" rows="7" cols="48"></textarea>
      </td>
     </tr>
     <tr>
      <td colspan="2" align="center">
       <input class="button" type="submit" value="���e">
�@�@�@�@<input class="button" type="reset" value="���Z�b�g"></td>
     </tr>
    </tbody>
    </table>
    </body>
    </html>
