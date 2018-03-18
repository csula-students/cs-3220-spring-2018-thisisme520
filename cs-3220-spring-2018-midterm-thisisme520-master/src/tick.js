const TICK_INTERVAL = 1000;

export function tick (callback) {
    // TODO: call callback function

    // TODO: schedule another tick call in TICK_INTERVAL
    // hint: check game.js in homework
    setTimeout(tick.bind(this, callback), TICK_INTERVAL);
}
