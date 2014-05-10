(function($) {
	$(document).ready(function() {
		$(".user-edit").click(function() {
			var id  = $(this).attr("user-id");
			getShopDetail(id).done(function(data) {
				$("#user-form")[0].reset();
				$('#myModalLabel').text("编辑店铺信息");
				$('#user-form').attr("action", "user!update.action");
				$('#submit').text("更新");
				$('#id').val(data.id);
				$('#username').val(data.username);
				$('#role').find("option[value=" + data.role + "]").attr("selected", "selected");
				$('#myModal').modal('show');
			});
		});
		
		$("#add-user").click(function() {
			$("#user-form")[0].reset();
			$('#myModalLabel').text("添加用户");
			$('#user-form').attr("action", "user!add.action");
			$('#submit').text("添加");
			$('#id').val("");
			$('#myModal').modal('show');
		});
		
	});
	
	
	function getShopDetail(id) {
		var dfd = $.Deferred();
		var SHOP_DETAIL_ACTION = "user!get.action";
		$.ajax({
			  url: SHOP_DETAIL_ACTION,
			  type : "GET",
			  data : { id : id },
			  success: function(data) {
				  dfd.resolve(data);
			  }
			});
			
		return dfd.promise();
	}
	
})(jQuery);