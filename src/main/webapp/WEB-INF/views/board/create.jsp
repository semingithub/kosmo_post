<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/temp/head_css.jsp"></c:import>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.css" rel="stylesheet">
</head>
<body id="page-top">
	<div id="wrapper">
		<c:import url="/WEB-INF/views/temp/sidebar.jsp"></c:import>
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<c:import url="/WEB-INF/views/temp/topbar.jsp"></c:import>
				<!-- Page Content  -->
				<div class="container-fluid">
					<h1 class="h3 mb-4 text-gray-800">create Page</h1>
					<button class="btn btn-primary" onclick="location.href='./list'">뒤로가기</button>
					<div class="row justify-content-center">
						<div class="col-8">
							<form action="./create" method="post" enctype="multipart/form-data">
								<div class="form-group">
									<label for="boardTitle">제목</label>
									<input type="text" class="form-control" id="boardTitle" name="boardTitle">
								</div>
								<div class="form-group">
									<label for="boardWriter">작성자</label>
									<input type="text" class="form-control" id="boardWriter" name="boardWriter">
								</div>
								<div class="form-group">
									<label for="boardContents">내용</label>
									<textarea rows="" cols="" name="boardContents" class="form-control" id="boardContents"></textarea>
								</div>
								<div>
									<button type="button" id="add">File ADD</button>
								</div>
								<div class="form-group" id="result">
									<label for="attach">첨부파일</label>
								</div>
								<button type="submit" class="btn btn-primary" id="create">Submit</button>
							</form>
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
	<script src="/js/board/form.js"></script>
	<c:import url="/WEB-INF/views/temp/footer_script.jsp"></c:import>
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.js"></script>
	<script>
		$('#boardContents').summernote({
			placeholder : ' ',
			tabsize : 2,
			height : 400
		});
	</script>
</body>
</html>