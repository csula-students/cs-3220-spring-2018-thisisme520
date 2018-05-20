import '@webcomponents/webcomponentsjs';

import PomodoroComponent from './views/pomodoro';
import Timer from './timer';
import { incrementPomodoroCounter } from './utils';

// define web components
window.customElements.define('pomodoro-timer', PomodoroComponent);

main();

// main function wraps everything at top level
function main () {
	const pomodoroDOM = document.querySelector('pomodoro-timer');
	const buttonDOM = document.querySelector('button');
	const timer = new Timer();
	const id = window.todoID;

	// early safe termination when the HTML is not yet ready
	if (!pomodoroDOM || !buttonDOM) {
		console.error('pomodoro dom AND button DOM is not yet defined in the HTML. Please define them before you continue testing');
		return;
	}

	// HINT: may be a good idea to tweak this number for ease of local testing (e.g. setting it to 15 seconds instead of 15 minutes)
	// TODO: change the following value to 15 minutes on final submission
	pomodoroDOM.countdown = 15;

	// TODO: bind click event to button and start timer accordingly
	// hint: when start the timer, you may need to ensure the countdown is also reset to its original coutdown value (15 minutes or 15 seconds depending on whether you are testing)
	// hint: when the countdown reaches to zero, sends a post request to server using `incrementPomodoroCounter` function and refresh page
}

function refreshPage () {
	window.location.reload(false);
}
