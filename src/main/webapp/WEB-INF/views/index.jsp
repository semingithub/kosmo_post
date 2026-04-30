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
					<h1 class="h3 mb-4 text-gray-800">Blank Page</h1>
					<c:if test="${not empty member}">
						<h3>로그인 상태</h3>
					</c:if>
					<c:if test="${empty member}">
						<h3>비로그인 상태</h3>
					</c:if>
					<!-- End Page Content container-fluid-->
				</div>
				<div id="map" style="width: 500px; height: 400px;"></div>
				<!-- End Content-->
			</div>
			<c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
			<!-- End content-wrapper -->
		</div>
		<!-- End wrapper -->
	</div>
	<c:import url="/WEB-INF/views/temp/footer_script.jsp"></c:import>
	<script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=8718278b1ae57e3d4c204aad5927d12a"></script>
	<script>
		kakao.maps.load(function() {

			var container = document.getElementById('map');

			var options = {
				center : new kakao.maps.LatLng(33.450701, 126.570667),
				level : 3
			};

			var map = new kakao.maps.Map(container, options);

		});
	</script>
</body>
</html>