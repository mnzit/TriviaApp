<%@include file="../shared/header.jsp" %>
<style>
    @import url(https://fonts.googleapis.com/css?family=Cabin:700);

    /* HTML5 Boilerplate accessible hidden styles */
    [type="radio"] {
        border: 0; 
        clip: rect(0 0 0 0); 
        height: 1px; margin: -1px; 
        overflow: hidden; 
        padding: 0; 
        position: absolute; 
        width: 1px;
    }

    /* One radio button per line */
    label {
        display: block;
        cursor: pointer;
        line-height: 2.5;
        font-size: 1.5em;
    }

    [type="radio"] + span {
        display: block;
    }

    /* the basic, unchecked style */
    [type="radio"] + span:before {
        content: '';
        display: inline-block;
        width: 1em;
        height: 1em;
        vertical-align: -0.25em;
        border-radius: 1em;
        border: 0.125em solid #fff;
        box-shadow: 0 0 0 0.15em #000;
        margin-right: 0.75em;
        transition: 0.5s ease all;
        margin-left: 30px;
    }

    /* the checked style using the :checked pseudo class */
    [type="radio"]:checked + span:before {
        background: green;
        box-shadow: 0 0 0 0.25em #000;
    }

    /* never forget focus styling */
    [type="radio"]:focus + span:after {
        content: '\0020\2190';
        font-size: 1.5em;
        line-height: 1;
        vertical-align: -0.125em;
    }

    fieldset {
        font-size: 1em;
        border: 2px solid #000;
        padding: 2em;
        border-radius: 0.5em;
    }

    legend {
        color: #fff;
        background: #000;
        padding: 0.25em 1em;
        border-radius: 1em;
    }

    .p {
        text-align: center;
        font-size: 14px;
        padding-top: 120px;
    }
    .bx-wrapper{
        border: 0!important; /* border */
        -webkit-box-shadow: none!important; /* these two shadows */
        box-shadow: none!important;
    }
    button.question-btn {
        padding: 11px 16px;
        color: white;
        background: black;
        border: 0;
        border-radius: 8px;
    }

</style>
<h1 class="display-4 text-center">QUIZ</h1>
<hr class="my-4">
<form method="post">
    <ol class="bxslider">
        <c:forEach var="q" items="${requestScope.questions}">
            <c:set var="count" value="-1" scope="page" />
            <fieldset>
                <legend>${q.question}</legend>
                <c:forEach var="choice" items="${q.choice}">
                    <c:set var="count" value="${count + 1}" scope="page"/>
                    <input type="text" value=${q.id} hidden>
                    <label>
                        <input type="radio" name="${q.id}" value="${count}"> <span>${choice}</span>
                    </label>

                </c:forEach>
            </fieldset>
        </c:forEach>
    </ol>
    <button type="submit" class="question-btn float-right">Submit</button>
</form>

<script>
    $(document).ready(function () {
        $('.bxslider').bxSlider({
            infiniteLoop: false,
            hideControlOnEnd: true
        });
    });
</script>
<%@include file="../shared/footer.jsp" %>


