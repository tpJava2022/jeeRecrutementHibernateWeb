<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<title>Insert title here</title>
</head>
<body>
<%@include file="header2.jsp" %>
<section class="vh-100 gradient-custom">
  <div class="container py-5 h-100">
    <div class="row justify-content-center align-items-center h-100">
      <div class="col-12 col-lg-9 col-xl-7">
        <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
          <div class="card-body p-4 p-md-5">
            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Inscription</h3>
            <form method="post" action="inscrire.php" enctype='multipart/form-data'>

              <div class="row">
                <div class="col-md-6 mb-4">

                  <div class="form-outline">
                  	<label class="form-label" for="prenom">Prénom</label>
                    <input type="text" id="prenom" name="prenom" class="form-control form-control-lg" />
                  </div>

                </div>
                <div class="col-md-6 mb-4">

                  <div class="form-outline">
                  	<label class="form-label" for="nom">Nom</label>
                    <input type="text" id="nom" name="nom" class="form-control form-control-lg" />
                  </div>
                </div>
              </div>

              <div class="row">
                <div class="col-md-6 mb-4 d-flex align-items-center">

                  <div class="form-outline datepicker w-100">
                  <label for="cin" class="form-label">CIN</label>
                    <input
                      type="text"
                      class="form-control form-control-lg"
                      name="cin"
                      id="cin"
                    />
                  </div>
                </div>
              </div>

              <div class="row">
                <div class="col-md-6 mb-4 pb-2">

                  <div class="form-outline">
                  	<label class="form-label" for="email">Email</label>
                    <input type="email" id="email" name="email" class="form-control form-control-lg" />
                  </div>

                </div>
                <div class="col-md-6 mb-4 pb-2">

                  <div class="form-outline">
                  	<label class="form-label" for="cv">CV</label>
                    <input type="file" id="cv" name="cv" class="form-control form-control-lg" />
                  </div>

                </div>
              </div>

              <div class="mt-4 pt-2">
                <input class="btn btn-primary btn-lg" type="submit" value="s'inscrire" />
              </div>

            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

</body>
</html>