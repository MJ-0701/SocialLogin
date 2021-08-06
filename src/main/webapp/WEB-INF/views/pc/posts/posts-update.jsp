<%@include file="../../layOut/header.jsp"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<h1>게시글 수정</h1>
<div class="col-md-12">
  <div class="col-md-4">
    <form>
      <div class="form-group">
        <label for="title">글 번호</label>
        <input type="text" class="form-control" id = "id" value="${post.idx}" readonly>

      </div>
      <div class="form-group">
        <label for="title">제목</label>
        <input type="text" class="form-control" id="title" value="${post.title}">
      </div>
      <div class="form-group">
        <label for="author">작성자</label>
        <input type="text" class="form-control" id="author" value="${post.author}" readonly>
      </div>
      <div class="form-group">
        <label for="content">내용</label>
        <textarea class="form-control" id="content">${post.content}</textarea>
      </div>
    </form>
    <a href="/index" role="button" class="btn btn-secondary">취소</a>
    <button type="button" class="btn btn-primary" id="btn-update">수정완료</button>
    <button type="button" class="btn btn-danger" id="btn-delete">삭제</button>
  </div>
</div>
<%@include file="../../layOut/footer.jsp"%>