<script type="text/javascript">  
var t = 15;   
function showTime(){  
    t -= 1;  
    document.getElementById('showtimes').innerHTML= t;  
    if(t==0){  
    }  
    setTimeout("showTime()",1000);  
}  
showTime();  
</script>