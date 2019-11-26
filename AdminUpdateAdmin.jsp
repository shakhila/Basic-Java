<%--
  Created by IntelliJ IDEA.
  User: Shakhila Roszie
  Date: 22/10/2018
  Time: 10:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    if(session.getAttribute("user") == null){
        response.sendRedirect("/poli/AdminLogin.jsp");
    }
    else {
%>
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
                            <a class="nav-link" href="AdminIndex.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/staffController?action=displayPersonalDetails">My Profile</a>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#MenuDropdown" data-toggle="collapse" aria-controls="MenuDropdown" aria-expanded="false">Manage Email</a>
                            <ul id="MenuDropdown" class="sub-navbar collapse flex-column">
                                <li class="nav-item"><a class="nav-link" href="AdminCreateEmail.jsp">Create New Email</a></li>
                                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/staffController?action=displayAllStaff">View Email</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#Dropdown" data-toggle="collapse" aria-controls="MenuDropdown" aria-expanded="false">Manage Admin</a>
                            <ul id="Dropdown" class="sub-navbar collapse flex-column">
                                <li class="nav-item"><a class="nav-link" href="AdminCreateAdmin.jsp">Create New Admin</a></li>
                                <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/adminController?action=displayAllAdmin">View Admin <span class="sr-only">(current)</span></a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="home.jsp" onclick="return confirm('Confirm Logout?')">Logout</a>
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
                    <h1 class="text-center">Update Admin</h1>
                </div>
            </div>
        </div>

        <!-- Main content area -->
        <main class="container-fluid">
            <div class="row">

                <!-- Main content -->
                <div class="col-sm-8">
                    <article>

                        <blockquote><p>Please fill in the form below by entering your new personal information.</p></blockquote>

                        <p>&nbsp;</p>

                        <form class="" method="post" action="${pageContext.request.contextPath}/adminController">

                            <fieldset>
                                <legend>Update Admin</legend>

                                <div class="form-group">
                                    <label>Name</label>
                                    <input type="text" class="form-control" name="ADMNAME" value="${Admin.ADMNAME}"  pattern="[a-zA-Z ]+" title="Character only" style="text-transform:lowercase;" required>
                                </div>

                                <div class="form-group">
                                    <label>IC</label>
                                    <input type="text" class="form-control" name="ADMIC" value="${Admin.ADMIC}" pattern="[0-9]{12}"  maxlength="12" title="020425045889" required>
                                </div>

                                <div class="form-group">
                                    <label>Phone</label>
                                    <input type="text" class="form-control" name="ADMPHONE" value="${Admin.ADMPHONE}" pattern="[0-9]+" title="Numbers only" required>
                                </div>

                                <div class="form-group">
                                    <label>Username</label>
                                    <input type="text" class="form-control" name="ADMUSERNAME" value="${Admin.ADMUSERNAME}" required>
                                </div>

                                <div class="form-group">
                                    <label>Password</label>
                                    <input type="text" class="form-control" name="ADMPASSWORD" value="${Admin.ADMPASSWORD}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>


                                    <input type="hidden" name="action" value="update-admin">
                                    <input type="hidden" name="ADMID" value="${Admin.ADMID}" />
                                    <button type="submit" class="btn btn-primary" onclick="return confirm('Confirm Update this Data?')">Submit</button>
                                </div>
                            </fieldset>
                        </form>

                        <p>&nbsp;</p>

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
<%
    }
%>