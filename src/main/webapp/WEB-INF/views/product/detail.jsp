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
					<h1 class="h3 mb-4 text-gray-800">
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
					</h1>
					<!-- End Page Content container-fluid-->
				</div>
				<!-- End Content-->
			</div>
			<c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
			<!-- End content-wrapper -->
		</div>
		<!-- End wrapper -->
	</div>
	<c:import url="/WEB-INF/views/temp/footer_script.jsp"></c:import>
</body>
</html>