<%--
  Created by IntelliJ IDEA.
  User: Shakhila Roszie
  Date: 2/12/2018
  Time: 1:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!doctype html>
<html lang="en">
<head>
    <title>Polytechnic Malacca</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <!-- Main CSS -->
    <link rel="stylesheet" href="css/style.css">

    <!-- Font Awesome -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>

<body>

<!-- Main navigation -->
<div id="sidebar">

    <div class="navbar-expand-md navbar-dark">

        <header class="d-none d-md-block">
            <h2>Email Management System</h2>
        </header>


        <!-- Mobile menu toggle and header -->
        <div class="mobile-header-controls">
            <a class="navbar-brand d-md-none d-lg-none d-xl-none" href="#"><span>my</span>website</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#SidebarContent" aria-controls="SidebarContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>

        <div id="SidebarContent" class="collapse flex-column navbar-collapse">



            <!-- Main navigation items -->
            <nav class="navbar navbar-dark">
                <div id="mainNavbar">
                    <ul class="flex-column mr-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="StaffIndex1.jsp">Home</a>
                        </li>

                        <li class="nav-item active">
                            <a class="nav-link" href="StaffCreateEmail.jsp">Create Email <span class="sr-only">(current)</span></a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="StaffLogin.jsp">Login</a>
                        </li>
                    </ul>
                </div>
            </nav>

        </div>
    </div>
</div>


<div id="content">
    <div id="content-wrapper">

        <!-- Jumbtron / Slider -->
        <div class="jumbotron-wrap">
            <div class="container-fluid">
                <div class="jumbotron jumbotron-narrow static-slider">
                    <h1 class="text-center">Successfully Registered</h1>
                </div>
            </div>
        </div>

        <!-- Main content area -->
        <main class="container-fluid">
            <div class="row">

                <!-- Main content -->
                <div class="col-sm-8">
                    <article>

                        <br>

                        <blockquote><p>Please click "Login" button below to access the system. Use your ID and password given to login into the system. Please be noted that your new official email of Polytechnic can be use after 3 days of work.  </p></blockquote>


                        <table class="table" align="center">
                            <thead>

                            <c:forEach items="${staffList}" var="Staff" varStatus="sCount">

                            <tr>
                                <th style="padding:20px;border: 2px solid black">ID</th><br>
                                <td style="padding:20px;border: 2px solid black">${Staff.STAFFID}</td>
                            </tr><tr></tr>

                            <tr>
                                <th style="padding:20px;border: 2px solid black">NAME</th>
                                <td style="padding:20px;border: 2px solid black">${Staff.STAFFNAME}</td>
                            </tr>

                            <tr>
                                <th style="padding:20px;border: 2px solid black">IC</th>
                                <td style="padding:20px;border: 2px solid black">${Staff.STAFFIC}</td>
                            </tr>

                            <tr>
                                <th style="padding:20px;border: 2px solid black">ADDRESS</th>
                                <td style="padding:20px;border: 2px solid black">${Staff.STAFFADDRESS}</td>
                            </tr>

                            <tr>
                                <th style="padding:20px;border: 2px solid black">POSITION</th>
                                <td style="padding:20px;border: 2px solid black">${Staff.STAFFPOS}</td>
                            </tr>

                            <tr>
                                <th style="padding:20px;border: 2px solid black">DEPARTMENT</th>
                                <td style="padding:20px;border: 2px solid black">${Staff.STAFFDEPT}</td>
                            </tr>

                            <tr>
                                <th style="padding:20px;border: 2px solid black">EMAIL</th>
                                 <td style="padding:20px;border: 2px solid black">${Staff.STAFFEMAIL}</td>
                            </tr>

                             <tr>
                                <th style="padding:20px;border: 2px solid black">PHONE</th>
                                <td style="padding:20px;border: 2px solid black">${Staff.STAFFPHONE}</td>
                             </tr>

                             <tr>
                                <th style="padding:20px;border: 2px solid black">PASSWORD</th>
                                <td style="padding:20px;border: 2px solid black">${Staff.STAFFPASSWORD}</td>
                             </tr>

                             <tr>
                                <th style="padding:20px;border: 2px solid black">NEW EMAIL</th>
                                <td style="padding:20px;border: 2px solid black">${Staff.NEWEMAIL}</td>
                             </tr>

                            </c:forEach>

                            </thead>

                        </table>

                        <p>&nbsp;</p>

                        <a href="StaffLogin.jsp" class="btn btn-primary">Login</a>

                    </article>
                </div>

            </div>
        </main>


        <!-- Footer -->
        <div class="container-fluid footer-container">
            <footer class="footer">

                <div class="footer-bottom">
                    <p class="text-center"><a href="#">Back to top</a></p>
                </div>

            </footer>
        </div>
    </div>
</div>

<!-- Bootcamp JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>
