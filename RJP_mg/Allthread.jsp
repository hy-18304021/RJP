<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=UTF-8" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html lang="ja"><head>
 
 <meta http-equiv="content-style-type" content="text/css">
 <title>掲示板名</title>

 <link rel="stylesheet" type="text/css" href="index.jsp">
</head>
<body>
<center><table width="800px" bgcolor="#000000" cellspacing="1" cellpadding="5"><tbody><tr><td bgcolor="#aaaaaa" align="center">ここは進級のための掲示板です。<br>
<br>
<h2>【スレッド一覧】</h2><br>

<script type="text/javascript" src="./掲示板名_files/analyze.js.ダウンロード" charset="utf-8"></script>
</font></td></tr></tbody></table><br></center>
 <div id="body" align="center">

  <p id="title"></p>
<div id="counter"><div id="counter">90141919</div></div>進級に必要な掲示板だよ。

  <form class="inline_button" action="Topp"><br>
  <input class="button" type="submit" value="トップページへ">
  </form>

  <from >
  <table id="skin1" cellpadding="0" cellspacing="0">
   <tbody><tr>
    <td>
     <table width="100%" cellpadding="4" cellspacing="1">
      <tbody>
      <tr class="th">
       <th><span class="subj">スレッド名</span></th>
       <th><span class="subj">作成日時</span></th>
       <th><span class="subj">最終更新日時</span></th>
      </tr>
      <c:forEach var="thr" items="${threadindex}">
      <tr class="td">
       <td><a href="Resservlet?thread_Name=${thr.thread_Name}">${thr.thread_Name}</a></td>
       <td>${thr.thread_Create_Time}</td>
       <td>${thr.thread_Update_Time}</td>
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