<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="navbar.jsp"></jsp:include>
<link rel="stylesheet" href="${base}public/css/specialitepage.css" />
<h1>SPECIALITE</h1>
	<table>
            <thead>
                <tr>
                    <th>Technologie</th>
                    <th>Niveau </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${specialites}" var="city">
                <tr>
                	<td> ${city.libelle}</td>
                	<td> ${city.level} </td>
                </tr>
                </c:forEach>   
            </tbody>
</table>

<!-- start part to add a specialite  -->

<div class="main-block">
      <div class="left-part">
        <i class="fas fa-graduation-cap"></i>
        <h1>AJOUTER UNE NOUVELLE SPECIALITE</h1>
      </div>
      <form action="specialite.save" method="Post">
        <div class="title">
          <i class="fas fa-pencil-alt"></i> 
        </div>
        <div class="info">
          <input class="fname" type="text" name="technologie" placeholder="Technologie">
          <labe>Niveau</labe>
          <input type="range" min="1" max="100" name="niveau" value="50" class="slider" id="myRange">
        </div>
        <button type="submit">Submit</button>
      </form>
    </div>

<!-- end part to add a specialite  -->


<jsp:include page="footer.jsp"></jsp:include>