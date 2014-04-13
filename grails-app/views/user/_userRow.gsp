<%@ page import="employeedelight.User; employeedelight.Product" %>
<td>${userGroupInstance?.name}
</td>
<td>
    ${User.findAllByUserGroup(userGroupInstance).size()}
</td>
<td>


    <g:field min="0" maxlength="10" size="10"   onblur="${remoteFunction(controller: "userGroup",
            action: "distributePoints",
            params: '{userGroupInstance: '+userGroupInstance.id+', newValue: this.value}',
            update: [success: 'product'+userGroupInstance.id,error:''])}" id="${userGroupInstance.id}"  name="id"
             type="number"/>
</td>
