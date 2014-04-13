<%@ page import="employeedelight.Permissions; employeedelight.Product" %>
<td>${productInstance?.name}
</td>
<td>
    ${productInstance.category.toString()}
</td>
<td>
    ${productInstance.acumulatedPoints}
</td>
<td>
    ${productInstance.price}
</td>


<g:if test="${userInstance.permissions != Permissions.ADMINISTRATOR}">
    <td>

        <g:field min="0" maxlength="10" size="10" max="${userInstance.assignedPoints}"
                 onblur="${remoteFunction(controller: "product",
                         onSuccess: "${remoteFunction(controller: "user", action: "getPoints", update: [success: "availablePoints"])}",
                         action: "updateScore",
                         params: '{productInstance: ' + productInstance.id + ', newValue: this.value}',
                         update: [success: 'product' + productInstance.id, error: ''])}" id="${productInstance.id}"
                 name="id"
                 type="number"/>
    </td>
</g:if>

<g:if test="${userInstance.permissions == Permissions.ADMINISTRATOR}">
    <td>

        ${(100.div(totalPoints)*productInstance.acumulatedPoints).trunc(1)}
    </td>
</g:if>

