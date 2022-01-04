<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="navbar.jsp"></jsp:include>
<link rel="stylesheet" href="${base}public/css/realisation.css" />

    <h1>REALISATIONS</h1>
	<table>
            <thead>
                <tr>
                	<th>Id</th>
                    <th>Nom Realisation </th>
                    <th>Url Realisation</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${realisations}" var="city">
                <tr>
                	<td> ${city.id }</td>
                	<td> ${city.nom}</td>
                	<td> ${city.url} </td>
                </tr>
                </c:forEach>   
            </tbody>
        </table>

<!-- start part to add a specialite  -->

<div class="main-block">
      <div class="left-part">
        <i class="fas fa-graduation-cap"></i>
        <h1>AJOUTER UNE DE VOS REALISATIONS</h1>
      </div>
      <form action="/">
        <div class="title">
          <i class="fas fa-pencil-alt"></i> 
        </div>
        <div class="info">
          <input class="fname" type="text" name="name" placeholder="Full name">
          <input type="text" name="name" placeholder="Email">
          <input type="text" name="name" placeholder="Phone number">
          <input type="password" name="name" placeholder="Password">
          <select>
            <option value="course-type" selected>Course type*</option>
            <option value="short-courses">Short courses</option>
            <option value="featured-courses">Featured courses</option>
            <option value="undergraduate">Undergraduate</option>
            <option value="diploma">Diploma</option>
            <option value="certificate">Certificate</option>
            <option value="masters-degree">Masters degree</option>
            <option value="postgraduate">Postgraduate</option>
          </select>
        </div>
        <button type="submit">Enregistrer le niveau</button>
      </form>
    </div>

<!-- end part to add a specialite  -->


<jsp:include page="footer.jsp"></jsp:include>