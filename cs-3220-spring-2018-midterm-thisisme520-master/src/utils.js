const UPPER_BOUND = 50;

// return a random integer between 0 to UPPER_BOUND
export function random () {
    return Math.floor(Math.random() * UPPER_BOUND);
}
