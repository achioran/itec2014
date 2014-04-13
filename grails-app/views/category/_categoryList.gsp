<%@ page import="employeedelight.Category" %>
<div id="category-table">
    <ul>
<g:each in="${Category.getAll()}" status="i" var="categoryInstance">
    <li>
       <g:remoteLink controller="product" update="controller-list" action="listCatedory" params="[categoryId:categoryInstance.id]" >
           ${categoryInstance.name}
       </g:remoteLink>
    </li>
    </g:each>

    </ul>

</div>