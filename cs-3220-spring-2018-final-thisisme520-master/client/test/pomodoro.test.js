/*eslint-env node, jest */

import PomodoroComponent from '../src/views/pomodoro';
require('@skatejs/ssr/register');
const render = require('@skatejs/ssr');

describe('Pomodoro Timer Component', () => {
	beforeEach(() => {
		window.customElements.define('pomodoro-timer', PomodoroComponent);
	});

	it('should be able to render default pomodoro timer to be 15 seconds', done => {
		render(new PomodoroComponent()).then(html => {
			expect(html).toMatchSnapshot();
			done();
		});
	});

	it('should be able to render default pomodoro timer to be 15 minutes', done => {
		const pomodoroTimer = new PomodoroComponent();
		pomodoroTimer.countdown = 15 * 60;
		render(pomodoroTimer).then(html => {
			expect(html).toMatchSnapshot();
			done();
		});
	});
});
