
import {PolymerElement} from '@polymer/polymer/polymer-element.js';
import {html} from '@polymer/polymer/lib/utils/html-tag.js';
import '../themes/password-field-theme.js';

class PasswordField extends PolymerElement {

    static get template() {
        return html
             	`<vaadin-password-field id= "password" 
             					   		name= "password" 
             					   		value="{{userInput::input}}"
             					   		label= "Password"
             					   		placeholder= "password"
             					   		class= "static-field-js on-mouse-over-js click-label-bold-js"
             					   		on-focus= "boldLabelServer"
             					   		on-blur= "normalLabel"/>`;
    }

    static get is() {
          return 'password-field';
    }
    
    boldLabel(){
    	
    	this.$.password.classList.remove('on-mouse-over-js');
    	this.$.password.classList.add('ckick-label-color-js');
    	
    	this.updateStyles({
            '--font-weight': 'bold'
          });
    }
    
    normalLabel(){

    	this.$.password.classList.add('on-mouse-over-js');
    	this.$.password.classList.remove('ckick-label-color-js');
    	
    	this.updateStyles({
            '--font-weight': '500'
          });
    }
}

customElements.define(PasswordField.is, PasswordField);

