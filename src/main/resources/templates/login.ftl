
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <title>论坛登录</title>
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
		    <form id="loginform" class="bs-example bs-example-form" role="form">
		    	<input type="text" class="form-control" placeholder="输入用户名" v-model="UserLoginDTO.username">
		        <br>
		        <input type="text" class="form-control" placeholder="输入密码" v-model="UserLoginDTO.password">
		        <br>
		        <input type="text" class="form-control" placeholder="输入下面的验证码" v-model="verifyCode">
		        <br />
		        <div class="input" >
		            <img src="/code" class="input" />
		        </div>
		        <br>
		        <button @click.once="confirm" class="col-md-12 btn btn-success">登&nbsp;录</button>
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
	<script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.1.8/vue.min.js"></script>
	<script src="https://cdn.jsdelivr.net/vue.resource/1.0.3/vue-resource.min.js"></script>
	<script>
		var commitParam = {
			userLoginDTO : {
					username : '',
					password : ''
			},
			verifyCode : ''
		};
		new Vue({
			el : '#loginform',
			data : commitParam,
			methods : {
				confirm : function() {
					alert("hello");
					this.$http.post('/user/login',commitParam).then((response) => {
                		alert(response);
            		}, (error) => {
                		// error callback
            		});
				}
			}
		});
	</script>
  </body>
</html>
