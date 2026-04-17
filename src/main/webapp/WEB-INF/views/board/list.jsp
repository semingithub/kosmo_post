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
					<h1 class="h3 mb-4 text-gray-800">${name} List Page</h1>
					<button class="btn btn-primary" onclick="location.href='./create'">추가</button>
					<div class="row justify-content-center">
						<div class="col-6">
							<!-- 검색 폼 -->
							<div>
								<form action="./list" method="get">
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<select name="kind" class="custom-select">
												<option ${pager.kind eq 'v1'? 'selected' : '' } value="v1">Title</option>
												<option ${pager.kind eq 'v2'? 'selected' : '' } value="v2">Contents</option>
												<option ${pager.kind eq 'v3'? 'selected' : '' } value="v3">Writer</option>
											</select>
										</div>
										<input type="text" value="${pager.search}" name="search" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="button-addon2">
										<div class="input-group-append">
											<button class="btn btn-outline-secondary" type="submit" id="button-addon2">검색</button>
										</div>
									</div>
								</form>
							</div>
							<table class="table" style="text-align: center;">
								<thead class="thead-dark">
									<tr>
										<th>번호</th>
										<th>제목</th>
										<th>작성자</th>
										<th>작성시간</th>
										<th>조회수</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list}" var="l">
										<tr>
											<td>${l.boardNum}</td>
											<td>
												<a href="./detail?noticeNo=${l.boardNum}">
													<c:catch>
														<c:forEach begin="1" end="${l.boardDepth}">--</c:forEach>
													</c:catch>
													${l.boardTitle}
												</a>
											</td>
											<td>${l.boardWriter}</td>
											<td>${l.boardDate}</td>
											<td>${l.boardHits}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<div class="row justify-content-center">
								<nav aria-label="Page navigation example">
									<ul class="pagination">
										<li class="page-item ${pager.pre?'':'disabled'}"><a class="page-link" href="./list?page=${pager.pre ? pager.start-1 : pager.start}&search=${pager.search}&kind=${pager.kind}" aria-label="Previous">
												<span aria-hidden="true">&laquo;</span>
											</a></li>
										<c:forEach begin="${pager.start}" end="${pager.end}" var="i">
											<li class="page-item"><a class="page-link" href="./list?page=${i}&search=${pager.search}&kind=${pager.kind}">${i}</a></li>
										</c:forEach>
										<li class="page-item ${pager.next?'':'disabled'}"><a class="page-link" href="./list?page=${pager.next ? pager.end+1 : pager.end}&search=${pager.search}&kind=${pager.kind}" aria-label="Next">
												<span aria-hidden="true">&raquo;</span>
											</a></li>
									</ul>
								</nav>
							</div>
						</div>
					</div>
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