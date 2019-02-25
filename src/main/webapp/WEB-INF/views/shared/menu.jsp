<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Elephant</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${SITE_URL}/home">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="${SITE_URL}/question">Quiz</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="${SITE_URL}/home/about">About</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="${SITE_URL}/home/facts"> Interesting Facts</a>
            </li>

            <c:choose>
                <c:when test ="${sessionScope.username == null}">
                    <li class="nav-item active">
                        <a class="nav-link" href="${SITE_URL}/home/login">Login</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item active">
                        <a class="nav-link" href="${SITE_URL}/home/logout">Logout</a>
                    </li>
                </c:otherwise>
            </c:choose>
    </div>
</nav>