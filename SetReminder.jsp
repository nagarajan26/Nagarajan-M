<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Set Reminder</title>
<script>

function call(){
	
	const monthSelect = document.getElementById("month");
	const daySelect = document.getElementById("day");

	function Months(){
		monthSelect.innerHTML="<option value='1'>January</option>"+(monthSelect.value=1)
	    	+"<option value='2'>February</option>"+(monthSelect.value=2)
	    	+"<option value='3'>March</option>"+(monthSelect.value=3)
	    	+"<option value='4'>April</option>"+(monthSelect.value=4)
	    	+"<option value='5'>May</option>"+(monthSelect.value=5)
	    	+"<option value='6'>June</option>"+(monthSelect.value=6)
	    	+"<option value='7'>July</option>"+(monthSelect.value=7)
	    	+"<option value='8'>August</option>"+(monthSelect.value=8)
	    	+"<option value='9'>September</option>"+(monthSelect.value=9)
	    	+"<option value='10'>October</option>"+(monthSelect.value=10)
	    	+"<option value='11'>November</option>"+(monthSelect.value=11)
	    	+"<option value='12'>December</option>"+(monthSelect.value=12)
	}
	function Days(month){
	  
	    while(daySelect.firstChild){
	        daySelect.removeChild(daySelect.firstChild);
	    }
	    let dayNum;
	    if(month == '1' || month == '3' || 
	    month == '5' || month == '7' || month == '8' 
	    || month == '10' || month == '12') {
	        dayNum = 31;
	    } else if(month == '4' || month == '6' 
	    || month == '9' || month == '11') {
	        dayNum = 30;
	    }else{
	    	dayNum=29;
	    }
	    for(let i = 1; i <= dayNum; i++){
	        const option = document.createElement("option");
	        option.textContent = i;
	        option.value=i;
	        daySelect.appendChild(option);
	    }
	    
	}
    Months();
	Days(monthSelect.value);

	monthSelect.onchange = function() {
	    Days(monthSelect.value);
	}
}
</script>
<script>
function myFunction() {
	  document.getElementById("demo1").innerHTML = "<form><span><label for=\"day\">Day:</label><select name=\"day\" id=\"day\"></select></span><span><label for=\"month\">Month:</label><select name=\"month\" id=\"month\"></select></span></form>";
	  call();
	  document.getElementById("demo2").innerHTML = "<b>Enter the Description: </b><br><input type=\"text\" name=\"des\"autofocus required><br><b>Enter the time:</b><br><input type=\"time\" name=\"time\"autofocus required><br><br><input type=\"submit\" name=\"1\"value=\"Submit\">";
	}
	function myFunction1() {
	  document.getElementById("demo1").innerHTML = "<b>Enter the date: </b><br><select name=\"date\" >"
		  +"<option value='01'>01</option>"
		  +"<option value='02'>02</option>"
		  +"<option value='03'>03</option>"
		  +"<option value='04'>04</option>"
		  +"<option value='05'>05</option>"
		  +"<option value='06'>06</option>"
		  +"<option value='07'>07</option>"
		  +"<option value='08'>08</option>"
		  +"<option value='09'>09</option>"
		  +"<option value='10'>10</option>"
		  +"<option value='11'>11</option>"
		  +"<option value='12'>12</option>"
		  +"<option value='13'>13</option>"
		  +"<option value='14'>14</option>"
		  +"<option value='15'>15</option>"
		  +"<option value='16'>16</option>"
		  +"<option value='17'>17</option>"
		  +"<option value='18'>18</option>"
		  +"<option value='19'>19</option>"
		  +"<option value='20'>20</option>"
		  +"<option value='21'>21</option>"
		  +"<option value='22'>22</option>"
		  +"<option value='23'>23</option>"
		  +"<option value='24'>24</option>"
		  +"<option value='25'>25</option>"
		  +"<option value='26'>26</option>"
		  +"<option value='27'>27</option>"
		  +"<option value='28'>28</option>"
		  +"<option value='29'>29</option>"
		  +"<option value='30'>30</option>"
		  +"<option value='31'>31</option>"
		  +"</select><br><b>Enter the Description: </b><br><input type=\"text\" name=\"des\"autofocus required><br><b>Enter the time:</b><br>";
	  document.getElementById("demo2").innerHTML = "<input type=\"time\" name=\"time\"autofocus required><br><br><input type=\"submit\" name=\"2\" value=\"Submit\" >";
	
	}
	function myFunction2() {
	  document.getElementById("demo1").innerHTML = "<b>Enter the Description: </b><br><input type=\"text\" name=\"des\"autofocus required><br><b>Enter the time:</b><br>";
	  document.getElementById("demo2").innerHTML = "<input type=\"time\" name=\"time\"autofocus required><br><br><input type=\"submit\" name=\"3\" value=\"Submit\">";
	  
	}


</script>
</head>
<body bgcolor="LightYellow">
<form action="set2" >
<b>Enter the Reminder:</b><br>
<button type="button" onclick="myFunction()">Yearly Reminder</button>
<button type="button" onclick="myFunction1()">Monthly Reminder</button>
<button type="button" onclick="myFunction2()">Daily Reminder</button>

<p id="demo1"></p>
<p id="demo3"></p>
<p id="demo2"></p>

  </form>
</body>
</html>