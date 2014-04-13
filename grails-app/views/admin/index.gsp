<%@ page import="org.codehaus.groovy.grails.commons.GrailsClassUtils" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>


    <link rel="stylesheet" href="${resource(dir: 'css', file: 'contents.css')}" type="text/css">
    <r:require modules="jquery-ui, jquery"/>
    <r:layoutResources/>
</head>

<body>
<a href="#page-body" class="skip"></a>

<div id="status" role="complementary">
    <div id="user-etails">
        <g:render template="/user/userData" model="[userInstance: userInstance]"/>
    </div>

    <div id="category-list">
        <h2>Available Controllers:</h2>
        <ul>
            <g:each var="c" in="${grailsApplication.controllerClasses.findAll { cc ->
                GrailsClassUtils.getStaticPropertyValue(cc.clazz, "main")
            }}">
                <li class="controller"><g:link controller="${c.logicalPropertyName}">${c.name}</g:link></li>
            </g:each>
            <li class="controller" onclick="${remoteFunction(update: "controller-list", controller:"userGroup", action: "getGroups")}"><a href="JavaScript:void()">Assign Points To Groups</a></li>
            <li class="controller" onclick="${remoteFunction(update: "controller-list", controller:"product", action: "listCatedory")}"><a href="JavaScript:void()">Generate Report</a></li>

        </ul>

    </div>
</div>


<div id="page-body" role="main">
    <g:form controller="login" action="logout">
        <h1>Welcome ${userInstance.firstName}
        <g:submitButton class="logoutButton" name="Logout"/>
        </h1>
    </g:form>

    <div id="controller-list" role="navigation">
    </div>

</div>
</body>
</html>
