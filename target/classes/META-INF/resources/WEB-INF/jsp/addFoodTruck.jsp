<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"></jsp:include>



<div class="container myBorder">
    <form action='/foodtruck/add' method='post' modelAttribute="addFoodTruck">
        <h4> Add New Food Truck Record:</h4>
        <table class='table table-hover table-responsive table-bordered rounded-lg'>
            <tr>
                <td><b>Applicant</b></td>
                <td><input type='text' name='applicant' class='form-control' size="100" required
                           value=""/></td>
            </tr>
            <tr>
                <td><b>Facility Type</b></td>
                <td>
                    <select class="form-control" path="facilityType" id="facilityType" name="facilityType">
		                <option value="">By Facility Type</option>
					     <c:forEach var="facilityTypeValue" items="${facilityType}">
					         <option value="${facilityTypeValue}">${facilityTypeValue}</option>
					     </c:forEach>
					</select>
                </td>
            </tr>
			<tr>
                <td><b>Food Items</b></td>
                <td><input type='text' name='foodItems' class='form-control' required size="200"
                           value=""/></td>

            </tr>
            <tr>
                <td><b>Address</b></td>
                <td><input type='text' name='address' class='form-control' required size="100"
                           value=""/></td>

            </tr>
                        
            <tr>
                <td><b>Status</b></td>
                <td>
                
                    <select class="form-control" path="status" id="status" name="status">
                		<option value="">By Status</option>
			     		<c:forEach var="statusValue" items="${status}">
			         		<option value="${statusValue}">${statusValue}</option>
			     		</c:forEach>
					</select>
                           </td>

            </tr>

            <tr>
                <td colspan="2">
                    <button type="submit" class="btn btn-primary">Save Food Truck Information</button>
                </td>
            </tr>

        </table>
    </form>
</div>

<jsp:include page="footer.jsp"></jsp:include>