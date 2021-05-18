const customStyle = document.createElement('template');

customStyle.innerHTML = `
	<custom-style>
      <style>
      
      	@font-face {
    		font-family: kaushan-script;
    		src: url('frontend/fonts/KaushanScript-Regular.ttf') format('truetype');
		}
      
		.hmLabel {
    		border-bottom: 1px solid var(--lumo-shade-30pct);
    		border-right: 1px solid var(--lumo-shade-30pct);
    		background: var(--lumo-shade-10pct);
    		
    		text-align: center;
			display: flex; 
    		justify-content: center; 
    		align-items: center;
			
    		font-family: kaushan-script;
    		font-size: 20px;
    		font-weight: 300;
   
		}
		
		.hmLabel > p {   		
		
    		display: inline-block;
    		margin: 0 0 0 5px;
		}
		
		.hmLabel img {
		
    		margin-right: 5px;
    		height: 32px;
    		width: 32px;
		}
		
		

      </style>
    </custom-style>`;

document.head.appendChild(customStyle.content);