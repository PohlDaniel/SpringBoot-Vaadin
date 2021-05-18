import '@polymer/polymer/lib/elements/dom-module.js';

const customStyle = document.createElement('template');

customStyle.innerHTML = `
	<custom-style>
      <style>
      
      	
      
		[theme~="dark"] {
      		--background: var(--lumo-tint-5pct);
		}
		
		.hmLeftMenu {
			background: var(--lumo-shade-10pct);
    		-webkit-transition: width 0.5s ease-in-out, min-width 0.5s ease-in-out, max-width 0.5s ease-in-out;
			-moz-transition: width 0.5s ease-in-out, min-width 0.5s ease-in-out, max-width 0.5s ease-in-out;
			-ms-transition: width 0.5s ease-in-out, min-width 0.5s ease-in-out, max-width 0.5s ease-in-out;
			-o-transition: width 0.5s ease-in-out, min-width 0.5s ease-in-out, max-width 0.5s ease-in-out;
			transition: width 0.5s ease-in-out, min-width 0.5s ease-in-out, max-width 0.5s ease-in-out;
    		border-radius: 5px solid;
    		overflow-y: visible;
    		overflow-x: auto;
    		height : 100%;
		}

		
		
		

      </style>
    </custom-style>`;

document.head.appendChild(customStyle.content);


const domStyleElement = document.createElement('dom-module');
domStyleElement.setAttribute('theme-for', 'vaadin-button');

domStyleElement.innerHTML = 
	 `<template>   
	   <style>
	 	/* set the green border */
	   :host([theme~="lmButton"]):host(.active){
	    	border-left-color: var(--lumo-success-color);
    		border-left-width: 5px;
	    }
	   
	   /*toggle the background similar to the online demo "http://fo0.me:8080/hybridmenu/NotificationBuilderPage" */
	   :host([theme~="lmButton"]):host(.stateOne){	
	   		border-left-color: var(--lumo-success-color) !important;
			background: var(--lumo-base-color);			
		}
		
		:host([theme~="lmButton"]):host(.stateTwo){	
			background: var(--background);
			border-left: 0 solid var(--lumo-primary-color);
		}
		
		:host([theme~="lmButton"]):host(.toolTip) {
			-webkit-transform: translateY(-50%);
			-moz-transform: translateY(-50%);
			-ms-transform: translateY(-50%);
			-o-transform: translateY(-50%);
			transform: translateY(-50%);
    		padding: 1px 4px 3px;
			border-radius: 3px;
    		position: absolute;
    		right: 8px;
    		top: 50%;
		}
	   
	   </style>
	 </template>`;

domStyleElement.register('LeftMenu'); 