<%@ page contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html lang="en">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<head>
	<title>Title</title>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
	<h1>session 会话管理 | 服务端渲染生成HTML发送给浏览器</h1>
	<h3>msg:{msg}</h3>
	<h3>id:${id}</h3>
	<a class="btn btn-primary" href="cart" role="button">${username} | 购物车 | <span
			class="badge badge-pill badge-danger">${cart.size()}</span></a>

	<!--注销作用:让会话失效，清除现在状态的数据-->
	<a class="btn btn-info" href="loginout" role="button">注销</a>

	<!-- 登录 -->
	<button type="button" class="btn btn-success" data-toggle="modal" data-target="#modelId">
		登录
	</button>

	<!-- Modal -->
	<div class="modal fade" id="modelId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<form action="login" method="post">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">登录界面</h5>
					</div>
					<div class="modal-body">
						<!--用户名-->
						<div class="form-group">
							<label for="">用户名</label>
							<input type="text" class="form-control" name="username" id="" aria-describedby="helpId"
								placeholder="输入用户名" required>

							<!--密码-->
							<label for="">密码</label>
							<input type="password" class="form-control" name="password" id="" aria-describedby="helpId"
								placeholder="输入密码" required pattern="\d{6}" maxlength="6">

						</div>
					</div>
					<div class="modal-footer">
						<button type="reset" class="btn btn-secondary" data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary" data-dismiss="modal">登录</button>
					</div>
			</form>
			<button @click="addCart(${p.id})" type="button" class="btn btn-primary">XHR加到购物车</button>
		</div>
	</div>
	</div>


	<hr>
	<table class="table">
		<thead>
			<tr>
				<th>商品编号</th>
				<th>商品名</th>
				<th>价格</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="p">
				<tr>
					<td scope="row">${p.id}</td>
					<td>${p.title}</td>
					<td>${p.price}</td>
					<td>
						<!--添加到购物车-->
						<!--表单的同步提交,全局更新,所有资源可能全部刷新或者从内存缓存中取,开销大,网络延时会出现闪动-->
						<!--XHR脚本异步提交,局部更新，-->
						<form action="cart" method="post">
							<!--隐藏的输入框/隐藏字段-->
							<input type="hidden" name="pid" value="${p.id}">
							<button type="submit" class="btn btn-primary">加入购物车</button>
						</form>
					</td>
				</tr>
				</tr>
			</c:forEach>

		</tbody>
	</table>


	<script>
		function addCart(id) {
			console.log(`addCart ${p.id}`);
			
			// JQuery, axios
			axios.post(`cart`,{
				id: id
			})
			.then(res => {
				// console.log(res);
			})
			.catch(err => {
				// console.error(err); 
			})
		}
	
	</script>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous">

	</script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">

	</script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">

	</script>
</body>

</html>