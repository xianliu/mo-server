(function($) {
	$(document).ready(function() {
		$(".dish-edit").click(function() {
			var id = $(this).attr("dish-id");
			var goupId = $(this).attr("group-id");
			getDishDetail(id, goupId).done(function(data) {
				$("#dish-form")[0].reset();
				$('#myModalLabel').text("编辑菜品信息");
				$('#dish-form').attr("action", "dish!update.action");
				$('#submit').text("更新");
				$('#id').val(data.id);
				
				// show the image
				$("#preview-img").remove();
				var img = $("<img />");
				var src = "upload/" + data.imageName;
				img.attr("id", "preview-img");
				img.attr("src", src);
				$("#file-group").append(img);
				
				$("#imageName").val(data.imageName);
				$('#name').val(data.name);
				$('#price').val(data.price);
				$('#myModal').modal('show');
			});
		});
		
		$("#add-dish").click(function() {
			$("#dish-form")[0].reset();
			$('#myModalLabel').text("添加菜品信息");
			$('#dish-form').attr("action", "dish!add.action");
			$('#submit').text("添加");
			$('#id').val(-1);
			
			// remove the image
			$("#preview-img").remove();
			
			$("#imageName").val("");
			$('#name').val("");
			$('#price').val("");
			$('#myModal').modal('show');
		});
		
		$("#upload").click(function() {
			$("#image-form").ajaxForm({
				success: function(result) {
					$("#preview-img").remove();
					var img = $("<img />");
					var src = "upload/" + result;
					img.attr("id", "preview-img");
					img.attr("src", src);
					
					$("#imageName").val(result);
					$("#file-group").append(img);
				}
			});
		});
		
	});
	
	function getDishDetail(id, groupId) {
		var dfd = $.Deferred();
		var DISH_DETAIL_ACTION = "dish!get.action";
		$.ajax({
			  url: DISH_DETAIL_ACTION,
			  type : "GET",
			  data : { 
				  id : id,
				  groupId : groupId		
			  },
			  success: function(data) {
				  dfd.resolve(data);
			  }
			});
			
		return dfd.promise();
	}
	
})(jQuery);