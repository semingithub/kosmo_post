<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/temp/head_css.jsp"></c:import>
<style>
.input-group-prepend {
	width: 120px;
}

.input-group-text {
	width: 100%;
	justify-content: center;
}

.join-container {
	max-width: 450px;
	margin: 50px auto; /* 위아래 여백 */
}
</style>
</head>
<body id="page-top">
	<div id="wrapper">
		<c:import url="/WEB-INF/views/temp/sidebar.jsp"></c:import>
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<c:import url="/WEB-INF/views/temp/topbar.jsp"></c:import>
				<!-- Page Content  -->
				<div class="container-fluid">
					<h1 class="h3 mb-4 text-gray-800">로그인 페이지</h1>
					<div class="join-container">
						<div>
							<h3>${param.message}</h3>
						</div>
						<form action="/member/login" method="post" enctype="multipart/form-data">
							<div>
								<div class="input-group flex-nowrap">
									<div class="input-group-prepend">
										<span class="input-group-text" id="username">아이디</span>
										<%-- <form:label path="username" cssClass="input-group-text" id="username">아이디</form:label> --%>
									</div>
									<%-- <form:input path="username" cssClass="form-control" /> --%>
									<input type="text" class="form-control" placeholder="아이디를 입력하세요." name="username" value="${cookie.rememberId.value}">
								</div>
								<%-- <form:errors path="username"></form:errors> --%>
							</div>
							<div>
								<div class="input-group flex-nowrap">
									<div class="input-group-prepend">
										<span class="input-group-text" id="password">비밀번호</span>
									</div>
									<%-- form:password path="password" cssClass="form-control" /> --%>
									<input type="password" class="form-control" placeholder="비밀번호를 입력하세요." name="password" value="1234">
								</div>
								<%-- <form:errors path="password"></form:errors> --%>
							</div>
							<div class="form-group form-check">
								<input type="checkbox" class="form-check-input" id="exampleCheck1" name="rememberId" value="1">
								<label class="form-check-label" for="exampleCheck1">아이디 저장</label>
							</div>
							<div class="form-group form-check">
								<input type="checkbox" class="form-check-input" id="exampleCheck1" name="rememberMe" >
								<label class="form-check-label" for="exampleCheck1">자동 로그인</label>
							</div>
							<button type="submit" class="btn btn-outline-primary">로그인</button>
						</form>
					</div>
					<!-- End Page Content container-fluid-->
				</div>
				<!-- End Content-->
			</div>
			<!-- End content-wrapper -->
			<c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
		</div>
		<!-- End wrapper -->
	</div>
	<c:import url="/WEB-INF/views/temp/footer_script.jsp"></c:import>
	<script>
		$(document).on('change', '.custom-file-input', function() {
			let fileName = $(this).val().split('\\').pop();
			$(this).next('.custom-file-label').html(fileName);
		});
	</script>
</body>
</html>