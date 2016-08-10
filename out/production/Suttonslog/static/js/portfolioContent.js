(function ($) {		   
	
	
	//Send the initial body height to the parent on load.
	$('body').waitForImages(function () {
		parent.postMessage($('body').height(), '*');
	});	
	
	//Create a nice cascading fade-in effect for body content
	setTimeout(function() {
		$('header').addClass('visible');
	}, 250);
	setTimeout(function() {
		$('article').addClass('visible');
	}, 500);
	setTimeout(function() {
		$('footer').addClass('visible');
	}, 750);
	
	//Function to send body height to parent on window resize.
	function resizeWindow () {
		parent.postMessage($('body').height(), '*');
	}
	
	//When the window resizes, call the resizeWindow function
	$(window).bind("resize", resizeWindow);		
	
})(jQuery);