<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html lang="ja">

<head>
	<meta http-equiv="Content-Type" content="index/jsp; charset=UTF-8">
	<meta http-equiv="content-style-type" content="CSS/index.css">
	<title>�f���}�O�J�b�v</title>
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

	<link rel="shortcut icon" href="CSS/mug_favi.ico">
	<link rel="stylesheet"href="CSS/index.css">
</head>

<body>
	<div  align="center">
		<p id="title"></p>
		<a href="index.jsp"><img src="CSS/muglogo55.png"  align="middle" vspace="25"></a>
	</div>
	<div class="formdayo"  align="center">
		<form class="inline_button" method="Post" action="AllThreadservlet"><br>
			<input class="button" type="submit" value="�X���b�h�ꗗ��">
		</form>
		<p id="bbsformtitle">�V�K�X���b�h�쐬</p>
		<form id="bbsform"  method='Post' action='Threadservlet' name="form1" onSubmit="return check()">
			<table border="0">
				<tbody>
					<tr>
						<td nowrap>����</td>
						<td><input type="text" name='Thread_name' size="30"></td>
					</tr>
					<tr>
						<td colspan="2">���e</td>
					</tr>
					<tr>
						<td colspan="2"><textarea name='Res' rows="7" cols="48"></textarea></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
						<input class="button" type='submit' value="���e" name="form1" onSubmit="return check()>
						<input class="button" type='reset' value="���Z�b�g">
					</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>

</html>