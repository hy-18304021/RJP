<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html lang="ja"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
 <meta http-equiv="content-style-type" content="text/css">
 <title>掲示板名</title>
 <link rel="stylesheet" href="./掲示板名_files/jlisting.css" type="text/css">
 <link rel="stylesheet" href="./掲示板名_files/745617.css" type="text/css">
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
<center><table width="800px" bgcolor="#000000" cellspacing="1" cellpadding="5"><tbody><tr><td bgcolor="#aaaaaa" align="center">ここは進級のための掲示板です。<br>
<br>
<b>【掲示板利用規約】</b>

<b></b><br>
<center></center>
<br>
<font color="#FF0000"><br>

<script type="text/javascript" src="./掲示板名_files/analyze.js.ダウンロード" charset="utf-8"></script>
</font></td></tr></tbody></table><br></center>
 <div id="body" align="center">

  <p id="title"></p>
<div id="counter"><div id="counter">90141919</div></div>進級に必要な掲示板だよ。
  <from >
  <table id="skin1" cellpadding="0" cellspacing="0">
   <tbody><tr>
    <td>
     <table width="100%" cellpadding="4" cellspacing="1">
      <tbody>
      <tr class="th">
       <th><span class="subj">タイトル</span></th>
       <th><span class="subj">件数</span></th>
       <th><span class="subj">作成日時</span></th>
       <th><span class="subj">最終更新日時</span></th>
      </tr>
      <c:forEach var="thr" items="${threadindex}">
      <tr class="td">
       <td>${thr.threadname}</td>
       <td>${thr.resid}</td>
       <td>${thr.threadcreatetime}</td>
       <td>${thr.threadupdatetime}</td>
      </tr>
      </c:forEach>
     </tbody></table>
    </td>
   </tr>
  </tbody></table>
  </from>
  
 </div>
</body>
</html>