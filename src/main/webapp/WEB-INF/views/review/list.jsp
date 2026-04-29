<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:forEach items="${list}" var="r">
	<tr>
		<td>${r.reviewNo}</td>
		<td>${r.reviewContents}</td>
		<td>
			<c:forEach begin="1" end="${r.reviewStar}">★
		    </c:forEach>
			<c:forEach begin="${r.reviewStar + 1}" end="5">
        	☆
		    </c:forEach>
		</td>
		<td>${r.reviewDate}</td>
		<td>${r.username}</td>
	</tr>
</c:forEach>