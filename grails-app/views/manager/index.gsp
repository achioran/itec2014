<!DOCTYPE html>
<%@ page import="employeedelight.Permissions; employeedelight.Product;employeedelight.Category" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>


    <link rel="stylesheet" href="${resource(dir: 'css', file: 'contents.css')}" type="text/css"/>
    <r:require modules="jquery-ui, jquery"/>
    <r:layoutResources/>
</head>

<body>
<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>


<div id="status" role="complementary">
    <div id="user-etails">
        <g:render template="/user/userData" model="[userInstance: userInstance]"/>
    </div>
    <g:if test="${userInstance.permissions ==Permissions.ADMINISTRATOR}">
        <g:link controller="admin">Admin Pannel</g:link>
        <br/>
    </g:if>
    <br/>

    <div id="category-list">


        <g:render template="/category/categoryList"/>
    </div>
</div>

<div id="page-body" role="main">
    <g:form controller="login" action="logout">
        <h1>Welcome ${userInstance.firstName}
        <g:submitButton class="logoutButton" name="Logout"/>
        </h1>
    </g:form>

</br></br>
    <div id="controller-list" role="navigation">
        <div id="productList">
            <g:render template="/product/listBody" model="[userInstance: userInstance]"/>
        </div>
    </div>
</div>

</body>
</html>
