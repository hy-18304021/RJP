<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="CSS\index.css" rel="stylesheet">
    <title>TOP</title>
    <table>
        <tr>
            <td>���O�C��</td><td>�V�K�쐬</td>
        </tr>
        <tr>
            <td>�����ɉ摜</td>
        </tr>
    </table>
</head>
<hr>
<body>
    �X���b�h����
    <input type='text'name='word'placeholder='�������������[�h'><br>
    <table border="1">
        <tr><th>�^�C�g��</th><th>���e��</th><th>����</th><th>�쐬����</th><th>�ŏI�X�V����</th></tr>
        <c:forEach var="prof" items="${users}"> 
			<tr><td>${sur.title}</td><td>${sur.tuser}</td><td>${sur.kensu}</td><td>${sur.creattime}</td><td>${sur.newtime}</td></tr>
		</c:forEach>
    </table>
</body>
</html>