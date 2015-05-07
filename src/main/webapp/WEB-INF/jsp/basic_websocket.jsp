<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Home</title>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/0.3.4/sockjs.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<html>
  <head>
   
  </head>
  <body>
	 <button id="stop">Stop</button>
  
    <script>
      var sock = new SockJS("marco");
      sock.onopen = function() {
    	  console.log('Opening');
    	  sayMarco();
      }
      
      sock.onmessage = function(e) {
    	  console.log('Received message: ', e.data);
    	  $('#output').append('Received "' + e.data + '"<br/>');
    	  setTimeout(function(){sayMarco()}, 2000);
      }
      
      sock.onclose = function() {
    	  console.log('Closing');
      }
      
      function sayMarco() {
    	  console.log('Sending Marco!');
    	  $('#output').append('Sending "Marco!"<br/>');
    	  sock.send("Marco!");
      }
      $('#stop').click(function() {sock.close()});
      </script>
    
    <div id="output"></div>
  </body>
</html>