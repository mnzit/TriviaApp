
<%@include file="../shared/header.jsp" %>
<c:if test ="${param.error != null}"> 
    <div class="alert alert-danger" role="alert">
        Your username/password is incorrect
    </div> 
 
</c:if>

<div class="container pt-3">
  <div class="row justify-content-sm-center">
    <div class="col-sm-6 col-md-4">

      <div class="card border-info text-center">
        <div class="card-header">
          Sign in to continue
        </div>
        <div class="card-body">
          <h4 class="text-center">Login</h4>
          <form class="form-signin" method="post">
            <input type="text" name="username" class="form-control mb-2" placeholder="Email" required autofocus>
            <input type="password" name="password" class="form-control mb-2" placeholder="Password" required>
            <button class="btn btn-lg btn-primary btn-block mb-1" type="submit">Sign in</button>
          </form>
        </div>
      </div>
      <a href="${SITE_URL}/home/register" class="float-right">Create an account </a>
    </div>
  </div>
</div>
<%@include file="../shared/footer.jsp" %>


