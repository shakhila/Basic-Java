<%@ page import="poli.model.staff" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Shakhila Roszie
  Date: 2/12/2018
  Time: 3:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    if(session.getAttribute("user") == null){
        response.sendRedirect("/poli/AdminIndex.jsp");
    }
    else {
        staff Staff=(staff) session.getAttribute("user");

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
            <h2>Welcome &nbsp <%=Staff.getSTAFFNAME()%>!</h2>
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
                            <a class="nav-link" href="StaffIndex2.jsp">Home</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/staffController?action=displayPersonalDetails">My Profile</a>
                        </li>

                        <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.request.contextPath}/staffController?action=displayDetails">Update Profile <span class="sr-only">(current)</span></a>
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
                    <h1 class="text-center">Update Profile</h1>
                </div>
            </div>
        </div>

        <!-- Main content area -->
        <main class="container-fluid">
            <div class="row">

                <!-- Main content -->
                <div class="col-sm-8">
                    <article>

                        <table class="table" align="center">
                            <thead>
                            <tr>
                                <th style="padding:20px;border: 2px solid black">ID</th><br>
                                <td style="padding:20px;border: 2px solid black"><%=Staff.getSTAFFID()%></td>
                            </tr><tr></tr>
                            <tr>
                                <th style="padding:20px;border: 2px solid black">First Name</th>
                                <td style="padding:20px;border: 2px solid black"><%=Staff.getSTAFFNAME()%></td>
                            </tr>
                            <tr>
                                <th style="padding:20px;border: 2px solid black">Last Name</th>
                                <td style="padding:20px;border: 2px solid black"><%=Staff.getSTAFFLASTNAME()%></td>
                            </tr>
                            <tr>
                                <th style="padding:20px;border: 2px solid black">IC</th>
                                <td style="padding:20px;border: 2px solid black"><%=Staff.getSTAFFIC()%></td>
                            </tr>
                            <tr>
                                <th style="padding:20px;border: 2px solid black">Address</th>
                                <td style="padding:20px;border: 2px solid black"><%=Staff.getSTAFFADDRESS()%></td>
                            </tr>
                            <tr>
                                <th style="padding:20px;border: 2px solid black">Position</th>
                                <td style="padding:20px;border: 2px solid black"><%=Staff.getSTAFFPOS()%></td>
                            </tr>
                            <tr>
                                <th style="padding:20px;border: 2px solid black">Department</th>
                                <td style="padding:20px;border: 2px solid black"><%=Staff.getSTAFFDEPT()%></td>
                            </tr>
                            <tr>
                                <th style="padding:20px;border: 2px solid black">Email</th>
                                <td style="padding:20px;border: 2px solid black"><%=Staff.getSTAFFEMAIL()%></td>
                            </tr>
                            <tr>
                                <th style="padding:20px;border: 2px solid black">Phone</th>
                                <td style="padding:20px;border: 2px solid black"><%=Staff.getSTAFFPHONE()%></td>
                            </tr>
                            <tr>
                                <th style="padding:20px;border: 2px solid black">Password</th>
                                <td style="padding:20px;border: 2px solid black"><%=Staff.getSTAFFPASSWORD()%></td>
                            </tr>
                            <tr>
                                <th style="padding:20px;border: 2px solid black">New Email</th>
                                <td style="padding:20px;border: 2px solid black"><%=Staff.getNEWEMAIL()%></td>
                            </tr>
                            <tr>
                                <th style="padding:20px;border: 2px solid black">Action</th>
                                <td style="padding:20px;border: 2px solid black"><button type="submit" class="btn btn-success"><a href="${pageContext.request.contextPath}/staffController?action=updateStaff&STAFFID=<%=Staff.getSTAFFID()%>">Update</a></button>

                            </tr>

                            </thead>

                            <tbody>




                            </tbody>
                        </table>

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