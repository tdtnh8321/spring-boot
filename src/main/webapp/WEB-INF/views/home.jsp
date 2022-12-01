<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>


<link rel="stylesheet"
	href="<c:url value='/template/web/vendor/bootstrap/css/bootstrap.min.css' />" />


<link rel="stylesheet"
	href="<c:url value='/template/web/css/shop-homepage.css' />" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="/home">Project Third</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<c:if test="${USER != null }">
						<li class="nav-item active"><h4 class="nav-link">Hello:
								${USER.fullname}</h4></li>
						<li class="nav-item"><a class="nav-link" href="/user/logout">Logout</a></li>
					</c:if>
					<c:if test="${USER == null }">
						<li class="nav-item active"><a class="nav-link"
							href="/user/login">Login <span class="sr-only">(current)</span>
						</a></li>

						<li class="nav-item"><a class="nav-link"
							href="/user/register">Register</a></li>
					</c:if>


					<li class="nav-item"><a class="nav-link" href="/cart">Cart</a>
					</li>

				</ul>
			</div>
		</div>
	</nav>

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="col-lg-3">

				<h1 class="my-4">Tìm kiếm theo loại</h1>
				<div class="list-group">
					<a href="/home/selling" class="list-group-item">Sản phẩm bán chạy</a>
					<c:forEach var="item" items="${listCategory}">
						<p class="list-group-item"
							onclick="searchByCategory('${item.catagoryID}')">${item.catagoryID}
							${item.name}</p>
						
					</c:forEach>


				</div>

			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">

				<div id="carouselExampleIndicators" class="carousel slide my-4"
					data-ride="carousel">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="..."
							aria-label="....." aria-describedby="basic-addon2" id="search">
						<div class="input-group-append">
							<button class="btn btn-outline-secondary" type="button"
								onclick="search()">Tìm kiếm</button>
						</div>
					</div>
					
				</div>

				<div class="row">
					<c:forEach var="item" items="${listVegetable}">

						<div class="col-lg-4 col-md-6 mb-4">
							<div class="card h-100">
								<!-- Product image-->
								<img class="card-img-top"
									src="<c:url value='/images/${item.image }.jpg' />"
									alt="..." />
								<!-- Product details-->
								<div class="card-body p-4">
									<div class="text-center">
										<!-- Product name-->
										<h5 class="fw-bolder">
											<a href="/vegetable/${item.vegetableID}">${item.vegetableID}:
												${item.vegetableName}</a>
										</h5>
										<!-- Product price-->
										Giá bán: $ ${item.price}
									</div>
								</div>
								<!-- Product actions-->
								<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
									<div class="text-center">
										<button class="btn btn-outline-dark mt-auto"
											onclick="add(${item.vegetableID})">Thêm vào giỏ</button>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2019</p>
		</div>
		<!-- /.container -->
	</footer>
	<!-- Bootstrap core JavaScript -->

	<script
		src="<c:url value='/template/web/vendor/jquery/jquery.min.js' />"></script>
	<script
		src="<c:url value='/template/web/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>

	<script type="text/javascript">
		function search(){
			//console.log(window.location.href);
			var search = $("#search").val();
			if(search!=""){
				window.location.href="/home/search?keyword="+search+"";
			}
			
		}
		function searchByCategory(catagoryID){
			var href = window.location.href;
			if(href.includes("?")){
				if(href.includes("catagoryID")){
					href=href.slice(0,href.length-1)+catagoryID;

				}else{
					href+="&catagoryID="+catagoryID;
				}
				
			}else{
				href+="/search?catagoryID="+catagoryID;
		
			}
			window.location.href=href;
		}
		function add(id){
			$.get("/add/"+id+"/?qty=1",function(data,status){
				if(data==1){
					location.reload();
				}else{
					alert("Số lượng không đủ");
				}
			})
		}
	</script>
</body>
</html>