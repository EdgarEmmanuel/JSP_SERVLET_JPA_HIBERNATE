<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>Simple login form</title>
    <link rel="stylesheet" href="${base}public/css/test.css" />
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700"/>
  </head>
  <body>
	  
    <form action="login.save" method="post">
      <h1>CONNEXION</h1>
      <div class="formcontainer">
	      <div>
		  	<img style="width:10rem,height:auto;display:block" src="https://fjwp.s3.amazonaws.com/blog/wp-content/uploads/2020/01/11140027/send-email-1024x512.png" alt=""/>
		  </div>
	      <hr/>
	      <div class="container">
	        <input type="text" placeholder="Email" name="uname" required>
	        <input type="password" placeholder="Mot de Passe" name="psw" required>
	        <select name="personne" required>
            <option value="demandeur" selected>Demandeur</option>
            <option value="entreprise">Entreprise</option>
          </select>
	      </div>
	      <button type="submit">Se Connecter</button>
      </div>
    </form>
  </body>
</html>