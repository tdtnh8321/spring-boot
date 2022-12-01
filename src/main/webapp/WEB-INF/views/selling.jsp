<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Selling</title>

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

	<div class="container mx-auto">
		<div class="row mx-auto">
			<h1 class="w-100 text-center">Sản phẩm bán chạy</h1>
		</div>
		<div class="row mx-auto">

			<div class="col-lg-12">
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
										<h3 class="text-danger">HOT!!!</h3>
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

	<script
		src="<c:url value='/template/web/vendor/jquery/jquery.min.js' />"></script>
	<script
		src="<c:url value='/template/web/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>

	<script type="text/javascript">

		function add(id){
			$.get("/add/"+id+"?qty=1",function(data,status){
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