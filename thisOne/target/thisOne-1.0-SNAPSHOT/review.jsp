
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<title>AA - Review</title>
<%@ include file="WEB-INF/head.html" %>
<header><h1>ART ARCHIVE - Review Artist</h1></header>
<body>
<%@ include file="WEB-INF/navbar.html" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>

    <link
            href="${pageContext.request.contextPath }/assets/css/jquery.rateyo.min.css"
            rel="stylesheet" type="text/css">

    <script src="${pageContext.request.contextPath }/assets/js/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/assets/js/jquery.rateyo.min.js" type="text/javascript"></script>

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

<h3>Product Info</h3>
<a href="product">Back</a>
<table border="1">
    <tr>
        <td>Id</td>
        <td>${product.id }</td>
    </tr>
    <tr>
        <td>Name</td>
        <td>${product.name }</td>
    </tr>
    <tr>
        <td>Price</td>
        <td>${product.price }</td>
    </tr>
    <tr>
        <td>Photo</td>
        <td><img src="assets/images/${product.photo }" width="60"></td>
    </tr>
</table>

<h3>Ratings and Review</h3>

<table border="1" cellpadding="2" cellspacing="2">
    <c:forEach var="r" items="${product.reviews }" varStatus="i">
        <tr>
            <td>
                    ${r.account.username }
                <br>
                <script type="text/javascript">

                    $(function () {

                        $('#rating${i.index }').rateYo({
                            rating: ${r.rating },
                            readOnly: true
                        });

                    });


                </script>
                <div id="rating${i.index }"></div>
                <br>
                    ${r.content }
            </td>
        </tr>
    </c:forEach>
</table>

<c:if test="${sessionScope.username == null }">
    <a href="account?action=login">Login to post your reviews</a>
</c:if>

<c:if test="${sessionScope.username != null }">

    <form method="post" action="product?action=send">
        <table>
            <tr>
                <td>Rating</td>
                <td>
                    <div id="rating"></div>
                    <input type="hidden" name="hdrating" id="hdrating">
                </td>
            </tr>
            <tr>
                <td valign="top">Content</td>
                <td><textarea name="content" rows="5" cols="20"></textarea></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>
                    <input type="submit" value=Send>
                    <input type="hidden" name="productId" value="${product.id }">
                </td>
            </tr>
        </table>
    </form>

</c:if>

</body>
</html>