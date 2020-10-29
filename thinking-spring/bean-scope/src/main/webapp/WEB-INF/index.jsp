<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
    <head>
        <link rel="stylesheet" href="<spring:theme code='styleSheet'/>" type="text/css"/>
    </head>
    <body >
        <!-- jsp EL 变量搜索路径： page -> request -> session -> application(ServletContext) -->
        \${userObject.name} : ${userObject.name}
        \${applicationScope['scopedTarget.user'].name} : ${applicationScope['scopedTarget.user'].name}
    </body>
</html>