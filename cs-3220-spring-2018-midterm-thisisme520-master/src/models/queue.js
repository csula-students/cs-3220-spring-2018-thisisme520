export class BufferQueue {
    constructor (size) {
        this.memory = [];
        this.size = size;
    }

    push (value) {
        // TODO: push an item to memory while keeping the size fixed
        
    }

    setSize (size) {
        // TODO: resize the memory keeping the newest items
    }

    get () {
        return this.memory;
    }
}
