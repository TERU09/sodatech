<%@include file="./template/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%><%@ page import="java.util.*" %>
<main>
    <div style="height: 10vh;"></div>
    <div class="d-flex align-items-center justify-content-center p-1">
        <div class="border col-7 p-3">
            <br>
            <h5>4月の勤怠管理</h2>
                <br>
                <div class="row">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col" class="text-center">年月日</th>
                                <th scope="col" class="text-center">出勤時間</th>
                                <th scope="col" class="text-center">退勤時間</th>
                                <th scope="col" class="text-center">小計</th>
                                <th scope="col" class="text-center">備考</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% 
                            List<Integer> idList = (List<Integer>)request.getAttribute("idList");
                            HashMap<Integer,Integer> daringMap = (HashMap<Integer,Integer>)request.getAttribute("daringMap");
                            HashMap<Integer,Integer> weekMap = (HashMap<Integer,Integer>)request.getAttribute("weekMap");
                                    
                            for(Integer id:idList){  
                            %>
                            <tr>
                                <th scope='row'><a href="/attendanceManagement/show?calendar_id=<%= id %>&dating=<%= daringMap.get(id) %>"><%=daringMap.get(id)%></a></th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                                <td></td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
                <br>
        </div>


    </div>
    <div style="height: 10vh;"></div>
</main>
<%@include file="./template/footer.jsp"%>