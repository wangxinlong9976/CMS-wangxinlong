<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<hr />
	<div class="row">
		<div class="col-2">
			<label>
				用户Id:
			</label>
		</div>
		<div class="col-9">
			<input type="text" class="form-control" readonly value="${user.id}"/>
		</div>
	</div>
	
	<div class="row">
		<div class="col-2">
			<label>
				用户名:
			</label>
		</div>
		<div class="col-9">
			<input type="text" class="form-control" readonly value="${user.username}"/>
		</div>
	</div>
	
	<div class="row">
		<div class="col-2">
			<label>
				密码:
			</label>
		</div>
		<div class="col-9">
			<input type="text" class="form-control" readonly value="${user.password}"/>
		</div>
	</div>
	
	<div class="row">
		<div class="col-2">
			<label>
				昵称:
			</label>
		</div>
		<div class="col-9">
			<input type="text" class="form-control" readonly value="${user.nickname}"/>
		</div>
	</div>
	
	<div class="row">
		<div class="col-2">
			<label>
				生日:
			</label>
		</div>
		<div class="col-9">
			<input type="text" class="form-control" readonly value="${user.birthday}"/>
		</div>
	</div>
	
	<div class="row">
		<div class="col-2">
			<label>
				性别:
			</label>
		</div>
		<div class="col-9">
			<input type="text" class="form-control" readonly value="${user.gender==1?'男':'女'}"/>
		</div>
	</div>
	
	<div class="row">
		<div class="col-2">
			<label>
				状态:
			</label>
		</div>
		<div class="col-9">
			<input type="text" class="form-control" readonly value="${user.gender==1?'禁用':'启用'}"/>
		</div>
	</div>
	<div class="row">
		<div class="col-2">
			<label>
				注册时间:
			</label>
		</div>
		<div class="col-9">
			<input type="text" class="form-control" readonly value="${user.create_time}"/>
		</div>
	</div>
	
	<div class="row">
		<div class="col-2">
			<label>
				最近登陆:
			</label>
		</div>
		<div class="col-9">
			<input type="text" class="form-control" readonly value="${user.update_time}"/>
		</div>
	</div>
	
	<div class="row">
		<div class="col-2">
			<label>
				个人链接:
			</label>
		</div>
		<div class="col-9">
			<input type="text" class="form-control" readonly value="${user.url}"/>
		</div>
	</div>
	
	<div class="row">
		<div class="col-2">
			<label>
				积分:
			</label>
		</div>
		<div class="col-9">
			<input type="text" class="form-control" readonly value="${user.score}"/>
		</div>
	</div>
	
	<div class="row">
		<div class="col-2">
			<label>
				角色:
			</label>
		</div>
		<div class="col-9">
			<input type="text" class="form-control" readonly value="${user.role==1?'管理员':'普通用户'}"/>
		</div>
	</div>
	
	<div class="row">
		<div class="col-9"></div>
		<div class="col-2">
			<input type="button" class="btn btn-primary form-control" value="返回" onclick="back()"/>
		</div>
	</div>
<script type="text/javascript">
	
</script>