import '@polymer/polymer/lib/elements/dom-module.js';

const styleElement = document.createElement('dom-module');
styleElement.setAttribute('theme-for', 'vaadin-button');

styleElement.innerHTML =  
`<template>
   <style>
   
    :host(.login-button){
		
		box-shadow:inset 0px 1px 0px 0px #dcecfb;
		background:linear-gradient(to bottom, #bddbfa 5%, #80b5ea 100%);
		background-color:#bddbfa;
		border-radius:6px;
		border:1px solid #84bbf3;
		display:inline-block;
		cursor:pointer;
		color:#ffffff;
		font-family:Arial;
		font-size:15px;
		font-weight:bold;
		padding:6px 24px;
		text-decoration:none;
		text-shadow:0px 1px 0px #528ecc;     					
     	width : auto !important;
	}
  
	:host(.login-button:hover) {

		background:linear-gradient(to bottom, #80b5ea 5%, #bddbfa 100%);
		background-color:#80b5ea;		
		width : auto !important;
	}
  
   </style>
 </template>`;

styleElement.register('login-button-theme'); 