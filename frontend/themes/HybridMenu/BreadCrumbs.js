const customStyle = document.createElement('template');

customStyle.innerHTML = `
	<custom-style>
      <style>
		.hmBreadcrumbs {
    		padding: 3px 20px;
		}
		
		.hmBreadcrumbs label > iron-icon {
    		height: 100% !important;
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
	  	:host([theme~="bcButton"]){
	    	color: var(--lumo-contrast-90pct);
    		background: transparent;
    		
    	}
	  	  	
	  	:host([theme~="bcButton"]):not(.clickable):hover::before {
    		background: transparent !important;
		}
		
		:host([theme~="bcButton"]):not(.clickable)::before {
    		background: transparent !important;
		}
	  	  	
	  	:host([theme~="bcButton"]):host(.clickable){
	  	 	cursor: pointer;
	  	}
	  	
	   </style>
	 </template>`;

domStyleElement.register('BreadCrumbs'); 