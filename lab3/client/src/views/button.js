export default function (store) {
	return class ButtonComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;
			
			this.textContent = this.store.state.button;

			this.onStateChange = this.handleStateChange.bind(this);

			handleStateChange(newState){
				this.textContent = newState.button;
			}
			
			
			connectedCallback(){
				this.addEventListener('click',())=>{
					this.store.dispath({
						type: 'BUY_GENERATOR',
						payload: 'Increse counter'
					});
				});
				
			}
			disconnectedCallback(){
				this.store.unsubscribe(this.onStateChange);
			}
			
			

			// TODO: add click event to increment counter
			// hint: use "store.dispatch" method (see example component)
		}
	};
}
