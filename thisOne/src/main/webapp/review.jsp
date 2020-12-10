<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="WEB-INF/styles.css" rel="stylesheet" type="text/css">
<html lang="en">
<title>AA - Review</title>
<%@ include file="WEB-INF/head.html" %>
<header>
    <h1>ART ARCHIVE - Review Artist</h1>
</header>

<body>
    <%@ include file="WEB-INF/navbar.html" %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>

        <link href="${pageContext.request.contextPath }/assets/css/jquery.rateyo.min.css" rel="stylesheet"
            type="text/css">

        <script src="${pageContext.request.contextPath }/assets/js/jquery.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath }/assets/js/jquery.rateyo.min.js"
            type="text/javascript"></script>

        <script type="text/javascript">

            $(function () {

                $("#rating").rateYo({
                    rating: 0,
                    numStars: 5,
                    maxValue: 5,
                    halfStar: true,
                    onChange: function (rating, rateYoInstance) {
                        $('#hdrating').val(rating);
                    }
                });

            });


        </script>

    </head>

    <body>
        <div class="container">
            <div class="row">
                <h2>Reviews</h2>
            </div>
        </div>
        <div class="carousel-reviews broun-block">
            <div class="container">
                <div class="row">
                    <div id="carousel-reviews" class="carousel slide" data-ride="carousel">

                        <div class="carousel-inner">
                            <div class="item active">
                                <c:forEach var="review" items="${listReview}" varStatus="loop">
                                    <div style="display: flex; flex-wrap: wrap;">
                                        <div style="background-color: aliceblue; padding: 2em;">
                                            <h3>
                                                <c:out value="${review[0].name}" />
                                            </h3>
                                            <h5>Rating:
                                                <c:out value="${review[1].stars}" /> ★</h5>
                                            <p>
                                                <c:out value="${review[1].review}" />
                                            </p>
                                            <p>
                                                <c:out value="${review[1].user}" /></p>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>

                        </div>
                        <a class="left carousel-control" href="#carousel-reviews" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                        </a>
                        <a class="right carousel-control" href="#carousel-reviews" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>