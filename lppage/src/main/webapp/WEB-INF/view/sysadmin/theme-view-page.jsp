<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>${page.name}</title>
    <link rel="stylesheet" href="/static/vendor/bs-icons/bootstrap-icons.css"/>
    <link rel="stylesheet" type="text/css" href="/static/vendor/wpl.min.css" />
    <link rel="stylesheet" href="/static/${theme}/css/slick.min.css" type="text/css" />
    <link rel="stylesheet" href="/static/${theme}/css/style.css" type="text/css" />
    <script src="/static/vendor/jquery-3.7.1.min.js"></script>
</head>
<body>
<c:forEach var="component" items="${components}">
${component.content}
</c:forEach>

<script src="/static/vendor/bootstrap.bundle.min.js"></script>
<script src="/static/${theme}/js/lp.js"></script>
</body>
</html>
