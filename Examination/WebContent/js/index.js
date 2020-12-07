$(document).ready(function(){
	$('#btn-insert-questions').click(function(){
		$('#profile-container').hide();
		$('#update-insert-form').show();
		$('#btn-insert-submit').show();
		$('#btn-update-submit').hide();
		$('#insert-form-heading').show();
		$('#update-form-heading').hide();
		$('#btn-insert-questions').attr("disabled", true);
//		$('#update-form').hide();
	});
	
	$('#close-form').click(function(){
		$('#update-insert-form').hide();
		$('#btn-insert-submit').hide();
		$('#btn-update-submit').hide();
		$('#insert-form-heading').hide();
		$('#update-form-heading').hide();
		$('#btn-insert-questions').attr("disabled", false);
		$('#btn-update-questions').attr("disabled", false);
	});
	
	$('#btn-update-questions').click(function(){
//		$('#update-form').toggle();
//		$('#insert-form').hide();
		$('#profile-container').hide();
		$('#update-insert-form').show();
		$('#btn-insert-submit').hide();
		$('#btn-update-submit').show();
		$('#insert-form-heading').hide();
		$('#update-form-heading').show();
		$('#btn-update-questions').attr("disabled", true);
	});
	
	
	
	$('#txtNewUsername').on("input",function() {
		var newUsername = $("#txtNewUsername").val().trim();
		var oldUsername = $("#txtUsername").val().trim();
		var newPassword = $("#txtNewPassword").val().trim();
		console.log(newPassword);
		var oldPassword = $("#txtPassword").val().trim();
		if (newUsername != "" && newUsername && newUsername != oldUsername){
			$('#btn-profile-submit').show();
		}else if((newUsername == oldUsername && oldPassword == newPassword) || (!newPassword && !newUsername) || (newUsername == oldUsername && !newPassword) || (oldPassword == newPassword && !newUsername)){
			$('#btn-profile-submit').hide();
		}else{
			$('#btn-profile-submit').show();
		}
	});
	
	$('#txtNewPassword').on("input",function() {
		var newUsername = $("#txtNewUsername").val().trim();
		var oldUsername = $("#txtUsername").val().trim();
		var newPassword = $("#txtNewPassword").val().trim();
		var oldPassword = $("#txtPassword").val().trim();
		if (newPassword != "" && newPassword && newPassword != oldPassword){
			$('#btn-profile-submit').show();
		}else if((newUsername == oldUsername && oldPassword == newPassword) || (!newPassword && !newUsername) || (newUsername == oldUsername && !newPassword) || (oldPassword == newPassword && !newUsername)){
			$('#btn-profile-submit').hide();
		}else{
			$('#btn-profile-submit').show();
		}
	});
	
	$('#btn-profile-hide').click(function() {
		$('#profile-container').hide();
		
	});
	$('#btn-profile-show').click(function() {
		$('#profile-container').show();
		$('#update-insert-form').hide();
		$('#btn-insert-submit').hide();
		$('#btn-update-submit').hide();
		$('#insert-form-heading').hide();
		$('#update-form-heading').hide();
		$('#btn-insert-questions').attr("disabled", false);
		$('#btn-update-questions').attr("disabled", false);
	});
	
	
});

