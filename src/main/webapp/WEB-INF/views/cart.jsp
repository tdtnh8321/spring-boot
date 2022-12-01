<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
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
	<div class="container px-3 my-5 clearfix">
		<!-- Shopping cart table -->
		<div class="card">
			<div class="card-header">
				<h2>Giỏ hàng của bạn</h2>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered m-0">
						<thead>
							<tr>
								<!-- Set columns width -->
								<th class="text-center py-3 px-4" style="min-width: 300px;">Tên
									sản phẩm &amp; Chi tiết</th>
								<th class="text-right py-3 px-4" style="width: 150px;">Giá
									bán</th>
								<th class="text-center py-3 px-4" style="width: 220px;">Số
									lượng</th>
								<th class="text-right py-3 px-4" style="width: 150px;">Tổng
									tiền</th>
								<th class="text-center align-middle py-3 px-0"
									style="width: 40px;"><a href="#"
									class="shop-tooltip float-none text-light" title=""
									data-original-title="Clear cart"><i
										class="ino ion-md-trash"></i></a></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${CART}">
								<tr>
									<td class="p-3">
										<div class="media align-items-center">
											<img src="<c:url value='/images/${item.image }.jpg' />"
												class="d-block ui-w-10 ui-bordered mr-1"
												style="width: 100px" alt="">
											<div class="media-body">
												<a href="/vegetable/${item.vegetableID}"
													class="d-block text-dark">${item.vegetableID} :
													${item.vegetableName}</a>

											</div>
										</div>
									</td>
									<td class="text-right font-weight-semibold align-middle p-4">$
										${item.price}</td>
									<td class="align-middle p-4x ">
										<div class="d-flex">
											<button type="button" class="btn btn-primary"
												onclick="reduce(${item.vegetableID})">-</button>
											<input type="number" class="form-control text-center"
												value="${item.qty }" readonly>
											<button type="button" class="btn btn-primary"
												onclick="add(${item.vegetableID})">+</button>
										</div>

									</td>
									<td class="text-right font-weight-semibold align-middle p-4">$
										${item.price * item.qty}</td>
									<td class="text-center align-middle px-0"><button
											onclick="remove(${item.vegetableID})"
											class="shop-tooltip close float-none text-danger" title=""
											data-original-title="Remove">×</button></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
				<!-- / Shopping cart table -->

				<div
					class="d-flex flex-wrap justify-content-between align-items-center pb-4">
					<div class="mt-4">
						<!--<label class="text-muted font-weight-normal">Promocode</label>
                <input type="text" placeholder="ABC" class="form-control"> -->
					</div>
					<div class="d-flex">
						<div class="text-right mt-4 mr-5">
							<label class="text-muted font-weight-normal m-0">Tổng số
								sản phẩm</label>
							<div class="text-large">
								<strong>${CART_COUNT }</strong>
							</div>
						</div>
						<div class="text-right mt-4">
							<label class="text-muted font-weight-normal m-0">Tổng
								tiền</label>
							<div class="text-large">
								<strong class="d-flex">$ ${CART_TOTAL_AMOUNT }</strong>
							</div>
						</div>
					</div>
				</div>

				<div class="float-right">
					<a href="/home"
						class="btn btn-lg  btn-default md-btn-flat mt-2 mr-3">Tiếp tục
						mua hàng</a>
					<button onclick="checkout()" class="btn btn-lg btn-primary mt-2">Thanh
						toán</button>
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
		function reduce(id){
			$.get("/reduce/"+id,function(data,status){
				if(data==1){
					location.reload();
				}else if(data==0){
					alert("Giảm thất bại");
				}
				
			})
		}
		
		function remove(id){
			$.get("/remove/"+id,function(data,status){
				if(data==1){
					location.reload();
				}else if(data==0){
					alert("Xóa sản phẩm thất bại");
					
				}
				
			})
		}
		function checkout(){
			$.get("/checkout",function(data){
				if(data==1){
					window.location.href="/user/checkout";
				}else{
					alert("Hãy đăng nhập");
					window.location.href="/user/login";
				}
			})
		}
	</script>
</body>
</html>