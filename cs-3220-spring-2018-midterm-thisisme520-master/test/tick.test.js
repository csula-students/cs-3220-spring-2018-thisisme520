/*eslint-env node, jest */
import { tick } from '../src/tick';

// mocking data
jest.useFakeTimers();

describe('Ticker', () => {
    test('get be called every second', () => {
        const callback = jest.fn();
        tick(callback);

        expect(setTimeout).toHaveBeenCalledTimes(1);
        expect(setTimeout).toHaveBeenLastCalledWith(expect.any(Function), 1000);

        jest.runOnlyPendingTimers();

        expect(callback).toBeCalled();

        expect(setTimeout).toHaveBeenCalledTimes(2);
        expect(setTimeout).toHaveBeenLastCalledWith(expect.any(Function), 1000);
    });
});
