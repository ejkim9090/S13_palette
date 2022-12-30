<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>alert</title>
<link href="<%=request.getContextPath()%>/css/reset.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/jquery-3.6.1.js"></script>
</head>
<body>
<script>
	if("${func}" == "memberInsert"){
		alert("${msg}");
		location.href = "<%= request.getContextPath()%>/login";
	} else if("${func}" == "memberInsertFail"){
		alert("${msg}");
		location.href = "<%= request.getContextPath()%>/join";
	} else if("${func}" == "loginFail"){
		alert("${msg}");
		location.href = "<%= request.getContextPath()%>/login";
	}

</script>
</body>
</html>