export class GameChart extends HTMLElement {
    constructor () {
        super();
        this._values = [];
        this._color = '#ff0000';
        this._displayStyle = 'horizontal';
    }

    static get baseUnit () {
        return 16;
    }
    // this allows GameChart to listen for dom attribute changes and call
    // attributeChangedCallback when the attribute changes in DOM
    static get observedAttributes () {
        return ['data-values', 'data-color', 'data-display-style'];
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
    get values () {
        return this._values;
    }
    set values (val) {
        this._values = val;
        this.handleChange();
    }
    get color () {
        return this._color;
    }
    set color (val) {
        this._color = val;
        this.handleChange();
    }
    get displayStyle () {
        return this._displayStyle;
    }
    set displayStyle (val) {
        this._displayStyle = val;
        this.handleChange();
    }

    connectedCallback () {
        // upgrade property so that the es6 setter can be called properly
        ['color', 'values', 'displayStyle'].forEach(p => {
            this._upgradeProperty(p);
        });
        // TODO: call render method or handleChange
    }

    handleChange() {
        // TODO: handle update and re-render
    }

    attributeChangedCallback () {
        // TODO: get attributes from dataset and re-render accordingly
        //       e.g. <game-chart data-values="1,2,3" data-displayStyle="vertical" data-color="#eaeaea"></game-chart>
    }


    render () {
        // TODO: render chart HTML under the DOM
        // note: the bar should display in *reverse* order of the values received
        // hint: when computing height/width, remember you have a _static baseUnit_ method above
    }
}

