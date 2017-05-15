<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <link href="http://maxcdn.bootstrapcdn.com/bootswatch/3.3.4/flatly/bootstrap.min.css" rel="stylesheet">
    <link href="http://cdn.jsdelivr.net/flat-ui/2.2.2/css/flat-ui.min.css" rel="stylesheet">
  <style>
	html, body, .container {
            height: 100%;
            width: 100%;
        }
        .container {
            display: table;
            vertical-align: middle;
        }
        .col-center-block {
            float: none;
            display: block;
            margin-left: auto;
            margin-right: auto;
        }
        .vertical-center-row {
            display: table-cell;
            vertical-align: middle;
        }
        .vs-big-font {
            font-size: 91px;
        }
        .vs-screen-bg {
            background-color: #000;
        }
</style>
</head>
<body class="vs-screen-bg">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="home">SHOP WORLD</a>
    </div>
    <ul class="nav navbar-nav">
 
      <li><a href="product">product</a></li>
      <li><a href="contact">AboutUS</a></li>
      <li><a href="contact">ContactUs</a></li>
    </ul>  
     <ul class="nav navbar-nav navbar-right">
      <li><a href="registration"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
    <form action="validate" method="post">
    <div class="container">
        <div class="row vertical-center-row">
            <div class="col-xs-12 col-sm-8 col-md-6 col-center-block">
                <div class="row">
                    <div class="col-sm-2 col-md-3">
                        <div class="text-center">
                            <div class="fui-mail vs-big-font"></div>
                            <h6>Welcome to <small>Mail App</small></h6>
                        </div>
                    </div>
                    <div class="col-sm-10 col-md-9">
                        <div class="login-form">
                            <div class="form-group">
                                <input type="text" class="form-control login-field" value="" placeholder="Enter your name" id="login-name">
                                <label class="login-field-icon fui-user" for="login-name"></label>
                            </div>

                            <div class="form-group">
                                <input type="password" class="form-control login-field" value="" placeholder="Password" id="login-pass">
                                <label class="login-field-icon fui-lock" for="login-pass"></label>
                            </div>

                            <a class="btn btn-primary btn-lg btn-block" href="home">Log in</a>
                            <a class="login-link" href="http://www.jquery2dotnet.com/" target="_blank">Lost your password?</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </form>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="http://cdn.jsdelivr.net/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script>
        (function (i, s, o, g, r, a, m) {
            i['GoogleAnalyticsObject'] = r; i[r] = i[r] || function () {
                (i[r].q = i[r].q || []).push(arguments)
            }, i[r].l = 1 * new Date(); a = s.createElement(o),
            m = s.getElementsByTagName(o)[0]; a.async = 1; a.src = g; m.parentNode.insertBefore(a, m)
        })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');
        ga('create', 'UA-46102911-5', 'auto');
        ga('send', 'pageview');
    </script>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>