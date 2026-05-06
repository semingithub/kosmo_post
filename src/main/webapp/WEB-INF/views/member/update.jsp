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
	margin: 50px auto;
	/* 위아래 여백 */
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
					<h1 class="h3 mb-4 text-gray-800">회원정보 수정 페이지</h1>
					<div class="join-container">
						<form:form method="post" modelAttribute="memberDTO" enctype="multipart/form-data">
							<div>
								<div class="input-group flex-nowrap">
									<div class="input-group-prepend">
										<span class="input-group-text">이름</span>
									</div>
									<form:input path="name" cssClass="form-control" id="name" />
								</div>
								<form:errors path="name"></form:errors>
							</div>
							<div>
								<div class="input-group flex-nowrap">
									<div class="input-group-prepend">
										<span class="input-group-text">전화번호</span>
									</div>
									<form:input path="phone" cssClass="form-control" id="phone" />
								</div>
								<form:errors path="phone"></form:errors>
							</div>
							<div>
								<div class="input-group flex-nowrap">
									<div class="input-group-prepend">
										<span class="input-group-text">이메일</span>
									</div>
									<form:input path="email" cssClass="form-control" id="email" />
								</div>
								<form:errors path="email"></form:errors>
							</div>
							<div>
								<div class="input-group flex-nowrap">
									<div class="input-group-prepend">
										<span class="input-group-text">생일</span>
									</div>
									<input type="date" class="form-control" name="birth" id="birth" value="${memberDTO.birth}">
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text">프로필 사진</span>
									</div>

									<div class="custom-file">
										<input type="file" name="attach" class="custom-file-input" id="attach">
										<label class="custom-file-label" for="attach">파일 선택</label>
									</div>
								</div>
							</div>
							<button type="submit" class="btn btn-outline-primary" id="btn">정보수정</button>
						</form:form>
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
	<script>
		$(document).on('change', '.custom-file-input', function() {
			let fileName = $(this).val().split('\\').pop();
			$(this).next('.custom-file-label').html(fileName);
		});
	</script>
	<!-- <script src="/js/member/join.js"></script> -->
</body>

</html>