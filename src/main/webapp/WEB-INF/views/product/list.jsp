<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="/WEB-INF/views/temp/head_css.jsp"></c:import>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
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
						<h1>상품 리스트 페이지</h1>
						<button type="button" class="btn btn-dark" onclick="location.href='./create'">상품 추가</button>
						<form action="./list" method="get">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<select name="kind" class="custom-select">
										<option ${pager.kind eq 'v1'? 'selected' : '' } value="v1">이름</option>
										<option ${pager.kind eq 'v2'? 'selected' : '' } value="v2">종류</option>
									</select>
								</div>
								<input type="text" value="${pager.search}" name="search" class="form-control" placeholder="검색할 상품 정보를 입력하세요." aria-label="Recipient's username" aria-describedby="button-addon2">
								<div class="input-group-append">
									<button class="btn btn-outline-secondary" type="submit" id="button-addon2">검색</button>
								</div>
							</div>
						</form>
						<div class="row justify-content-center">
							<c:forEach items="${list}" var="l">
								<div class="col-md-4 mb-4 d-flex justify-content-center">
									<div class="card" style="width: 300px;">
										<img src="/files/${image}/${l.fileName}" class="card-img-top p-2" style="height: 200px; width: 100%; object-fit: contain;">
										<div class="card-body text-center">
											<h5 class="card-title">${l.productName}</h5>
											<p class="card-text">상품 종류: ${l.productType}</p>
											<c:choose>
												<c:when test="${l.productType eq '대출'}">
													<p class="card-text">최저금리: 연 ${l.productRate}%</p>
												</c:when>
												<c:otherwise>
													<p class="card-text">최고금리: 연 ${l.productRate}%</p>
												</c:otherwise>
											</c:choose>
											<button type="button" class="btn btn-dark" onclick="location.href='./detail?productNo=${l.productNo}'">자세히 보기</button>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
						<div class="row justify-content-center">
							<nav aria-label="Page navigation example">
								<ul class="pagination">
									<li class="page-item ${pager.pre?'':'disabled'}">
										<a class="page-link" href="./list?page=${pager.pre ? pager.start-1 : pager.start}&search=${pager.search}&kind=${pager.kind}" aria-label="Previous">
											<span aria-hidden="true">&laquo;</span>
										</a>
									</li>
									<c:forEach begin="${pager.start}" end="${pager.end}" var="i">
										<li class="page-item">
											<a class="page-link" href="./list?page=${i}&search=${pager.search}&kind=${pager.kind}">${i}</a>
										</li>
									</c:forEach>
									<li class="page-item ${pager.next?'':'disabled'}">
										<a class="page-link" href="./list?page=${pager.next ? pager.end+1 : pager.end}&search=${pager.search}&kind=${pager.kind}" aria-label="Next">
											<span aria-hidden="true">&raquo;</span>
										</a>
									</li>
								</ul>
							</nav>
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
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>