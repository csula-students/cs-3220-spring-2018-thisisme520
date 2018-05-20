/*eslint-env node, jest */
import Timer from '../src/timer';

// mock timer
jest.useFakeTimers();

describe('Timer', () => {
	beforeEach(() => {
		jest.resetModules();
	});

	test('tick should call callbackFn every second', () => {
		const callbackFn = jest.fn();
		const timer = new Timer();
		timer.start();
		timer.tick(callbackFn);

		expect(callbackFn).toBeCalled();
		expect(setTimeout).toHaveBeenCalledTimes(1);
		expect(setTimeout).toHaveBeenLastCalledWith(expect.any(Function), 1000);

		jest.runOnlyPendingTimers();

		expect(callbackFn).toBeCalled();
		expect(setTimeout).toHaveBeenCalledTimes(2);
		expect(setTimeout).toHaveBeenLastCalledWith(expect.any(Function), 1000);
	});

	test('should be able to stop any on going ticks', () => {
		const callbackFn = jest.fn();
		const timer = new Timer();
		timer.start();
		timer.tick(callbackFn);
		timer.stop();

		jest.runOnlyPendingTimers();

		expect(callbackFn).toBeCalled();
		expect(setTimeout).toHaveBeenCalledTimes(1);

		jest.runOnlyPendingTimers();

		expect(callbackFn).toHaveBeenCalledTimes(1);
		expect(setTimeout).toHaveBeenCalledTimes(1);
	});
});
