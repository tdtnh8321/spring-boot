<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>
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
	<div class=" container-fluid my-5 ">
		<div class="row justify-content-center ">
			<div class="col-xl-10">
				<div class="card shadow-lg ">


					<div class="row justify-content-around">
						<div class="col-md-5">
							<div class="card border-0">
								<div class="card-header pb-0">
									<h2 class="card-title space ">Checkout</h2>
									<p class="card-text text-muted mt-4  space">SHIPPING
										DETAILS</p>
									<hr class="my-0">
								</div>
								<div class="card-body">
									<div class="row justify-content-between">
										<div class="col-auto mt-0">
											<p>
												<b></b>
											</p>
										</div>
										<div class="col-auto">
											<p>
												<b></b>
											</p>
										</div>
									</div>
									<div class="row mt-4">
										<div class="col">
											<p class="text-muted mb-2">PAYMENT DETAILS</p>
											<hr class="mt-0">
										</div>
									</div>
									<div class="form-group">
										<label for="NAME" class="small text-muted mb-1">Tên
											đầy đủ</label> <input type="text"
											class="form-control form-control-sm" name="NAME" id="NAME"
											aria-describedby="helpId" placeholder=""
											value="${USER.fullname}" readonly>
									</div>
									<!-- <div class="form-group">
										<label for="NAME" class="small text-muted mb-1">CARD
											NUMBER</label> <input type="text"
											class="form-control form-control-sm" name="NAME" id="NAME"
											aria-describedby="helpId" placeholder="4534 5555 5555 5555">
									</div> -->
									<div class="row no-gutters">
										<div class="col-sm-6 pr-sm-2">
											<div class="form-group">
												<label for="NAME" class="small text-muted mb-1">Địa
													chỉ</label> <input type="text" class="form-control form-control-sm"
													name="ADDRESS" id="ADDRESS" aria-describedby="helpId"
													placeholder="" value="${USER.address}" readonly>
											</div>
										</div>
										<div class="col-sm-6">
											<div class="form-group">
												<label for="NAME" class="small text-muted mb-1">Thành
													phố</label> <input type="text" class="form-control form-control-sm"
													name="CITY" id="CITY" aria-describedby="helpId"
													placeholder="" value="${USER.city }" readonly>
											</div>
										</div>
									</div>
									<div class="row mb-md-5">
										<div class="col">
											<div class="form-group">
												<label for="NOTE" class="small text-muted mb-1">Note</label> 
													<input type="text" class="form-control form-control-sm"
													name="NOTE" id="NOTE" aria-describedby="helpId"
													placeholder="Note...">
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-5">
							<div class="card border-0 ">
								<div class="card-header card-2">
									<p class="card-text text-muted mt-md-4  mb-2 space">
										Đơn hàng của bạn <span
											class=" small text-muted ml-2 cursor-pointer"></span>
									</p>
									<hr class="my-2">
								</div>
								<div class="card-body pt-0">
									<c:forEach var="item" items="${CART}">
										<div class="row  justify-content-between">
											<div class="col-auto col-md-7">
												<div class="media flex-column flex-sm-row">
													<img class=" img-fluid"
														src="<c:url value='/images/${item.image }.jpg' />"
														width="62" height="62">
													<div class="media-body  my-auto">
														<div class="row ">
															<div class="col-auto">
																<p class="mb-0">
																	<b>${item.vegetableName}</b>
																</p>
																<small class="text-muted"></small>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class=" pl-0 flex-sm-col col-auto  my-auto">
												<p class="boxed-1">${item.qty }</p>
											</div>
											<div class=" pl-0 flex-sm-col col-auto  my-auto ">
												<p>
													<b>${item.price * item.qty}</b>
												</p>
											</div>
										</div>
										<hr class="my-2">

									</c:forEach>


									<div class="row ">
										<div class="col">
											<div class="row justify-content-between">
												<div class="col-4">
													<p class="mb-1">
														<b>Tổng tiền</b>
													</p>
												</div>
												<div class="flex-sm-col col-auto">
													<p class="mb-1">
														<b>${CART_TOTAL_AMOUNT }</b>
													</p>
												</div>
											</div>
											<div class="row justify-content-between">
												<div class="col">
													<p class="mb-1">
														<b>Shipping</b>
													</p>
												</div>
												<div class="flex-sm-col col-auto">
													<p class="mb-1">
														<b>0 SEK</b>
													</p>
												</div>
											</div>
											<div class="row justify-content-between">
												<div class="col-4">
													<p>
														<b>Tổng tiền</b>
													</p>
												</div>
												<div class="flex-sm-col col-auto">
													<p class="mb-1">
														<b id="total">${CART_TOTAL_AMOUNT }</b>
													</p>
												</div>
											</div>
											<hr class="my-0">
										</div>
									</div>
									<div class="row mb-5 mt-4 ">
										<div class="col-md-7 col-lg-6 mx-auto">
											<button type="button" onclick="checkout()"
												class="btn btn-block btn-outline-primary btn-lg">Thanh
												toán</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
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
		var d = new Date();
		var date = d.getFullYear() + "-" + [ d.getMonth() + 1 ] + "-"
				+ d.getDate();
		var data = {};
		data["date"] = date;
		data["note"] = $("#NOTE").val();
		data["total"] = $("#total").text();
		function checkout() {
			$.ajax({
				type : "post",
				url : "/user/checkout",
				data : JSON.stringify(data),
				headers : {
					"Content-Type" : "application/json; charset=utf-8",
					"Accept" : "application/json; charset=utf-8",
				},
				success : function(rs) {
					if (rs == 1) {
						alert("Đặt hàng thành công");
						window.location.href = "/home";
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