import '@webcomponents/webcomponentsjs';

import { BufferQueue } from './models/queue';
import { GameChart } from './views/chart';
import { tick } from './tick';
import { random } from './utils';

const initialBufferSize = 15;

window.customElements.define('game-chart', GameChart);

const chartDOM = document.querySelector('game-chart');
// hint: you can set the values/color/displayStyle to GameChart just like below
chartDOM.values = [1, 3, 3, 7];

// TODO: instantiate a new buffer array instance with initialBufferSize

// TODO: bind form submit element event binding to change gameChart item

tick(function() {
    // TODO: generate a random value to push to queue created above and
    //       assign queue value to chartDOM
});
