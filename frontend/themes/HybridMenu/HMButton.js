import '@polymer/polymer/lib/elements/dom-module.js';

const customStyle = document.createElement('template');

customStyle.innerHTML = `
	<custom-style>
      <style>
		[theme~="dark"] {
      		--background: var(--lumo-tint-5pct);
      		--color : var(--lumo-tint-90pct);
		}
		
      </style>
    </custom-style>`;

document.head.appendChild(customStyle.content);


const domStyleElement = document.createElement('dom-module');
domStyleElement.setAttribute('theme-for', 'vaadin-button');

domStyleElement.innerHTML = 
	 `<template>
   
	   <style>

		:host([theme~="hmButton"]) {
			background: var(--lumo-tint-20pct);
    		-webkit-transition: background 0.3s ease-in-out, border-left-color 0.3s ease-in-out, border-left-width 0.3s ease-in-out;
			-moz-transition: background 0.3s ease-in-out, border-left-color 0.3s ease-in-out, border-left-width 0.3s ease-in-out;
			-ms-transition: background 0.3s ease-in-out, border-left-color 0.3s ease-in-out, border-left-width 0.3s ease-in-out;
			-o-transition: background 0.3s ease-in-out, border-left-color 0.3s ease-in-out, border-left-width 0.3s ease-in-out;
			transition: background 0.3s ease-in-out, border-left-color 0.3s ease-in-out, border-left-width 0.3s ease-in-out;
			padding: 8px 0 8px 10px !important;
			color: var(--lumo-contrast-90pct);
    		border-left: 0 solid var(--lumo-primary-color);
    		height: 45px;
    		width: 100%;
    		padding: 0;
    		margin: 0;
	 		border-radius: 0;
    		cursor: pointer;   		
		}
	
		:host([theme~="hmButton"]:hover) {
			background:  var(--lumo-shade-5pct) !important;
			border-left-color: rgba(25, 118, 210, 1.0);	
			border-left-width: 5px !important;
		}
		
		
	  	:host([theme~="hmButton"]) {
			background: var(--background);
			color: var(--color);		
		}
	 	  	
	  	:host([theme~="hmButton"]):host([focused]){	  		
	  		border: 1px solid rgba(25, 118, 210, 1.0);			  		
    		border-left-width: 5px;	
	  	}
	  	
	  	/*remove Button-Ripple */
	  	:host([theme~="hmButton"])::after{  			  
			/*transition: transform 3s, opacity 3s;*/
	  		transition: transform 0s, opacity 0s;
	  	}
	   
	   	:host([theme~="hmButton"]):host([active])::after{	   
	  		transform: scale(0.3, 0.3);
	  		/*opacity: 1.0;*/
	  		opacity: 0.0;
			transition: 0s;	  	
	  	}
	  	/***********************/
	  	 
	  	:host([theme~="hmButton"]):host(.leftMenuItem) .vaadin-button-container {
        	justify-content: left !important;
			text-align: left !important;
    	}
	      
		:host([theme~="hmButton"]):host(.leftMenuItem) .vaadin-button-container div[part="suffix"] {
        	-webkit-transition: transform 0.3s ease-in-out, padding-bottom 0.3s ease-in-out;
			-moz-transition: transform 0.3s ease-in-out, padding-bottom 0.3s ease-in-out;
			-ms-transition: transform 0.3s ease-in-out, padding-bottom 0.3s ease-in-out;
			-o-transition: transform 0.3s ease-in-out, padding-bottom 0.3s ease-in-out;
			transition: transform 0.3s ease-in-out, padding-bottom 0.3s ease-in-out;
			-webkit-transform: rotate(0deg);
			-moz-transform: rotate(0deg);
			-ms-transform: rotate(0deg);
			-o-transform: rotate(0deg);
			transform: rotate(0deg);
	    	position: absolute;
			height: 24px;
			width: 24px;
			right: 5px;
			margin: 0;
    	}
            	          	  
        :host([theme~="hmButton"]):host(.hmButtonIconOnly) {
       		min-width: 36px !important;
    	}
            	
    	:host([theme~="hmButton"]):host(.topMenuItem) .vaadin-button-container div[part="prefix"], :host(.hmButtonIconOnly) .vaadin-button-container div[part="prefix"] {
       		margin: 0 !important;
		}
            	
    	:host([theme~="hmButton"]):host(.hmButtonIconOnly) .vaadin-button-container:before , :host(.hmButtonIconOnly) div[part="label"], :host(.hmButtonIconOnly) div[part="suffix"] {
       		display: none !important;
    	}
            	  
	   </style>
	 </template>`;

domStyleElement.register('HMButton'); 