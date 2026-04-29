<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:forEach items="${list}" var="l">
	<tr>
		<td>
			<input type="checkbox" data-id="${l.productNo}" class="select2">
			<button id="btn3" class="btn btn-outline-danger del">삭제</button>
		</td>
		<td>
			<img src="/files/product/${l.file.fileName}" style="width: 100px; height: 100px;">
		</td>
		<td>${l.productName}</td>
		<td>${l.productRate}</td>
	</tr>
</c:forEach>