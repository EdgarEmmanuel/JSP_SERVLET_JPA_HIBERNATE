<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="navbar.jsp"></jsp:include>

<h1>Informations Personnelles</h1>
<c:out value="${personnal_info}" />

<h1>Description Personnelle</h1>
<c:out value="${description_cv}" />


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

	<h1>NIVEAUX</h1>
		<table>
            <thead>
                <tr>
                	<th>Id</th>
                    <th>libelle</th>
                    <th>Annee Debut</th>
                    <th>Annee Fin</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${niveaux}" var="city">
                <tr>
                	<td> ${city.id }</td>
                	<td> ${city.libelle}</td>
                	<td> ${city.anneeDebut} </td>
                	<td> ${city.anneeFin} </td>
                </tr>
                </c:forEach>   
            </tbody>
        </table>
        
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
        
        
         <h1>EXPERIENCES</h1>
	<table>
            <thead>
                <tr>
                	<th>Id</th>
                    <th>date Debut</th>
                    <th>date Fin </th>
                    <th>Nom Societe</th>
                    <th>Mission</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${experiences}" var="city">
                <tr>
                	<td>${city.id }</td>
                	<td> ${city.dateDebut}</td>
                	<td> ${city.dateFin} </td>
                	<td> ${city.nomSociete}</td>
                	<td> ${city.tache} </td>
                </tr>
                </c:forEach>   
            </tbody>
        </table>

<jsp:include page="footer.jsp"></jsp:include>