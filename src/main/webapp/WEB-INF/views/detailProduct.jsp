<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail product</title>
<link rel="stylesheet"
	href="<c:url value='/template/web/vendor/bootstrap/css/bootstrap.min.css' />" />


<link rel="stylesheet"
	href="<c:url value='/template/web/css/shop-homepage.css' />" />


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
						<li class="nav-item active"><h4 class="nav-link">Hello: ${USER.fullname}

							</h4></li>
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
	<section class="py-1">
		<div class="container px-3 px-lg-4 my-4">
			<div class="row gx-4 gx-lg-5 align-items-center">
				<div class="col-md-6">
					 <img class="card-img-top mb-5 mb-md-0" src="<c:url value='/images/${data.image }.jpg' />" alt="..." />
				</div>
				<div class="col-md-6">
					<div class="small mb-1">Vegetable ID: ${data.vegetableID}</div>
					<h1 class="display-5 fw-bolder">${data.vegetableName }</h1>
					<div class="fs-5 mb-5">
						<span class="text-decoration-line-through">${data.price}$</span>

					</div>
					<p class="lead"></p>
					<div class="d-flex">
						<input class="form-control text-center me-3" id="inputQuantity"
							type="number" style="max-width: 3rem" />
						<button class="btn btn-outline-dark flex-shrink-0" type="button" onclick="add(${data.vegetableID})">
							<i class="bi-cart-fill me-1"></i> Thêm vào giỏ hàng
						</button>
					</div>
				</div>
			</div>
		</div>
	</section>
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
			var qty=$("#inputQuantity").val();
			console.log(qty);
			$.get({
				url : "/add/"+id+"?qty="+qty+"",
				
				success : function(rs) {
					if(rs==1){
						//location.reload();
					}else{
						alert("Số lượng không đủ");
					}
				},
				error : function(e) {
					console.log(e.responseText);

				}
			});
			
			
			
			
			
		}
		
	</script>
</body>
</html>