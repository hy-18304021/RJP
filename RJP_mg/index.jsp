<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- saved from url=(0027)http://musouon.bbs.fc2.com/ -->
<<<<<<< HEAD
<html lang="ja">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="content-style-type" content="text/css">
    <title>掲示板名</title> 
    <link rel="stylesheet" href="./掲示板名_files/jlisting.css" type="text/css">
    <link rel="stylesheet" href="CSS/index.css" type="text/css">
    <link rel="alternate" type="application/rss+xml" title="rss" href="http://musouon.bbs.fc2.com/rss/">
    <style type="text/css">
    <!--
      body {
        margin: 0;
        padding: 0;
      }
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
      }
      -->
    </style>
  </head>
  <body onload="">
    <center><table width="800px" bgcolor="#000000" cellspacing="1" cellpadding="5"><tbody><tr><td bgcolor="#aaaaaa" align="center">ここは進級のための掲示板です。<br>
    <br>
    <b>【掲示板利用規約】</b>
    <b>
    </b>
    <br>
    <center></center>
    <br>
    <font color="#FF0000"><br>
    <script type="text/javascript" src="./掲示板名_files/analyze.js.ダウンロード" charset="utf-8"></script>
    </font></td></tr></tbody></table><br></center>
    <div id="body" align="center">
=======
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
>>>>>>> fcfab0430b131472cbf2b8760d29d02f2dcd0f5b

    <p id="title"></p>
    <div id="counter"><div id="counter">90141919</div></div>進級に必要な掲示板だよ。
    <p id="navi_bar"><a href="https://ameblo.jp/zaitesu-kaku/">一覧（新規投稿）</a>｜<a href="https://ameblo.jp/zaitesu-kaku/">ワード検索</a>｜<a href="https://ameblo.jp/zaitesu-kaku/" target="_top">管理</a></p>
  <table id="skin1" cellpadding="0" cellspacing="0">
    <tbody>
      <tr>
        <td>
          <table width="100%" cellpadding="4" cellspacing="1">
            <tbody>
              <tr class="th">
                <th><span class="subj">タイトル</span></th>
                <th><span class="subj">件数</span></th>
                <th><span class="subj">作成日時</span></th>
                <th><span class="subj">最終更新日時</span></th>
              </tr>
              <c:forEach var="thread" items="${threadindx}"> 
                <tr class="td">
                  <td>${thead.name}</td>
                  <td>${thead.kensu}</td>
                  <td>${thead.Makethead}</td>
                  <td>${thead.Newthead}</td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </td>
      </tr>
    </tbody>
  </table><!---->
  <form class="inline_button" action="https://ameblo.jp/zaitesu-kaku/" method="POST">
    <input type="hidden" name="pos" value="30">
    <input class="button" type="submit" name="" value="スレッド一覧へ">
  </form>
<<<<<<< HEAD
  <br>
  <br>
  <br>
  <form id="bbsform" name="fc2BBSform" action="http://musouon.bbs.fc2.com/" method="POST" enctype="multipart/form-data">
  <input type="text" name="dummytext" value="" style="display:none">
  <input type="hidden" name="act" value="post">
  <div id="bbsform2">
  <table border="0" method = 'Post' action ='topp'>
    <tbody>
      <tr>
        <td nowrap="">件名</td>
        <td><input type="text" name="dai" value="" size="30"></td>
      </tr>
      <tr>
        <td colspan="2">メッセージ
          <small>
            <script language="JavaScript"></script>
              <noscript>JavaScriptを有効にすると、絵文字簡単ウィンドウが使えます</noscript>
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
          <input class="button" type="submit" value="投稿">
          <input class="button" type="reset" value="リセット">
        </td>
      </tr>
    </tbody>
  </table>
  </div>
=======

<br>
<br>
<br>

  <form id="bbsform"  action="Threadkakunin" method="POST" enctype="multipart/form-data">
   <div id="bbsform2">
    <table border="0" method = 'Post' action ='Tops'>
     <tbody>
     <tr>
      <td nowrap>件名</td>
      <td><input type="text" name="Thread" size="30"></td>
     </tr>
     <tr>
      <td colspan="2">
       <textarea name="Res" rows="7" cols="48"></textarea>
      </td>
     </tr>
     <tr>
      <td colspan="2">
       <input class="button" type="submit" value="投稿">
       <input class="button" type="reset" value="リセット"></td>
     </tr>
    </tbody></table>
   </div>
>>>>>>> fcfab0430b131472cbf2b8760d29d02f2dcd0f5b
  </form>
  </div><!---->
  </body>
</html>