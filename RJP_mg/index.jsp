<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html lang="ja"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
 <meta http-equiv="content-style-type" content="text/css">
 <title>�f����</title>
 <script type="text/javascript"> 
  <!-- 
  function check(){
    var flag = 0;
    // �ݒ�J�n�i�K�{�ɂ��鍀�ڂ�ݒ肵�Ă��������j
    if(document.form1.Thread_name.value == ""){ // �u�X���b�h���v�̓��͂��`�F�b�N
      flag = 1;
    }
    else if(document.form1.Res.value == ""){ // �u���X�v�̓��͂��`�F�b�N
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

 <link rel="stylesheet" type="text/css" href="index.jsp">

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
</font></td></tr></tbody></table><br></center>
 <div id="body" align="center">

  <p id="title"></p>
<div id="counter"><div id="counter">90141919</div></div>�i���ɕK�v�Ȍf������B
  

  <form class="inline_button" method="Post" action="AllThreadservlet"><br>
  <input class="button" type="submit" value="�X���b�h�ꗗ��">
  </form>

<br>
<br>
<br>

  <form id="bbsform"  method='Post' action='Threadservlet' name="form1" onSubmit="return check()">
    <table border="0">
     <tbody>
     <tr>
      <td nowrap>����</td>
      <td><input type="text" name='Thread_name' size="30"></td>
     </tr>
     <tr>
      <td colspan="2">
       <textarea name='Res' rows="7" cols="48"></textarea>
      </td>
     </tr>
     <tr>
      <td colspan="2" align="center">
		<input class="button" type='submit' value="���e" name="form1" onSubmit="return check()>
		<input class="button" type='reset' value="���Z�b�g">
     </tr>
	</td>
    </tbody>
  </table>
  </form>

 </div>
</body>
</html>