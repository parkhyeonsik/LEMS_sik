<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>


  <!-- Control Sidebar -->
  <!-- /.control-sidebar -->

  <!-- Main Footer -->
<!-- ./wrapper -->



<!-- jQuery -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/dist/js/adminlte.min.js"></script>
<!-- common.js  -->
<script src="<%=request.getContextPath() %>/resources/js/common.js"></script>
<!-- overlayScrollbars -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/pages/dashboard2.js"></script>
	
<!-- handlebars  -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<script type="text/x-handlebars-template"  id="subMenu-list-template" >
{{#each .}}		
<li class="nav-item subMenu" >
	<a href="javascript:goPage('<%=request.getContextPath() %>{{murl}}','{{mcode}}');"	class="nav-link">
		<i class="{{micon}}" style="margin-left:0.2vw;"></i>
		<p>{{mname}}</p>
	</a>
</li>
{{/each}}
</script>


<script>
	var sub_func= Handlebars.compile($("#subMenu-list-template").html());
</script>


<script>
function subMenu_go(mCode){
	//alert(mCode);
	if(mCode=="M000000") {
		$('.subMenuList').html("");
		return;
	}
	
	$.ajax({
		url:"<%=request.getContextPath()%>/subMenu.do?mCode="+mCode,
		method:"get",
		success:function(data){
			//zconsole.log(data);		
			$('.subMenuList').html(sub_func(data));
		}
	});
}

function goPage(url,mCode){
	
	$('iframe[name="ifr"]').attr("src",url);

	 var renewURL = location.href;
    //현재 주소 중 .do 뒤 부분이 있다면 날려버린다.
    renewURL = renewURL.substring(0, renewURL.indexOf(".do")+3);
    
    if (mCode != 'M000000') {
        renewURL += "?mCode="+mCode;
    }
    //페이지를 리로드하지 않고 페이지 주소만 변경할 때 사용
    history.pushState(mCode, null, renewURL);
}

goPage('<%=request.getContextPath()%>${menu.murl}','${menu.mcode}');
subMenu_go('${menu.mcode}'.substring(0,3)+"0000");
</script>

 <script>
	  $("a#dark_mode").click(function(){
		  
		  var ifram_body = $($("iframe[name='ifr']").get(0).contentDocument.body);
		  //alert(ifram_body.hasClass("dark-mode"));
		  
	      if (!$("body").hasClass("dark-mode")){
	    	  $("body").addClass("dark-mode");
	    	  ifram_body.addClass("dark-mode");
	          $("#darkmode_icon").removeClass("fa-sun");
	          $("#darkmode_icon").addClass("fa-moon");
	      } else{
	    	  $("body").removeClass("dark-mode");
	    	  ifram_body.removeClass("dark-mode");
	          $("#darkmode_icon").removeClass("fa-moon");
	          $("#darkmode_icon").addClass("fa-sun");
	      }
	  });
</script>

</body>
</html>

