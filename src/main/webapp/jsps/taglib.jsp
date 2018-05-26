<%--
  Created by IntelliJ IDEA.
  User: zmy
  Date: 2018/5/21
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%-- 常量 --%>
<c:set var="hotPostLimit" value="${10}"/>
<c:set var="lastedPostLimit" value="${10}"/>
<c:set var="hotUserLimit" value="${10}"/>

<%--用户常量--%>
<c:set var="ADMIN_STATUS" value="${3}"/>

<%--频道常量--%>
<c:set var="NORMAL_STATUS" value="${0}"/>

<%--文章常量--%>
<c:set var="POST_DELETED_STATUS" value="${1}"/>