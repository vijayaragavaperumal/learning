/*Remove the adds element STRAT*/

/*var addId = document.querySelector('[id^="google_ads_"]');
addId && addId.remove();*/

	document.querySelectorAll('[id^="google_ads_"]').forEach(function(element){
		element.remove();
	});

/*Remove the adds element END*/

/*HIDE the adds element through inject the css using javascript (inline css) START*/
var style = document.createElement('style');
style.innerHTML =
	'.some-element {' +
		'color: purple;' +
		'background-color: #e5e5e5;' +
		'height: 150px;' +
	'}'+
	'[id^="google_ads_"] {'+
		'display: none;' +
	'}'+
'[id^="taboola-"] {'+
		'display: none;' +
	'}';
	
var ref = document.querySelector('script');
ref.parentNode.insertBefore(style, ref);
/*HIDE the adds element through inject the css using javascript (inline css) END*/


