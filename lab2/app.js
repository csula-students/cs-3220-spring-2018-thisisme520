
var add = (function () {
    var counter = 1337;
    return function () {return counter += 1;}
})();

function myFunction(){
    document.getElementById("demo").innerHTML ="{Resource Name}:"+add();
}