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