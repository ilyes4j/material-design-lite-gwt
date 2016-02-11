//to avoid polluting the global name space, gather all the utility
//functions of the demo project under the gwtmdldemo namespace.
var gwtmdldemo = (function() {

	// replace the input element with a resource.
	// The resource's url is located in the id attribute of the element
	var internalInject = function(element) {

		// setup the jquery object for the element
		var elt = $(element);

		// load the resource which url is located inside the id attribute
		// of the element.
		$.get(elt.attr("id"), function(data) {

			// replace the element with the loaded resource
			elt.replaceWith(data);
		});
	};

	// replace all elements with their corresponding resources
	var internalInjectAll = function() {

		// when the document is loaded
		$(document).ready(function() {

			// look for for all elements decorated with the inject css selector
			$(".inject").each(function(index, element) {

				// replace each element found with its associated resource
				internalInject(element);
			});
		});
	};

	// setup an object that exposes the utility methods
	return {
		inject : internalInject,
		injectAll : internalInjectAll
	};
})();

// replace all elements in the document with their associated resource
gwtmdldemo.injectAll();