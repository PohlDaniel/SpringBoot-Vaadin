import '@polymer/polymer/lib/elements/dom-module.js';

const customStyle = document.createElement('template');

customStyle.innerHTML = `
	<custom-style>
      <style>
		.subMenu {
    		width: 100%;
    		margin: 0;
		}
				
		.subMenu > vaadin-vertical-layout {
    		-webkit-transition: max-height 0.5s ease-in-out;
			-moz-transition: max-height 0.5s ease-in-out;
			-ms-transition: max-height 0.5s ease-in-out;
			-o-transition: max-height 0.5s ease-in-out;
			transition: max-height 0.5s ease-in-out;
			width: calc(100% - 24px) !important;
			border-left: 1px solid var(--lumo-shade-10pct);
			position: relative;
			margin-left: 24px;
			overflow: hidden;
			display: block;
			max-height: 0;
		}
		
		.subMenu.open > vaadin-vertical-layout {
			max-height: 500px;
		}
		
		
      </style>
    </custom-style>`;

document.head.appendChild(customStyle.content);

const domStyleElement = document.createElement('dom-module');
domStyleElement.setAttribute('theme-for', 'vaadin-button');

domStyleElement.innerHTML = 
	 `<template>
	   <style>
	   
	  	/*rotate the arrow icon */
	  	:host([theme~="smButton"]):host(.leftMenuItem.active) .vaadin-button-container div[part="suffix"] {
	    	-webkit-transform: rotate(-180deg);
			-moz-transform: rotate(-180deg);
			-ms-transform: rotate(-180deg);
			-o-transform: rotate(-180deg);
			transform: rotate(-180deg);
			padding-bottom: 3px;
    	}
	  	  	
	   </style>
	 </template>`;

domStyleElement.register('SubMenu'); 