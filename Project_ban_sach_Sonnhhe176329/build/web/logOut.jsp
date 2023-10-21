
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    session.invalidate();
    response.sendRedirect("home");
%>
