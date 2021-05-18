import '@polymer/polymer/lib/elements/dom-module.js';

const styleElement = document.createElement('dom-module');
styleElement.setAttribute('theme-for', 'vaadin-password-field');

styleElement.innerHTML = 
 `<template>
   <style>
   
    :host(.static-field-js) [part="input-field"] {
    	width: 130%;
        background-color: white;
    }
    
    :host(.on-mouse-over-js:hover) [part="input-field"]{
        background-color: rgba(128, 181, 234, 0.2) !important; 
    }
  
   :host(.after-js) [part="input-field"]::after{
	
		content: "";
    	position: absolute;
    	top: 0;
    	right: 0;
    	bottom: 0;
    	left: 0;
    	border-radius: inherit;
    	pointer-events: none;
    	opacity: 0;
    	/*background-color: hsla(214, 45%, 20%, 0.5);*/
    	background-color: rgba(128, 181, 234, 0.2);
		transition: transform 0.15s, opacity 0.2s;
		transform-origin: 100% 0;            
	}
       
    :host(.click-label-bold-js) [part="label"] {
        font-weight: var(--font-weight, 500);
    }
   
   :host(.ckick-label-color-js) [part="label"] {
		color: black !important;
    }
  
   </style>
 </template>`;

styleElement.register('password-field-theme'); 