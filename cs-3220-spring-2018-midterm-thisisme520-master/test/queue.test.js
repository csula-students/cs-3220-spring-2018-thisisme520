/*eslint-env node, jest */
import { BufferQueue } from '../src/models/queue';

describe('BufferQueue', () => {
    test('get should return empty list as default', () => {
        expect(new BufferQueue(5).get()).toEqual([]);
    });

    test('push should push value as normal when it does not exeed the size', () => {
        const queue = new BufferQueue(5);
        queue.push(1);
        const expected = [1];
        expect(queue.get()).toEqual(expected);
        queue.push(2);
        const expected2 = [1, 2];
        expect(queue.get()).toEqual(expected2);
    });

    test('push should pop the last item when it is over limit', () => {
        const queue = new BufferQueue(5);
        for (let i = 1; i <= 5; i ++) {
            queue.push(i);
        }
        queue.push(6);
        const expected = [2, 3, 4, 5, 6];
        expect(queue.get()).toEqual(expected);
        queue.push(7);
        const expected2 = [3, 4, 5, 6, 7];
        expect(queue.get()).toEqual(expected2);
    });

    test('setSize should be able to increase size', () => {
        const queue = new BufferQueue(1);
        queue.push(1);
        expect(queue.get()).toEqual([1]);
        queue.setSize(2);
        queue.push(2);
        expect(queue.get()).toEqual([1, 2]);
    });

    test('setSize should be able to reduce size while keeping existing items', () => {
        const queue = new BufferQueue(3);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        expect(queue.get()).toEqual([1, 2, 3]);
        queue.setSize(2);
        expect(queue.get()).toEqual([2, 3]);
    });
});
