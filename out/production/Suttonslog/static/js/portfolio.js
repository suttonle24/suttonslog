(function ($) {
		   
	var initialPage = 'projects/' + $('.carousel-group:first-child').attr('data-contentPath');
	
	//Display the related content of the first item in the carousel.
	$('#content-frame').attr('src', initialPage);
	
	//Update content height when the content iframe has loaded
	if (!window.addEventListener) { //IE 8 patch
		window.attachEvent("message", function(event) {													
			$('#content-frame').height(event.data);
			$('#content-frame').removeClass('hidden');
		});
	}
	else {
		window.addEventListener("message", function(event) {													
			$('#content-frame').height(event.data);
			$('#content-frame').removeClass('hidden');
		});
	}
	
	//Recalculate carousel dimensions and maintain carousel position.
	function redrawCarousel() {		
		$('.carousel-window').attr('data-resize', true);
		$('.carousel').buildCarousel();
	}	
	
	$('.carousel').waitForImages(function () {
		$('.carousel').buildCarousel();
		$('.carousel-window').show();
	});
	
	//Whenever the window resizes, reset the carousel dimensions.
	var timer;
	$(window).bind("resize", function() {
		redrawCarousel();
	});
	
	//Create a nice cascading fade-in effect for body content
	$('.content').on('DOMSubtreeModified',function() {		
		if (!$('.content').hasClass('loaded')) {
			setTimeout(function() {
				$('.content').removeClass('hidden');
				$('header').addClass('visible');
			}, 250);
			setTimeout(function() {
				$('article').addClass('visible');
			}, 500);
			setTimeout(function() {
				$('footer').addClass('visible');
			}, 750);
			$(this).addClass('loaded');
		}
	});
	
	function initialContent() {
		setTimeout(function() {
			var contentPath = $('.carousel-group:first-child').attr('data-contentPath');	
			$.get('projects/' + contentPath, function(data)
				{
					$('.content').html(data);
				});
		}, 250);
	}
	
	//Show-hide functionality for the mobile nav.
	$('.nav-toggle').click(function () {
		var $navWrapper = $(this).parent();
		if ($navWrapper.hasClass('open')) {
			$navWrapper.removeClass('open');
		}
		else {
			$navWrapper.addClass('open');	
		}
	});	
	
	initialContent();
	
})(jQuery);