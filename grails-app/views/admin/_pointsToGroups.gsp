<%@ page import="employeedelight.UserGroup" %>
<div id="groups-table">
    <ul>
        <g:each in="${UserGroup.getAll()}" status="i" var="groupInstance">
            <li>
                <g:remoteLink controller="product" update="productList" action="listCatedory" params="[categoryId:categoryInstance.id]" >
                    ${categoryInstance.name}
                </g:remoteLink>
            </li>
        </g:each>


    </ul>


</div>