
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <title>论坛注册</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
	<link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
 	<style>
 		.loginform {
 			width: 500px;
 			margin: 100px auto;
 			padding: 100px 100px;
 			text-align: center;
 			background: url();
 		}
 	</style>
  </head>

  <body>

    <div class="container">
		<div class="loginform table-bordered">
		    <form class="bs-example bs-example-form" role="form" action="/user/register" method="post">
		    	<input type="text" class="form-control" placeholder="这里输入用户名" name="username">
		    	<br>
		        <input type="text" class="form-control" placeholder="首次输入密码" name="password">
		        <br>
		        <input type="text" class="form-control" placeholder="再次确认密码" name="confirmPassword">
		        <br>
		        <input type="text" class="form-control" placeholder="说说你的昵称" name="password">
		        <br>
		        <input type="text" class="form-control" placeholder="输入下面的验证码">
		        <br />
		        <div class="input" >
		            <img src="/code" class="input" />
		        </div>
		        <br>
		        <input type="submit" class="col-md-12 btn btn-success" value="一键注册"/>
		        <br>
		    </form>
		</div>
	</div>

	<!-- 可选的Bootstrap主题文件（一般不使用） -->
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>
	    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	 
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </body>
</html>
