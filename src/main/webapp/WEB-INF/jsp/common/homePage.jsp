<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:import url="/WEB-INF/jsp/common/header.jsp" />


<html>
<div class="text">
    <c:url var="home" value="/img/Homepage.jpg" />
    <img align="center" src="${home}" class="img-fluid" alt="Welcome!">
</div>


<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-4">
                    <c:url var="ratingStars" value="/img/RatingStars.png" />
                    <img src="${ratingStars}" alt="ratingStar" height="150px"/>
                    <figure>
                        <blockquote class="blockquote">
                            <p class="mb-0">Best online bootcamp ever. Found a job a week after last project.</p>

                        </blockquote>
                        <figcaption class="blockquote-footer">
                            John Doe <cite title="Source Title">Full Stack Developer at Apple Inc.</cite>
                        </figcaption>
                    </figure>
                </div>
                <div class="col-md-4">
                    <c:url var="ratingStars" value="/img/RatingStars.png" />
                    <img src=""${ratingStars}" alt="ratingStar" height="150px"/>
                    <figure class="text-center">
                        <blockquote class="blockquote">
                            <p class="mb-0">Great experience! Finally a course where I can manage my own schedule.</p>

                        </blockquote>
                        <figcaption class="blockquote-footer">
                            Emily C. <cite title="Source Title">from Microsoft.</cite>
                        </figcaption>
                    </figure>
                </div>
                <div class="col-md-4">
                    <c:url var="ratingStars" value="/img/RatingStars.png" />
                    <img src="${ratingStars}" alt="ratingStar" height="150px"/>
                    <figure class="text-end">
                        <blockquote class="blockquote">
                            <p class="mb-0">Excellent, simple to use website allowed me to easily learn all the contents I needed for a raise..</p>

                        </blockquote>
                        <figcaption class="blockquote-footer">
                            Robert Harris from <cite title="Source Title">Tesla co.</cite>
                        </figcaption>
                    </figure>
                </div>
            </div>
        </div>
    </div>
</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />