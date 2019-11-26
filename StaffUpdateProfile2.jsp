<%@ page import="poli.model.staff" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Shakhila Roszie
  Date: 2/12/2018
  Time: 3:26 AM
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

                        <blockquote><p>Please fill in the form below by entering your new personal information.</p></blockquote>

                        <p>&nbsp;</p>

                        <form class="" method="post" action="${pageContext.request.contextPath}/staffController">

                            <fieldset>
                                <legend>Update Email</legend>

                                <div class="form-group">
                                    <label>First Name</label>
                                    <input type="text" class="form-control" name="STAFFNAME" value="${Staff.STAFFNAME}" pattern="[a-zA-Z ]+" title="Character only" style="text-transform:lowercase;" required>
                                </div>

                                <div class="form-group">
                                    <label>Last Name</label>
                                    <input type="text" class="form-control" name="STAFFLASTNAME" value="${Staff.STAFFLASTNAME}" pattern="[a-zA-Z ]+" title="Character only" style="text-transform:lowercase;" required>
                                </div>

                                <div class="form-group">
                                    <label>IC</label>
                                    <input type="text" class="form-control" name="STAFFIC" value="${Staff.STAFFIC}" pattern="[0-9]{12}"  maxlength="12" title="020425045889" required>
                                </div>

                                <div class="form-group">
                                    <label>Address</label>
                                    <input type="text" class="form-control" name="STAFFADDRESS" value="${Staff.STAFFADDRESS}" style="text-transform:lowercase;" required>
                                </div>

                                <div class="form-group">
                                    <label>Position</label>
                                    <input type="text" class="form-control" name="STAFFPOS" value="${Staff.STAFFPOS}" style="text-transform:lowercase;" required>
                                </div>

                                <div class="form-group">
                                    <label>Department</label>
                                    <select name="STAFFDEPT" id="STAFFDEPT" class="form-control" value="${Staff.STAFFDEPT}" required>
                                        <option selected="selected"></option>
                                        <option>Jabatan Kejuruteraan Awam</option>
                                        <option>Jabatan Kejuruteraan Mekanikal</option>
                                        <option>Jabatan Kejuruteraan Elektrik</option>
                                        <option>Jabatan Perdagangan</option>
                                        <option>Jabatan Matematik, Sains & Komputer</option>
                                        <option>Jabatan Pengajian Am</option>
                                        <option>Jabatan Hal Ehwal & Pembangunan Pelajar</option>
                                        <option>Unit Pentadbiran</option>
                                        <option>Unit Perpustakaan</option>
                                        <option>Unit Pembangunan & Senggaraan</option>
                                        <option>Unit Latihan Industri</option>
                                        <option>Unit Kewangan</option>
                                        <option>Unit Pembangunan Instruksional & Multimedia</option>
                                        <option>Unit Kualiti</option>
                                        <option>Unit Latihan & Pendidikan Lanjutan</option>
                                        <option>Unit Peperiksaan</option>
                                        <option>Unit Penyelidikan, Inovasi & Komersilan</option>
                                        <option>Unit Teknologi Maklumat</option>
                                        <option>Unit Psikologi & Kerjaya</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label>Email</label>
                                    <input type="email" class="form-control" name="STAFFEMAIL" value="${Staff.STAFFEMAIL}" required>
                                </div>

                                <div class="form-group">
                                    <label>Phone (Eg:60112345678)</label>
                                    <input type="text" class="form-control" name="STAFFPHONE" value="${Staff.STAFFPHONE}"  pattern="[0-9]+" title="Numbers only" required>
                                </div>

                                <div class="form-group">
                                    <label>Polytechnic Email</label>
                                    <input type="text" class="form-control" name="NEWEMAIL" value="${Staff.NEWEMAIL}"  readonly>
                                </div>

                                <div class="form-group">
                                    <label>Password</label>
                                    <input type="text" class="form-control" name="STAFFPASSWORD" value="${Staff.STAFFPASSWORD}" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>

                                    <input type="hidden" name="action" value="update-staff">
                                    <input type="hidden" name="STAFFID" value="${Staff.STAFFID}" />
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