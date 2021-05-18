import '@polymer/polymer/lib/elements/dom-module.js';

const customStyle = document.createElement('template');

customStyle.innerHTML = `
	<custom-style>
      <style>
		
		.hmNotificationCenter {
			background: var(--lumo-shade-50pct);
    		-webkit-transition: right 0.5s cubic-bezier(0.77, 0, 0.18, 1);
			-moz-transition: right 0.5s cubic-bezier(0.77, 0, 0.18, 1);
			-ms-transition: right 0.5s cubic-bezier(0.77, 0, 0.18, 1);
			-o-transition: right 0.5s cubic-bezier(0.77, 0, 0.18, 1);
			transition: right 0.5s cubic-bezier(0.77, 0, 0.18, 1);
    		width: 350px !important;
    		position: fixed;
    		z-index: 100000;
    		right: -350px;
    		top: 0;
		}
		
		.hmNotificationCenter .notification {
			box-shadow: 0px 0px 2px var(--lumo-shade-70pct);
			background: var(--lumo-tint-50pct);
			width: calc(100% - 36px);
			position: relative;
			margin: 8px 8px 0;
			display: block;
			padding: 10px;
		}
		
		.hmNotificationCenter .notification.withIcon .content, .hmNotificationCenter .notification.withIcon .title {
    		padding-left: 50px;
		}

		.hmNotificationCenter .notification .title {
    		line-height: 12px;
    		font-size: 18px;
    		height: 24px;
		}

		.hmNotificationCenter .notification .timeAgo {
    		margin: 4px 0 0 8px;
    		position: absolute;
    		font-size: 10px;
		}

		.hmNotificationCenter .notification .timeAgo:before {
    		display: inline-block;
    		margin: 0 7px 1px 0;
    		border-radius: 50%;
    		content: '';
    		height: 4px;
    		width: 4px;
		}

		.hmNotificationCenter .notification .content {
    		font-size: 14px;
    		display: block;
		}
		
		.hmNotificationCenter .footer {
    		text-align: center;
    		position: relative;
    		display: block;
    		width: 100%;
		}
		
		.hmNotificationCenter .lastNotification {
    		-webkit-transition: right 1s cubic-bezier(0.79, 0.14, 0.15, 0.86), opacity 0.3s ease-in-out;
			-moz-transition: right 1s cubic-bezier(0.79, 0.14, 0.15, 0.86), opacity 0.3s ease-in-out;
			-ms-transition: right 1s cubic-bezier(0.79, 0.14, 0.15, 0.86), opacity 0.3s ease-in-out;
			-o-transition: right 1s cubic-bezier(0.79, 0.14, 0.15, 0.86), opacity 0.3s ease-in-out;
			transition: right 1s cubic-bezier(0.79, 0.14, 0.15, 0.86), opacity 0.3s ease-in-out;
    		height: auto !important;
    		pointer-events: none;
    		position: absolute;
    		margin: 10px 5px;
    		right: -350px;
    		opacity: 0;
    		bottom: 0;
		}

		.hmNotificationCenter .lastNotification.top {
    		margin-top: 2px;
    		bottom: unset;
    		top: 0;
		}

		.hmNotificationCenter .lastNotification.show {
    		pointer-events: auto;
    		right: 350px;
    		opacity: 1;
		}

		.hmNotificationCenter .lastNotification.show:hover {
    		opacity: 0.1;
		}

		.hmNotificationCenter .lastNotification .notification {
    		width: 300px;
		}

		.hmNotificationCenter.open {
    		right: 0;
		}
		
      </style>
    </custom-style>`;

document.head.appendChild(customStyle.content);

const domStyleElement = document.createElement('dom-module');
domStyleElement.setAttribute('theme-for', 'vaadin-button');

domStyleElement.innerHTML = 
	 `<template>   
	   <style>
	   
	   :host([theme~="ncButton"]){
	   		border-radius: 0;
    		cursor: pointer;
    		background: var(--lumo-tint-50pct);
			color: var(--lumo-contrast-90pct);
		
	   }
	   
	    :host([theme~="ncButton"]):host(.hmButtonIconOnly) {
       		min-width: 36px !important;
    	}
	   	   
	   </style>
	 </template>`;

domStyleElement.register('NfCe-Button'); 