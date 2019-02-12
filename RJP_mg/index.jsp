<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="CSS\index.css" rel="stylesheet">
    <title>TOP</title>
    <table>
        <tr>
            <td>ログイン</td><td>新規作成</td>
        </tr>
        <tr>
            <td>ここに画像</td>
        </tr>
    </table>
</head>
<hr>
<body>
    スレッド検索
    <input type='text'name='word'placeholder='検索したいワード'><br>
    <table border="1">
        <tr><th>タイトル</th><th>投稿者</th><th>件数</th><th>作成日時</th><th>最終更新日時</th></tr>
        <c:forEach var="prof" items="${users}"> 
			<tr><td>${sur.title}</td><td>${sur.tuser}</td><td>${sur.kensu}</td><td>${sur.creattime}</td><td>${sur.newtime}</td></tr>
		</c:forEach>
    </table>
</body>
</html>