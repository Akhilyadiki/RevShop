<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Buyer Homepage</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Set carousel to occupy 40% of the window height */
        .carousel {
            height: 40vh;
            overflow: hidden;
        }

        .carousel-inner img {
            object-fit: cover;
            height: 100%;
            width: 100%;
        }
    </style>
</head>
<body>
<%@include file = "comp/navbar.jsp"%>
<div class="container mt-5">
    <!-- Carousel -->
    <div id="itemCarousel" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
            <c:forEach var="item" items="${featuredItems}" varStatus="status">
                <div class="carousel-item ${status.index == 0 ? 'active' : ''}">
                    <img src="${item.imageUrl}" class="d-block w-100" alt="${item.name}">
                    <div class="carousel-caption d-none d-md-block">
                        <h5>${item.name}</h5>
                        <p>${item.description}</p>
                    </div>
                </div>
            </c:forEach>
        </div>
        <a class="carousel-control-prev" href="#itemCarousel" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#itemCarousel" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>

    <!-- Categories -->
    <div class="row mt-5">
        <c:forEach var="category" items="${categories}">
            <div class="col-md-3 mb-4">
                <div class="card h-100">
                    <img src="${category.imageUrl}" class="card-img-top" alt="${category.name}">
                    <div class="card-body text-center">
                        <h5 class="card-title">${category.name}</h5>
                        <a href="category-items?category=${category.name}" class="btn btn-primary">View Items</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
