<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=UTF-8" %>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html lang="ja">

<head>

<meta http-equiv="Content-Type" content="Allthread.jsp; charset=UTF-8">
 
 <meta http-equiv="content-style-type" content="CSS/index.css">
 
 <title>�f���}�O�J�b�v</title>

 <link rel="shortcut icon" href="CSS/mug_favi.ico">

 <link rel="stylesheet"href="CSS/index.css">

</head>

<body>

 <div  align="center">

  <p id="title"></p>

  <a href="index.jsp"><img src="CSS/muglogo55.png"  align="middle" vspace="25"></a>
  
 </div>

  <div class="formdayo"  align="center">
  
  <form class="inline_button" action="Topp"><br>
  <input class="button" type="submit" value="�g�b�v�y�[�W��">
  </form>

  <p id="bbsformtitle2">�X���b�h�ꗗ</p>
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