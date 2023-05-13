<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="custT" uri="/WEB-INF/customtaglib.tld" %>

<jsp:include page="header.jsp"></jsp:include>

<div class="container myBorder">
    <form action='/foodtruck/edit/${foodTruck.foodTruckId}' method='post' modelAttribute="editFoodTruck">
        <h4> Edit Food Truck Record:</h4>
        <table class='table table-hover table-responsive table-bordered rounded-lg'>
            <tr>
                <td><b>Applicant</b></td>
                <td><input type='text' name='applicant' class='form-control' size='100' required
                           value="${custT:escapeJS(foodTruck.applicant)}" />
                           
                           </td>
            </tr>
            <tr>
                <td><b>Facility Type</b></td>
                <td><input type='text' readonly name='facilityType' class='form-control' required value="${foodTruck.facilityType}"/></td>
            </tr>
   			<tr>
                <td><b>Food Items</b></td>
                <td><input type='text' name='foodItems' class='form-control' required size="200"
                           value='${custT:escapeJS(foodTruck.foodItems)}' /></td>

            </tr>
            
            <tr>
                <td><b>Address</b></td>
                <td><input type='text' name='address' class='form-control' required size="100"
                           value='${custT:escapeJS(foodTruck.address)}'  />
                </td>
            </tr>
            <tr>
                <td><b>Status</b></td>
                <td>
                    <input type='text' readonly name='status' class='form-control' required 
                           value="${foodTruck.status}"/>
                </td>
            </tr>
           
            <tr>
                <td colspan="2">
                    <button type="submit" class="btn btn-primary">Update Food Truck Information</button>
                </td>
            </tr>
        </table>
    </form>
</div>

<jsp:include page="footer.jsp"></jsp:include>