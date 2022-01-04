<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.Specialite"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${title}"/></title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

<style>
	table, th, td {
  border: 1px solid black;
  padding:10px 10px ;
}

table{
margin-bottom:20px;
}
</style>
</head>
<body>
<%--
response.setHeader("Cache-Control", "no-cache");

//Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control", "no-store");

//Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0);

//Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma", "no-cache");

String userId = session.getAttribute("userId").toString();

//if(userId == null){
	//request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
//}

--%> 
<nav class="navbar navbar-expand-lg navbar-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
    	<img style="max-width:10rem;height:auto;display:block;" src="https://mk0bridgeu1jauvqfcy4.kinstacdn.com/wp-content/uploads/2019/10/Illustration.svg" alt="" />
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        
        <li class="nav-item">
           <a class="nav-link" href="cv.php">CV</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="specialite.php">Specialite</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="niveau.php">Niveau Etudes</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="realisation.php">Realisation</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="experience.php">Experiences Professionelles</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="deconnexion.php">Deconnexion</a>
        </li>
       </ul>
    </div>
  </div>
</nav>


