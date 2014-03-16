(function($) {
	$(document).ready(function() {
		$(".shop-edit").click(function() {
			var id  = $(this).attr("id");
			getShopDetail(id).done(function(data) {
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
				  console.log(data);
			  }
			});
			
		return dfd.promise();
	}
	
})(jQuery);