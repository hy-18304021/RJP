<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html lang="ja"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
 <meta http-equiv="content-style-type" content="text/css">
 <title>掲示板名</title>
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

 <link rel="stylesheet" type="text/css" href="index.jsp">

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
  

  <form class="inline_button" method="Post" action="AllThreadservlet"><br>
  <input class="button" type="submit" value="スレッド一覧へ">
  </form>

<br>
<br>
<br>

  <form id="bbsform"  method='Post' action='Threadservlet' name="form1" onSubmit="return check()">
    <table border="0">
     <tbody>
     <tr>
      <td nowrap>件名</td>
      <td><input type="text" name='Thread_name' size="30"></td>
     </tr>
     <tr>
      <td colspan="2">
       <textarea name='Res' rows="7" cols="48"></textarea>
      </td>
     </tr>
     <tr>
      <td colspan="2" align="center">
		<input class="button" type='submit' value="投稿" name="form1" onSubmit="return check()>
		<input class="button" type='reset' value="リセット">
     </tr>
	</td>
    </tbody>
  </table>
  </form>

 </div>
</body>
</html>