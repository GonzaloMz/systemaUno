function newOptionForMenu(menuName, optionInputType){
	var newOption=$('#new_'+menuName).val();
	$.ajax({
		url:"newOptionForMenu/"+menuName+'/'+newOption
		, type: "post"
		}).done(function(){
			$('div#'+menuName).prepend(
				$('<label/>').attr('for', newOption).html(newOption)
				);
			$('div#'+menuName).prepend(
				$('<input/>')
					.attr({
						type: optionInputType
						, id: newOption
						, value: newOption
						, name: menuName
						})
				);
			$('#new_'+menuName).val('');
			});
}
