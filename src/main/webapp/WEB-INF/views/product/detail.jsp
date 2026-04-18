<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 상세내역 페이지</h1>
	<button type="button" class="btn btn-dark" onclick="location.href='./list'">뒤로가기</button>
	<div class="row justify-content-center">
		<div class="d-flex align-items-start">
			<img src="/files/product/${detail.file.fileName}" class="mr-3 flex-shrink-0" alt="...">

			<div>
				<h1>
					<span class="badge badge-secondary">${detail.productType}</span>
					${detail.productName}
				</h1>
				<p>${detail.productContents}</p>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>