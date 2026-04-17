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
					<h1 class="h3 mb-4 text-gray-800">Detail Page</h1>
					<div style="display: inline;">
						<button class="btn btn-primary" onclick="location.href='./update?departmentNo=${detail.boardNum}'">수정</button>
					</div>
					<button class="btn btn-primary" onclick="location.href='./list'">뒤로가기</button>
					<div class="row justify-content-center">
						<div class="col-6">
							<h5>${detail.boardTitle}</h5>
							<h5>${detail.boardWriter}</h5>
							<div>${detail.boardContents}</div>
							<c:forEach items="${detail.list}" var="f">
								<h4><img src="/files/${image}/${f.fileName}"></h4>
							</c:forEach>
							<div>
								<form action="./delete" method="post">
									<input type="hidden" name="departmentNo" value="${detail.boardNum}">
									<button type="submit" class="btn btn-outline-danger">삭제</button>
								</form>
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