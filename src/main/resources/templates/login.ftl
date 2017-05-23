
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <title>论坛登录</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
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
		    	<input type="text" class="form-control" placeholder="输入用户名" onkeyup="this.value=this.value.replace(/[^\w_]/g,'');" v-model="loginInfo.username">
		        <br>
		        <input type="password" class="form-control" placeholder="输入密码" v-model="loginInfo.password">
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

	    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
	 
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.1.8/vue.min.js"></script>
	<script src="https://cdn.jsdelivr.net/vue.resource/1.0.3/vue-resource.min.js"></script>
	<script>
		Vue.http.options.emulateJSON = true;
		new Vue({
			el : '#loginform',
			data : {
				loginInfo : {
					username : '',
					password : ''
				},
				verifyCode : ''
			},
			methods : {
				confirm : function() {
					var that = this;
					alert(JSON.stringify(this.loginInfo));
					this.$http.post('/confirm-code', {'verifyCode' : this.verifyCode}).then((response) => {
                		if (response == 200) {
                			this.$http.jsonp('/user/login',JSON.stringify(that.loginInfo)).then((response) => {
                				alert(response);
            				});
                		} else {
                			alert('验证码输入错误');
                		}
            		});
				}
			}
		});
	</script>
  </body>
</html>
