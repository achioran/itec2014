<%@ page import="employeedelight.Permissions" %>
<div id="messages-table">
    <table class="table table-bordered">
        <thead>
        <tr>

            <th><g:message code="nul" default="Product Name"/></th>
            <th><g:message code="nul" default="Category"/></th>
            <th><g:message code="nul" default="Points"/></th>
            <th><g:message code="nul" default="Price"/></th>

            <g:if test="${userInstance.permissions !=Permissions.ADMINISTRATOR}">
                <th><g:message code="nul" default="Cost"/></th>
            </g:if>
            <g:if test="${userInstance.permissions ==Permissions.ADMINISTRATOR}">
                <th><g:message code="nul" default="Percentage"/></th>
            </g:if>

        </tr>
        </thead>

            <tbody>

            <g:each in="${productInstanceList}" status="i" var="productInstance">
                <tr id="product${productInstance.id}" class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <g:render template="/product/productRow" model="[productInstance: productInstance, totalPoints:totalPoints]"/>

                </tr>
            </g:each>
            </tbody>
    </table>

    <g:if test="${userInstance.permissions ==Permissions.ADMINISTRATOR}">
        <g:form controller="admin" action="download">
            <g:submitButton class="logoutButton" name="Download"/>
        </g:form>
    </g:if>

</div>