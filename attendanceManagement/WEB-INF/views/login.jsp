<%@include file="./template/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%><%@ page import="java.util.*" %>
<main>
    <div style="height: 10vh"></div>
    
    <div class="d-flex align-items-center justify-content-center p-1" style="height: 85vh">
        <div class="border col-7 p-3">
            <br />
            <h2>ログイン</h2>
            <br />
            <div class="row">
                <div class="col-md">
                    <form action="/attendanceManagement/loginCheck" method="post">
                        <div class="form-group">
                            <label>メール：</label>
                            <input name="mail" type="text" class="form-control" placeholder="yamada@mail.com" />
                        </div>
                        <div class="form-group">
                            <label>パスワード：</label>
                            <input name="password" type="password" class="form-control" />
                        </div>
                    </div>
                </div>
                <div class="row center-block text-center p-3">
                    <div class="col-1"></div>
                    <div class="col-5">
                        <a href="/attendanceManagement/signup">
                            <button type="button" class="btn btn-outline-secondary btn-block">
                                新規登録
                            </button>
                        </a>
                    </div>
                    <div class="col-5">
                        <button type="submit" class="btn btn-outline-primary btn-block">
                            ログイン
                        </button>
                    </div>
                </div>
            </form>
            <br />
        </div>
    </div>
</main>
<%@include file="./template/footer.jsp"%>