<%@ page pageEncoding="Windows-31J"
 contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html lang="ja">

<head>

<meta http-equiv="Content-Type" content="Thread/jsp; charset=UTF-8">
 
 <meta http-equiv="content-style-type" content="CSS/index.css">
 
 <title>�f���}�O�J�b�v</title>
 
  <script type="text/javascript"> 
  <!-- 
  function check(){
    var flag = 0;
    // �ݒ�J�n�i�K�{�ɂ��鍀�ڂ�ݒ肵�Ă��������j
    if(document.form1.Res.value == ""){ // �u���X�v�̓��͂��`�F�b�N
      flag = 1;
    }
    if(flag){
      window.alert('�K�{���ڂɖ����͂�����܂���'); // ���͘R�ꂪ����Όx���_�C�A���O��\��
      return false; // ���M�𒆎~
    }
    else{
      return true; // ���M�����s
    }
  }
  </script>

 <link rel="shortcut icon" href="CSS/mug_favi.ico">

 <link rel="stylesheet"href="CSS/index.css">

</head>

<body>

 <div  align="center">

  <p id="title"></p>

  <a href="index.jsp"><img src="CSS/muglogo55.png"  align="middle" vspace="25"></a>
  
 </div>
 
  <div class="formdayo"  align="center">
<br>
<h1>�y<font color="FF0000">${resindx[0].thread_Name}</font>�z</h1>
<br>

 <div class ="button">
  <form class="Tophe" action="Topp">
   <input class="button" type="submit" value="�g�b�v�y�[�W��">
  </form>
 </div>
 <div class ="button">
  <form class="Threadhe" method="Post" action="AllThreadservlet"  >
   <input class="button" type="submit" value="�X���b�h�ꗗ��">
  </form>
 </div>
 
</center></td>


<!--
 <c:forEach var="res" items="${resindx}"> 
     <table>
       <tr class="td">
        <td>${res.res_Time}</td>
        <td>${res.res_Con}</td>
       </tr>
       </c:forEach>
     </table>
-->

  <div class="topic">
  <div class="topic2">

  <p class="subj">
    <p class="res_date"><span class="date">${resindx[0].res_Time}</p>
    <p class="msg">     <span class="lh12">${resindx[0].res_Con}</span>

<!-- 
  </p>
  <p class="date"><span class="date"></span></p>
  <p class="msg">   <span class="lh12"></span>
  </p>
-->

<c:forEach var="res" items="${resindx}" begin="1">
   <div class="res">
    <p class="res_subj"><span class="subj">Re: ${resindx[0].thread_Name}</span>
    </p>
    <p class="res_date"><span class="date">${res.res_Time}</p>
    <p class="msg">     <span class="lh12">${res.res_Con}</span>
    </p>
   </div>
</c:forEach>
   
  </div>
  </div>

  <p id="bbsformtitle">�V�K���X���e</p>
  <form id="bbsform"  method='Post' action='Resservlet' name="form1" onSubmit="return check()">
    <table border="0">
     <tbody>
     <tr>
      <td colspan="2">���e
      </td>
     </tr>
     <tr>
      <td colspan="2">
       <textarea name='Res' rows="7" cols="48"></textarea>
       
      </td>
     </tr>
     <tr>
      <td colspan="2" align="center">
  <input type="hidden" name="thread_Name" value="${resindx[0].thread_Name}">
  <input class="button" type='submit' value="���e" name="form1" onSubmit="return check()>
  <input class="button" type='reset' value="���Z�b�g">
     </tr>
 </td>
    </tbody></table>
  </form>
  
  </div>
    </body>
    </html>