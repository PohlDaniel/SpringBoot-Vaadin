import '@polymer/polymer/lib/elements/dom-module.js';

const customStyle = document.createElement('template');

customStyle.innerHTML = `
	<custom-style>
      <style>
      	.hmTopMenu {
			background: var(--lumo-shade-10pct);
			position: relative;
			
		}
      </style>
    </custom-style>`;

document.head.appendChild(customStyle.content);


const domTextField = document.createElement('dom-module');
domTextField.setAttribute('theme-for', 'vaadin-text-field');

domTextField.innerHTML = 
	 `<template>   
	   <style>
	   
	   :host([theme~="tmTextField"]){
	   		-webkit-transition: width 0.3s ease-in-out, border-top-width 0.3s ease-in-out;
			-moz-transition: width 0.3s ease-in-out, border-top-width 0.3s ease-in-out;
			-ms-transition: width 0.3s ease-in-out, border-top-width 0.3s ease-in-out;
			-o-transition: width 0.3s ease-in-out, border-top-width 0.3s ease-in-out;
			transition: width 0.3s ease-in-out, border-top-width 0.3s ease-in-out;
			
			border-top: 0 solid var(--lumo-primary-color);
    		border-radius: 0;
    		min-width: 35px;
    		margin: 0 4px;
    		height: 40px;
    		width: 35px;
    		padding: 0;
    		
    		
	   }
	   
	   :host([theme~="tmTextField"]):host(.active){
	 	 	border-top-width: 3px;
    		height: 43px;
	 	}
	 	
	 	:host([theme~="tmTextField"]:hover) {
			border-top-width: 5px;
    		height: 45px;
    		width: 180px !important;
		}
		
		:host([theme~="tmTextField"]) .vaadin-text-field-container div[part="input-field"] ::slotted(iron-icon) {
    		color: var(--lumo-contrast-90pct);
		}
		  	
    	:host([theme~="tmTextField"]) [part="input-field"] [part="value"] {
             -webkit-transition: background 0.3s ease-in-out, opacity 0.3s ease-in-out;
			-moz-transition: background 0.3s ease-in-out, opacity 0.3s ease-in-out;
			-ms-transition: background 0.3s ease-in-out, opacity 0.3s ease-in-out;
			-o-transition: background 0.3s ease-in-out, opacity 0.3s ease-in-out;
			transition: background 0.3s ease-in-out, opacity 0.3s ease-in-out;
			opacity: 0;
			 
        }
        
    	:host([theme~="tmTextField"]:hover) [part="input-field"] [part="value"]{
    	 	opacity: 1;
    	}
	   	     
	   </style>
	 </template>`;

domTextField.register('TopMenu-TextField');

const domStyleElement = document.createElement('dom-module');
domStyleElement.setAttribute('theme-for', 'vaadin-button');

domStyleElement.innerHTML = 
	 `<template>   
	   <style>
	   
	   :host([theme~="tmButton"]){
	   		background: var(--lumo-shade-10pct);
    		-webkit-transition: height 0.3s ease-in-out, border-top-width 0.3s ease-in-out;
			-moz-transition: height 0.3s ease-in-out, border-top-width 0.3s ease-in-out;
			-ms-transition: height 0.3s ease-in-out, border-top-width 0.3s ease-in-out;
			-o-transition: height 0.3s ease-in-out, border-top-width 0.3s ease-in-out;
			transition: height 0.3s ease-in-out, border-top-width 0.3s ease-in-out;
			
			color: var(--lumo-contrast-90pct);
			border-bottom-right-radius: 5px;
			border-bottom-left-radius: 5px;
			
			border-top: 0 solid var(--lumo-primary-color);
    		border-radius: 0;
    		min-width: 35px;
    		margin: 0 4px;
    		height: 40px;
    		width: 35px;
    		padding: 0;
    		
    	
    		
    		cursor: pointer;
	   }
	   	   
	   :host([theme~="tmButton"]):host(.toolTip) {
			color: var(--lumo-primary-contrast-color);
			background: var(--lumo-primary-color);
    		padding: 1px 4px 3px;
    		border-radius: 3px;
    		position: absolute;
			font-size: 13px;
    		left: 25px;
    		top: 30px;
		}
	 	
	 	:host([theme~="tmButton"]):host(.active){
	 	 	border-top-width: 3px;
    		height: 43px;
	 	}
	 	
	 	:host([theme~="tmButton"]:hover) {
			border-top-width: 5px;
    		height: 45px;
		}
	 	
	 	
	   
	   </style>
	 </template>`;

domStyleElement.register('TopMenu-Button'); 