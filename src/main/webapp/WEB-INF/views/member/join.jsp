<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
							<h1 class="h3 mb-4 text-gray-800">회원가입 페이지</h1>
							<div class="join-container">
								<form action="./join" method="post" enctype="multipart/form-data">
									<div>
										<div class="input-group flex-nowrap">
											<div class="input-group-prepend">
												<span class="input-group-text">아이디</span>
											</div>
											<input type="text" class="form-control" id="username"
												placeholder="아이디를 입력하세요." name="username">
										</div>
									</div>
									<div id="result"></div>
									<div>
										<div class="input-group flex-nowrap">
											<div class="input-group-prepend">
												<span class="input-group-text">비밀번호</span>
											</div>
											<input type="password" class="form-control" id="password" placeholder="비밀번호를 입력하세요."
												name="password">
										</div>
									</div>
									<div id="pwdC">
										<div class="input-group flex-nowrap">
											<div class="input-group-prepend">
												<span class="input-group-text">비밀번호 확인</span>
											</div>
											<input type="password" class="form-control" placeholder="비밀번호를 입력하세요."
												id="passwordCheck" name="password">
										</div>
									</div>
									<div id="pwMsg"></div>
									<div>
										<div class="input-group flex-nowrap">
											<div class="input-group-prepend">
												<span class="input-group-text">이름</span>
											</div>
											<input type="text" class="form-control" placeholder="이름을 입력하세요."
												id="name" name="name">
										</div>
									</div>
									<div>
										<div class="input-group flex-nowrap">
											<div class="input-group-prepend">
												<span class="input-group-text">전화번호</span>
											</div>
											<input type="tel" class="form-control" placeholder="전화번호를 입력하세요."
												id="phone" name="phone">
										</div>
									</div>
									<div>
										<div class="input-group flex-nowrap">
											<div class="input-group-prepend">
												<span class="input-group-text" >이메일</span>
											</div>
											<input type="email" class="form-control" placeholder="이메일을 입력하세요."
												id="email" name="email">
										</div>
									</div>
									<div>
										<div class="input-group flex-nowrap">
											<div class="input-group-prepend">
												<span class="input-group-text" >생일</span>
											</div>
											<input type="date" class="form-control" name="birth" id="birth">
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
									<button type="button" class="btn btn-outline-primary" id="btn">회원가입</button>
								</form>
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
				$(document).on('change', '.custom-file-input', function () {
					let fileName = $(this).val().split('\\').pop();
					$(this).next('.custom-file-label').html(fileName);
				});
			</script>
			<script src="/js/member/join.js"></script>
		</body>

		</html>