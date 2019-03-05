<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html lang="ja">

<head>
	<meta http-equiv="Content-Type" content="index/jsp; charset=UTF-8">
	<meta http-equiv="content-style-type" content="CSS/index.css">
	<title>掲示板マグカップ</title>
  <script type="text/javascript"> 
  <!-- 
  function check(){
    var flag = 0;
    // 設定開始（必須にする項目を設定してください）
    if(document.form1.Thread_name.value == ""){ // 「スレッド名」の入力をチェック
      flag = 1;
    }
    else if(document.form1.Res.value == ""){ // 「レス」の入力をチェック
      flag = 1;
    }
    if(flag){
      window.alert('必須項目に未入力がありました'); // 入力漏れがあれば警告ダイアログを表示
      return false; // 送信を中止
    }
    else{
      return true; // 送信を実行
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
			<input class="button" type="submit" value="スレッド一覧へ">
		</form>
		<p id="bbsformtitle">新規スレッド作成</p>
		<form id="bbsform"  method='Post' action='Threadservlet' name="form1" onSubmit="return check()">
			<table border="0">
				<tbody>
					<tr>
						<td nowrap>件名</td>
						<td><input type="text" name='Thread_name' size="30"></td>
					</tr>
					<tr>
						<td colspan="2">内容</td>
					</tr>
					<tr>
						<td colspan="2"><textarea name='Res' rows="7" cols="48"></textarea></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
						<input class="button" type='submit' value="投稿" name="form1" onSubmit="return check()>
						<input class="button" type='reset' value="リセット">
					</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>

</html>