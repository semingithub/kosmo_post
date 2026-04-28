<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
					<h1>장바구니 페이지</h1>
					<h1 class="h3 mb-4 text-gray-800">
						<div class="table-responsive">
							<table class="table table-bordered table-hover text-center">
								<thead class="thead-dark">
									<tr>
										<th>
											<div>
												<input type="checkbox" id="select">
												<button id="btn" class="btn btn-primary">가입</button>
												<button id="btn2" class="btn btn-danger">삭제</button>
											</div>
										</th>
										<th>상품 이미지</th>
										<th>상품 이름</th>
										<th>상품 이율</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list}" var="l">
										<tr>
											<td>
												<input type="checkbox" class="select2" value="${l.productNo}">
												<button id="btn3" class="btn btn-outline-danger">삭제</button>
											</td>
											<td>
												<img src="/files/product/${l.file.fileName}" style="width:100px; height:100px;">
											</td>
											<td>${l.productName}</td>
											<td>${l.productRate}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
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
	<script src="/js/cart/list.js"></script>
</body>
</html>