(function($) {
	$(document).ready(function() {
		$(".shop-edit").click(function() {
			var id  = $(this).attr("shop-id");
			getShopDetail(id).done(function(data) {
				$("#shop-form")[0].reset();
				$('#myModalLabel').text("编辑店铺信息");
				$('#shop-form').attr("action", "shop!update.action");
				$('#submit').text("更新");
				$('#id').val(data.id);
				$('#name').val(data.name);
				$('#location').val(data.location);
				$('#owner').val(data.owner);
				$('#myModal').modal('show');
			});
			
		});
		
		$("#add-shop").click(function() {
			$("#shop-form")[0].reset();
			$('#myModalLabel').text("添加店铺");
			$('#shop-form').attr("action", "shop!add.action");
			$('#submit').text("添加");
			$('#id').val("");
			$('#myModal').modal('show');
		});
		
	});
	
	
	function getShopDetail(id) {
		var dfd = $.Deferred();
		var SHOP_DETAIL_ACTION = "shop!get.action";
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