<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=UTF-8" %>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html lang="ja"><head>
 
 <meta http-equiv="content-style-type" content="text/css">
 <title>�f����</title>

 <link rel="stylesheet" type="text/css" href="index.jsp">
</head>
<body>
<center><table width="800px" bgcolor="#000000" cellspacing="1" cellpadding="5"><tbody><tr><td bgcolor="#aaaaaa" align="center">�����͐i���̂��߂̌f���ł��B<br>
<br>
<h2>�y�X���b�h�ꗗ�z</h2><br>

<script type="text/javascript" src="./�f����_files/analyze.js.�_�E�����[�h" charset="utf-8"></script>
</font></td></tr></tbody></table><br></center>
 <div id="body" align="center">

  <p id="title"></p>
<div id="counter"><div id="counter">90141919</div></div>�i���ɕK�v�Ȍf������B

  <form class="inline_button" action="Topp"><br>
  <input class="button" type="submit" value="�g�b�v�y�[�W��">
  </form>

  <from >
  <table id="skin1" cellpadding="0" cellspacing="0">
   <tbody><tr>
    <td>
     <table width="100%" cellpadding="4" cellspacing="1">
      <tbody>
      <tr class="th">
       <th><span class="subj">�X���b�h��</span></th>
       <th><span class="subj">�쐬����</span></th>
       <th><span class="subj">�ŏI�X�V����</span></th>
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