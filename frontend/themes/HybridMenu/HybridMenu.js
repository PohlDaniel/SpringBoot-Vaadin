const customStyle = document.createElement('template');

customStyle.innerHTML = `
	<custom-style>
      <style>
		.hybridMenu {
			background: var(--lumo-base-color);
			position: relative;
    		overflow: hidden;
			z-index: 1;
			
		}

		.hybridMenu .paddingTopContent {
			padding-top: 50px !important;
		}
		
		.hmContentBox {
    		overflow: auto;
    		padding-top: 0 !important;
		}
		
		.rootContent {
			display: grid;
			grid-template-columns: 15% 85%;
			grid-template-rows: 7% 93%;
		}

		.hmLabel {			
			grid-column: 1 / 2;
			grid-row: 1 / 2;
		}
 
		.hmTopMenu {			
			grid-column: 2 / 3;
			grid-row: 1 / 2;
		}
		
		.hmLeftMenu {			
			grid-column: 1 / 2;
			grid-row: 2 / 3;
		}
 
		.mainContent {			
			grid-column: 2 / 3;
			grid-row: 2 / 3; 
		}

      </style>
    </custom-style>`;

document.head.appendChild(customStyle.content);