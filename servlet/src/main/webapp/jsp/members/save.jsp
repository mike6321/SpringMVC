<%@ page import="me.choi.servlet.domain.member.Member" %>
<%@ page import="org.slf4j.Logger" %>
<%@ page import="org.slf4j.LoggerFactory" %>
<%@ page import="me.choi.servlet.domain.member.MemberRepository" %><%--
  Created by IntelliJ IDEA.
  User: junwoochoi
  Date: 2021/04/11
  Time: 5:31 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Logger logger = LoggerFactory.getLogger(this.getClass());
    MemberRepository memberRepository = MemberRepository.getInstance();

    logger.info("MemberSaveServlet.service");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>id=<%=member.getUsername()%></li>
    <li>id=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
