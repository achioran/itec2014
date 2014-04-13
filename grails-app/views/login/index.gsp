<%@ page import="employeedelight.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>

    <r:layoutResources/>
</head>

<body>
<div id="page-body" role="main">

    <g:form controller="login" action="signup">
        <label>First Name:</label>
        <g:textField name="firstName" value="${flash.signupForm?.firstName?.encodeAsHTML()}"/><br/>
        <g:hasErrors bean="${flash.signupFormErrors}" field="email">
            <g:renderErrors bean="${flash.signupFormErrors}"
                            as="list"
                            field="email"/></g:hasErrors>

        <label>Last Name</label>
        <g:textField name="lastName" value="${flash.signupForm?.lastName?.encodeAsHTML()}"/><br/>
        <g:hasErrors bean="${flash.signupFormErrors}" field="lastName">
            <g:renderErrors bean="${flash.signupFormErrors}"
                            as="list"
                            field="lastName"/></g:hasErrors>

        <label>Email:</label>
        <g:textField name="email" value="${flash.signupForm?.email?.encodeAsHTML()}"/><br/>
        <g:hasErrors bean="${flash.signupFormErrors}" field="email">
            <g:renderErrors bean="${flash.signupFormErrors}"
                            as="list"
                            field="email"/></g:hasErrors>


        <label>userName:</label>
        <g:textField name="login" value="${flash.signupForm?.login?.encodeAsHTML()}"/><br/>
        <g:hasErrors bean="${flash.signupFormErrors}" field="login"><g:renderErrors bean="${flash.signupFormErrors}"
                                                                                    as="list"
                                                                                    field="login"/></g:hasErrors>

        <label>Password:</label>
        <input name="password" value="" type="password"/>
        <br/>
        <g:hasErrors bean="${flash.signupFormErrors}" field="password"><g:renderErrors bean="${flash.signupFormErrors}"
                                                                                    as="list"
                                                                                    field="password"/></g:hasErrors>
        <g:submitButton name="submit"/>
    </g:form>

    <g:form name="login" controller="login" action="login">

        <g:textField name="username"/>
        <g:passwordField name="password"/>
        <g:submitButton name="button"/>
    </g:form>
</div>
</body>
</html>
