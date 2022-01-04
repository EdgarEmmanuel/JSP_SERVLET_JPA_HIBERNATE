<jsp:include page="navbar.jsp"></jsp:include>

<!-- Image Header -->
<div class="w3-display-container w3-animate-opacity">
  <img src="https://www.boatbookings.com/imgcache//bvi_bareboat_itinerary_boatbookings_12227_24463_7815b8.jpg" alt="boat" style="width:100%;min-height:350px;max-height:600px;">
  <div class="w3-container w3-display-bottomleft w3-margin-bottom">  
    <h1 class="w3-button w3-xlarge w3-theme w3-hover-teal" title="name"><%= (String) session.getAttribute("nameUser") %></h1>
  </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>