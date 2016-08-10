(function ($) {
	var $body = $('body');

	/**
	 * Plugin for carousel layout and transitioning functionality.
	 */
	$.fn.buildCarousel = function (options) {
		var $carousel = $(this),
			currentGroup = 0,
			settings = $.extend({}, $.fn.buildCarousel.defaults, options),
			$carouselWindow = $('.' + settings.wrapperClass),
			$carouselGroup = $carousel.find('.' + settings.groupClass),
			$pager = $('.' + settings.pagerClass),
			groupCount = $carouselGroup.length,
			currentPage = $carouselWindow.attr('data-currentPage');
		
		/**
		 * Create paging tabs equal to the number of pages in the carousel
		 */
		function buildPaging($carouselWindow) {
			$pager.html('');
			$carouselGroup.each(function () {
				$pager.append('<div class="carousel-page"></div>');
			});

			$pager.css({
				'left': ($carouselWindow.width() / 2) - ($pager.width() / 2) + 'px'
			});

			setActivePage();
		}

		/**
		 * Set active paging tab
		 */
		function setActivePage() {
			var $carouselPage = $pager.find('.carousel-page');
			$carouselPage.each(function () {
				$(this).removeClass('current-page');
				if ($(this).index() == currentGroup) {
					$(this).addClass('current-page');
				}
			});
		}
		
		
		/**
		 * Set the width of the carousel wrapper to the total width of all groups.
		 */
		function setGroupWidth($carousel) {
			var groupWidth = 0,
				carouselWidth = $carouselWindow.width();
			$carouselGroup.each(function () {
				$(this).width(carouselWidth);
			});
		}


		/**
		 * Set the width of the carousel wrapper to the total width of all groups.
		 */
		function setCarouselWidth($carousel) {
			var carouselWidth = 0;
			$carouselGroup.each(function () {
				carouselWidth += $(this).innerWidth();
			});
			$carousel.width(carouselWidth);
		}

		/**
		 * Set the height of the carousel window to the height of the tallest content block.
		 */
		function setWindowHeight($carouselWindow) {
			var windowHeight = 0,
				groupHeight = 0;
			$carouselGroup.each(function () {
				var group = $(this);
				if (group.height() > groupHeight) {
					groupHeight = group.height();
				}
			});

			windowHeight = groupHeight - 4;

			$carouselWindow.height(windowHeight);
		}

		/**
		 * Slide the carousel to the left or to the right, respective to the control clicked.
		 */
		function toggleButtons() {
			var $carouselWindow = $('.' + settings.wrapperClass),
				$controls = $carouselWindow.find('.carousel-control');
			$controls.each(function () {
				if (currentGroup == 0) {
					$controls.removeClass('inactive');
					$carouselWindow.find('.carousel-left').addClass('inactive');
				}
				else if (currentGroup != 0 && currentGroup != groupCount - 1) {
					$controls.removeClass('inactive');
				}
				else {
					$controls.removeClass('inactive');
					$carouselWindow.find('.carousel-right').addClass('inactive');
				}
			});
			setActivePage();
		}

		/**
		 * Slide the carousel to the left or to the right, respective to the control clicked.
		 */
		function slideCarousel(direction) {
			var groupWidth = $carouselGroup.innerWidth(),
				currentPosition = 0;
			if (direction.hasClass(settings.moveLeftClass) && currentGroup >= 1) {
				currentGroup -= 1;
				currentPosition = currentGroup * groupWidth;
				$carousel.stop(true).animate({
					left: -(currentPosition),
					duration: 250
				});
				toggleButtons();
			}
			else if (direction.hasClass(settings.moveRightClass) && currentGroup <= groupCount - 2) {
				currentGroup += 1;
				currentPosition = currentGroup * groupWidth;
				$carousel.stop(true).animate({
					left: -(currentPosition),
					duration: 250
				});
				toggleButtons();
			}
		}

		/**
		 * Slide the carousel directly to the page clicked.
		 */
		function goDirectly($page) {
			var groupWidth = $carouselGroup.innerWidth()
				pageIndex = $page.index(),
				currentPosition = pageIndex * groupWidth;
			currentGroup = pageIndex;
			$carousel.stop(true).animate({
				left: -(currentPosition),
				duration: 250
			});
			setActivePage();
			toggleButtons();
		}
		
		/**
		 * Maintain carousel position upon window resize.
		 */
		function maintainPosition() {
			var currentPage = $pager.find('.carousel-page.current-page').index();			
			if (currentPage > 0) {
				var groupWidth = $carouselGroup.innerWidth()
					currentPage = $pager.find('.carousel-page.current-page').index() + 1,
					currentPosition = currentPage * groupWidth - groupWidth;
				currentGroup = currentPage;				
				currentPosition = '-' + currentPosition + 'px';				
				$carousel.css('left', currentPosition);
				//re-center the pager
				$pager.css({
					'left': ($carouselWindow.width() / 2) - ($pager.width() / 2) + 'px'
				});
			}	
			else {
				//re-center the pager
				$pager.css({
					'left': ($carouselWindow.width() / 2) - ($pager.width() / 2) + 'px'
				});
			}
		}

		/**
		 * Set up click handlers for the carousel controls.
		 */
		 //TODO - refactor portfolio content handling.
		function bindEvents($carousel) {

			// On click left
			$carouselWindow.find('.' + settings.moveLeftClass).on('click', function (e) {
				//hide portfolio content
				$('.content').addClass('hidden');
				
				slideCarousel($(this));
				
				//set appropriate portfolio content
				setTimeout(function() {
					$('.content').removeClass('loaded').addClass('hidden');
					var contentPath = $('.' + settings.groupClass + ':nth-child(' + (currentGroup + 1) + ')').attr('data-contentPath');
					$.get('projects/' + contentPath, function(data)
						{
							$('.content').html(data);
						});
				}, 250);
			});

			// On click right
			$carouselWindow.find('.' + settings.moveRightClass).on('click', function (e) {
				//hide portfolio content
				$('.content').addClass('hidden');
				
				slideCarousel($(this));
				
				//set appropriate portfolio content
				setTimeout(function() {
					$('.content').removeClass('loaded').addClass('hidden');
					var contentPath = $('.' + settings.groupClass + ':nth-child(' + (currentGroup + 1) + ')').attr('data-contentPath');	
					$.get('projects/' + contentPath, function(data)
						{
							$('.content').html(data);
						});
				}, 250);
			});

			//On click pagination
			$carouselWindow.find('.carousel-page').on('click', function (e) {
				//hide portfolio content
				$('.content').addClass('hidden');
				
				goDirectly($(this));
				
				//set appropriate portfolio content
				setTimeout(function() {
					$('.content').removeClass('loaded').addClass('hidden');
					var contentPath = $('.' + settings.groupClass + ':nth-child(' + (currentGroup + 1) + ')').attr('data-contentPath');	
					$.get('projects/' + contentPath, function(data)
						{
							$('.content').html(data);
						});
				}, 250);
			});

		}
		
		if ($carouselWindow.attr('data-resize') == 'true') {
			setGroupWidth($carouselWindow);
			setWindowHeight($carouselWindow);
			setCarouselWidth($carousel);
			maintainPosition();
		}
		else {
			buildPaging($carouselWindow);
			setGroupWidth($carouselWindow);
			setWindowHeight($carouselWindow);
			setCarouselWidth($carousel);
			toggleButtons();
			bindEvents($carousel);			
		}

	}

	/**
	* Set default values for the carousel plugin.
	*/
	$.fn.buildCarousel.defaults = {
		wrapperClass: 'carousel-window',
		groupClass: 'carousel-group',
		controlsClass: 'carousel-controls',
		pagerClass: 'carousel-pages',
		moveLeftClass: 'carousel-left',
		moveRightClass: 'carousel-right'
	};

})(jQuery);