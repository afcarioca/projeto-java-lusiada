<%@ attribute name="id" required="true" %>

<input type="text" id="${id }" name="${id }"/>
<script type="text/javascript">
	$(function(){
		$("#${id}").datepicker({
			dateFormat: "MM/dd/yyyy"
				
			});
	});
	
</script>