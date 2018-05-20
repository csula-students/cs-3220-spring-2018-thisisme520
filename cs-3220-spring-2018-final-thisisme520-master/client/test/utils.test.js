/*eslint-env node, jest */
import { formatSecondsToMinutes } from '../src/utils';

describe('time formatter', () => {
	it('should be able to format 5 seconds to 00:05', () => {
		const actual = formatSecondsToMinutes(5);
		expect(actual).toBe('00:05');
	});


	it('should be able to format 75 seconds to 01:15', () => {
		const actual = formatSecondsToMinutes(75);
		expect(actual).toBe('01:15');
	});

	it('should be able to format 15 * 60 seconds to 15:00', () => {
		const actual = formatSecondsToMinutes(15 * 60);
		expect(actual).toBe('15:00');
	});
});
