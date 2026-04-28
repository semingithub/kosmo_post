<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/temp/head_css.jsp"></c:import>
</head>
<body id="page-top">
	<div id="wrapper">
		<c:import url="/WEB-INF/views/temp/sidebar.jsp"></c:import>
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<c:import url="/WEB-INF/views/temp/topbar.jsp"></c:import>
				<!-- Page Content  -->
				<div class="container-fluid">
					<!-- 제목 + 버튼 영역 -->
					<div class="d-flex justify-content-between align-items-center mb-4">
						<h1 class="text-dark">상품 상세내역 페이지</h1>
						<div>
							<c:if test="${not empty member}">
								<button type="button" class="btn btn-outline-primary" onclick="location.href='/account/create?productNo=${detail.productNo}'">상품 가입</button>
								<button id="btn" data-no="${detail.productNo}" class="btn btn-outline-primary">장바구니</button>
							</c:if>
							<button type="button" class="btn btn-outline-danger" onclick="location.href='./list'">뒤로가기</button>
						</div>
					</div>
					<!-- 상품 내용 -->
					<div class="row justify-content-center">
						<div class="d-flex align-items-start">
							<!-- 이미지 -->
							<img src="/files/product/${detail.file.fileName}" class="mr-4" style="width: 400px; height: auto;" alt="상품 이미지">
							<!-- 텍스트 -->
							<div>
								<h2 class="mb-3">
									<span class="badge badge-secondary">${detail.productType}</span>
									${detail.productName}
								</h2>
								<p>${detail.productContents}</p>
							</div>
						</div>
					</div>
				</div>
				<!-- End Content-->
			</div>
			<c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
			<!-- End content-wrapper -->
		</div>
		<!-- End wrapper -->
	</div>
	<c:import url="/WEB-INF/views/temp/footer_script.jsp"></c:import>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<script src="/js/cart/cart.js"></script>
</body>
</html>