class PubSub{

    constructor(){
    
    this.subscribers = [];
    
    }
    
    subscribe(fn){
    
    this.subscribers.push(fn);
    
    }
    
    publish(data){
    
    this.subscribers.forEach(subscriber =>{
    
    subscriber(data);
    
    });
    
    }
    
    }
    
    const pubSub = new PubSub();
    
    pubSub.subscribe(data=>{
    
    counterRecord = document.getElementsByClassName('demo');
    
    for(var i=0;i<counterRecord.length;++i){
    
    counterRecord[i].innerHTML = "{Resource Name}:"+data;
    
    }
    
    });
    
    function updateCounter(){
    
    pubSub.publish(++window.incrementalGame.state.counter);
    
    }