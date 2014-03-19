(function($) {
	$(document).ready(function() {
//		$(".dish-edit").click(function() {
//			var id  = $(this).attr("group-id");
//			var shopId = $(this).attr("shop-id");
//			getShopDetail(id, shopId).done(function(data) {
//				$("#group-form")[0].reset();
//				$('#myModalLabel').text("编辑菜品种类信息");
//				$('#group-form').attr("action", "group!update.action");
//				$('#submit').text("更新");
//				$('#id').val(data.id);
//				$('#name').val(data.name);
//				$('#myModal').modal('show');
//			});
//		});
		
		$("#add-dish").click(function() {
			$('#myModal').modal('show');
		});
		
		$("#upload").click(function() {
			$("#image-form").ajaxForm({
				success: function(result) {
					var img = $("<img />");
					var src = "upload/" + result;
					img.attr("id", "preview-img");
					img.attr("src", src);
					
					console.log(src);
					
					$("#file-group").append(img);
				}
			});
		});
		
	});
	
	function uploadImage() {
		var dfd = $.Deferred();
		var GROUP_DETAIL_ACTION = "group!get.action";
		$.ajax({
			  url: GROUP_DETAIL_ACTION,
			  type : "GET",
			  data : { 
				  id : id,
				  shopId : shopId		
			  },
			  success: function(data) {
				  dfd.resolve(data);
			  }
			});
			
		return dfd.promise();
	}
	
})(jQuery);