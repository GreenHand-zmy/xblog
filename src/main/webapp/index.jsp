<html>
<body>
<h2>Hello World!</h2>
</body>
</html>
<c:forEach var="channel" items="${channelList}">
    <li>
        <a href="${ctx}/channel/${channel.id}" nav="${channel.name}">${channel.name}</a>
            <%--<a href="" nav="">1</a>--%>
    </li>
</c:forEach>
