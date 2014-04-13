<%@ page import="employeedelight.UserGroup; employeedelight.Category;" %>
<div id="messages-table">
    <table class="table table-bordered">
        <thead>
        <tr>

            <th><g:message code="nul" default="Group Name"/></th>
            <th><g:message code="nul" default="Users"/></th>
            <th><g:message code="nul" default="Points"/></th>
        </tr>
        </thead>

        <tbody>

        <g:each in="${userGroupInstanceList}" status="i" var="userGroupInstance">
            <tr id="product${userGroupInstance.id}" class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <g:render template="/user/userRow" model="[userGroupInstance: userGroupInstance]"/>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>