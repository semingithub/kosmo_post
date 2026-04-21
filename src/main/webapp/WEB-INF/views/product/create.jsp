<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="/WEB-INF/views/temp/head_css.jsp"></c:import>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.css" rel="stylesheet">
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
						<h1>상품 추가 페이지</h1>
						<button type="button" class="btn btn-dark" onclick="location.href='./list'">뒤로가기</button>
						<div class="row justify-content-center">
							<div class="col-5">
								<form action="./create" method="post" enctype="multipart/form-data">
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text" id="basic-addon1">상품 이름</span>
										</div>
										<input type="text" class="form-control" placeholder="이름을 입력하세요." name="productName">
									</div>
									<div class="form-group">
										<label for="contents">상품 내용</label>
										<textarea rows="" cols="" name="productContents" class="form-control" id="contents"></textarea>
									</div>
									<div class="form-row">
										<div class="col-md-6">
											<div class="input-group mb-3">
												<div class="input-group-prepend">
													<label class="input-group-text">상품 종류</label>
												</div>
												<select class="custom-select" name="productType">
													<option value="예금">예금</option>
													<option value="적금">적금</option>
													<option value="대출">대출</option>
													<option value="연금">연금</option>
												</select>
											</div>
										</div>
										<div class="col-md-6">
											<div class="input-group mb-3">
												<div class="input-group-prepend">
													<span class="input-group-text">상품 이율</span>
												</div>
												<input type="text" class="form-control" name="productRate" placeholder="이율 입력">
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text">상품 이미지</span>
											</div>

											<div class="custom-file">
												<input type="file" name="attach" class="custom-file-input" id="attach">
												<label class="custom-file-label" for="attach">파일 선택</label>
											</div>
										</div>
									</div>
									<button type="submit" class="btn btn-dark">추가</button>
								</form>
							</div>
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
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.js"></script>
	<script>
		$('#contents').summernote({
			placeholder : ' ',
			tabsize : 2,
			height : 300
		});
	</script>
	<script>
		$(document).on('change', '.custom-file-input', function() {
			let fileName = $(this).val().split('\\').pop();
			$(this).next('.custom-file-label').html(fileName);
		});
	</script>
	<c:import url="/WEB-INF/views/temp/footer_script.jsp"></c:import>
</body>
</html>