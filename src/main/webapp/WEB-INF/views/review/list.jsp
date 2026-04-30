<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<table class="table table-bordered table-hover text-center">
	<thead class="thead-dark">
		<tr>
			<th>별점</th>
			<th>내용</th>
			<th>작성시간</th>
			<th>작성자</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="r">
			<tr>
				<td>${r.reviewContents}</td>
				<td>
					<c:forEach begin="1" end="${r.reviewStar}">★</c:forEach>
					<c:forEach begin="${r.reviewStar + 1}" end="5">☆</c:forEach>
				</td>
				<td>
					<fmt:parseDate value="${r.reviewDate}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedate" />
					<fmt:formatDate value="${parsedate}" pattern="yyyy-MM-dd HH:mm" />
				</td>
				<td>${r.username}</td>
				<td data-id="${r.reviewNo}" data-star="${r.reviewStar}">
					<button class="btn btn-outline-primary uBtn" data-toggle="modal" data-target="#reviewModal">수정</button>
					<button class="btn btn-outline-danger dBtn">삭제</button>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>