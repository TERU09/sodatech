<%@include file="./template/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%><%@ page import="java.util.*" %>
<main>
  <div style="height: 10vh;"></div>

  <div class="d-flex align-items-center justify-content-center p-1" style="height: 85vh;">
    <div class="border col-7 p-3">
      <br>
      <h2>登録・更新</h2>
      <br>
      <div class="row">
        <%
          
        %>
        <form action="/attendanceManagement/workingTimeResist" method="post">
          <div class="form-group p-2">
            <label>日付</label>
            <input type="text" class="form-control" value="20230302" disabled>
          </div>
          <div class="form-group p-2">
            <label>出勤時間</label>
            <input name="startTime" type="time" class="form-control">
          </div>
          <div class="form-group p-2">
            <label>退勤時間</label>
            <input name="endTime" type="time" class="form-control">
          </div>
          <div class="form-group p-2">
            <label>備考</label>
            <input type="text" class="form-control">
          </div>
          <div class="row center-block text-center p-3">
            <div class="col-1">
            </div>
            <div class="col-5">
              <button type="button" class="btn btn-outline-secondary btn-block">戻る</button>
            </div>
            <div class="col-5">
              <button type="submit" class="btn btn-outline-primary btn-block">登録・更新</button>
            </div>
          </div>
        </form>
      </div>
      <br>
    </div>


  </div>

</main>
<%@include file="./template/footer.jsp"%>