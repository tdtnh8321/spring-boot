<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>

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
					<li class="nav-item active"><a class="nav-link"
						href="/user/login">Login <span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="/user/register">Register</a></li>
					<li class="nav-item"><a class="nav-link" href="/cart">Cart</a>
					</li>

				</ul>
			</div>
		</div>
	</nav>


	<section class="vh-120" style="background-color: #eee;">
		<div class="container h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-12 col-xl-11">
					<div class="card text-black" style="border-radius: 25px;">
						<div class="card-body p-md-5">
							<div class="row justify-content-center">
								<div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

									<p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Đăng ký</p>

									<div>
										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-user fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="text" id="fullname" class="form-control" /> <label
													class="form-label" for="fullname">Tên đầy đủ</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="text" id="username" class="form-control" /> <label
													class="form-label" for="username">Tên đăng nhập</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-lock fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="password" id="password" class="form-control" />
												<label class="form-label" for="password">Mật khẩu</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-key fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="password" id="repeatpassword"
													class="form-control" /> <label class="form-label"
													for="repeatpassword">Nhập lại mật khẩu</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-key fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="text" id="address" class="form-control" /> <label
													class="form-label" for="address">Địa chỉ</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-key fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="text" id="city" class="form-control" /> <label
													class="form-label" for="city">Thành phố</label>
											</div>
										</div>


										<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
											<button class="btn btn-primary btn-lg" onclick="register()">Đăng ký</button>
										</div>

									</div>

								</div>
								<div
									class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

									<img
										src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
										class="img-fluid" alt="Sample image">

								</div>
							</div>
						</div>
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
		function register() {
			let fullname = $("#fullname").val();
			let username = $("#username").val();
			let password = $("#password").val();
			let repeatpassword = $("#repeatpassword").val();
			let address = $("#address").val();
			let city = $("#city").val();
			let data = {};

			data["username"] = username;
			data["password"] = password;
			data["repeatPassword"] = repeatpassword;
			data["fullname"] = fullname;
			data["address"] = address;
			data["city"] = city;
			console.log(data);
			$.ajax({
				type : "post",
				url : "/user/register",
				data : JSON.stringify(data),
				headers : {
					"Content-Type" : "application/json; charset=utf-8",
					"Accept" : "application/json; charset=utf-8",
				},
				success : function(rs) {
					var result="";
					if(rs==0){
						result="Password and Repeat Password must be same!!!";
					}else if(rs==1){
						result="Không được để trống";
					}else if(rs==2){
						result="Tên đăng nhập đã tồn tại";
					}else if(rs==3){
						result="Đăng ký thành công";
					}
					alert(result);
				},
				error : function(e) {
					console.log(e.responseText);

				}

			});
		}
	</script>
</body>
</html>