(function($) {
	$(document).ready(function() {
		$(".news-edit").click(function() {
			var id = $(this).attr("news-id");
			getNewsDetail(id).done(function(data) {
				$("#news-form")[0].reset();
				$('#myModalLabel').text("编辑新闻公告");
				$('#news-form').attr("action", "news!update.action");
				$('#submit').text("更新");
				$('#id').val(data.id);
				$("#title").val(data.title);
				$('#content').val(data.content);
				$('#myModal').modal('show');
			});
		});
		
		$("#add-news").click(function() {
			$("#news-form")[0].reset();
			$('#myModalLabel').text("添加新闻公告");
			$('#news-form').attr("action", "news!add.action");
			$('#submit').text("添加");
			$('#id').val(-1);
			
			$("#title").val("");
			$('#content').val("");
			$('#myModal').modal('show');
		});
		
	});
	
	function getNewsDetail(id) {
		var dfd = $.Deferred();
		var NEWS_DETAIL_ACTION = "news!get.action";
		$.ajax({
			  url: NEWS_DETAIL_ACTION,
			  type : "GET",
			  data : { 
				  id : id
			  },
			  success: function(data) {
				  dfd.resolve(data);
			  }
			});
			
		return dfd.promise();
	}
	
})(jQuery);