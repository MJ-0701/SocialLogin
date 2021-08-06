<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../layOut/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1>JSP Test</h1>
<div class="col-md-12">
    <div class="row">
        <div class="col-md-6">
            <a href ="/postsTest/save" role = "button" class="btn btn-primary">글 등록</a>

            <c:choose>
                <c:when test="${clientName ne null and clientName ne ''}">
            Login as: <span id="user">${clientName}</span>
<%--                    <span>--%>
<%--                        <img src="${clientPicture}"/>--%>
<%--                    </span>--%>
            <a href="/logout" class="btn btn-info active" role="button">Logout</a>
                </c:when>

                <c:otherwise>
                    <a href="/oauth2/authorization/google" class="btn btn-success active" role="button">Google Login</a>
                    <a href="/oauth2/authorization/naver" class="btn btn-secondary active" role="button">Naver Login</a>
                    <a href="/oauth2/authorization/kakao" class="btn btn-warning active" role="button">Kakao Login</a>
                    <a href="/oauth2/authorization/facebook" class="btn btn-primary active" role="button">Facebook Login</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <br>
    <!-- 목록 출력 영역 -->
    <table class="table table-horizontal table-boredred">
        <thead class="thead-strong">
        <tr>
            <th>게시글 번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>최종수정일</th>
        </tr>
        </thead>
        <tbody id = "tbody">
        <c:forEach var="posts" items="${postsTest}">
        <tr>
            <td>${posts.idx}</td>
            <td><a href = "/postsTest/update/${posts.idx}">${posts.title}</a></td>
            <td>${posts.author}</td>
            <td>${posts.modifiedDate}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="../layOut/footer.jsp"%>