import { formatSecondsToMinutes } from '../utils';

export default class PomodoroComponent extends window.HTMLElement {
	constructor () {
		super();
		this._countdown = 15;
	}
	// this allows GameChart to listen for dom attribute changes and call
	// attributeChangedCallback when the attribute changes in DOM
	static get observedAttributes () {
		return ['data-countdown'];
	}

	// reset the property from normal binding to use getter/setter
	// or the setter may not be called properly if the attribute
	// is set prior to GameChart being instantiated
	_upgradeProperty(prop) {
		if (this.hasOwnProperty(prop)) {
			let value = this[prop];
			delete this[prop];
			this[prop] = value;
		}
	}

	/**
	 * define custom getters and setters to handle update on value changes
	 * accoridngly through JavaScript call
	 */
	get countdown () {
		return this._countdown;
	}
	set countdown (val) {
		this._countdown = val;
		this.handleChange();
	}

	connectedCallback () {
		// upgrade property so that the es6 setter can be called properly
		['countdown'].forEach(p => {
			this._upgradeProperty(p);
		});
		// initial DOM rendering
		this.render();
	}

	handleChange() {
		// re-render
		this.render();
	}

	render () {
        // TODO: render the timer and number of pomodoro counter
        // hint: you should utilize `formatSecondsToMinutes` function to render user friendly time format
	}
}
