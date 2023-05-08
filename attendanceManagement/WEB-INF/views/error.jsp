<%@include file="./template/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%><%@ page import="java.util.*" %>
<main>
    <div style="height: 10vh"></div>
    
    <div class="d-flex align-items-center justify-content-center p-1" style="height: 85vh">
        <div class="border col-7 p-3">
            
            <% List<String> caveatList = (List<String>)request.getAttribute("caveatList"); %>
            <% for(String caveat:caveatList){ %>
                <div class="alert alert-danger" role="alert">
                    <%=caveat%>
                  </div>
           
            <% } %>
          
        </div>
    </div>
</main>
<%@include file="./template/footer.jsp"%>