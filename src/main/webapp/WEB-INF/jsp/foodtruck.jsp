<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"></jsp:include>

<div class="container-fluid bg-light myBorder">
    <form action="/foodtruck/search" method="post">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-2 pt-3">
                <div class="form-group ">
                    <input type="text" placeholder="By applicant" name="applicant" class="form-control">
                </div>
            </div>
            <div class="col-md-2 pt-3">
                <div class="form-group">
                      <select class="form-control" path="facilityType" id="facilityType" name="facilityType">
		                <option value="">By Facility Type</option>
					     <c:forEach var="facilityTypeValue" items="${facilityType}">
					         <option value="${facilityTypeValue}">${facilityTypeValue}</option>
					     </c:forEach>
						</select>
                </div>
            </div>
            <div class="col-md-2 pt-3">
                <div class="form-group">
                    <input type="text" placeholder="By Food Items" name="foodItems" class="form-control">
                </div>
            </div>
            <div class="col-md-2 pt-3">
                <div class="form-group">
                    <input type="text" placeholder="By address" name="address" class="form-control">
                </div>
            </div>
            <div class="col-md-2 pt-3">
                <div class="form-group">
                               
                <select class="form-control" path="status" id="status" name="status">
                <option value="">By Status</option>
			     <c:forEach var="statusValue" items="${status}">
			         <option value="${statusValue}">${statusValue}</option>
			     </c:forEach>
				</select>
                    
                </div>
            </div>
            <div class="col-md-2">
                <button type="submit" class="btn btn-primary btn-block" target=" ">Search</button>
            </div>
        </div>
    </form>
</div>
<div><br></div>

<div class="container-fluid bg-light myBorder">
    <h4>Food Trunk Records:</h4>
    <table class="table table-bordered table-striped text-center">
        <thead>
        <tr class="text-center">
            <th class="text-center"><b>Applicant</b></th>
            <th class="text-center"><b>Facility Type</b></th>
            <th class="text-center"><b>Food Items</b></th>
            <th class="text-center"><b>Address</b></th>
            <th class="text-center"><b>Status</b></th>
            
            <th class="text-center" colspan='2'><b> Operation</b></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${list}" var="foodTruck">
            <tr>
                <td><c:out value="${foodTruck.applicant}"></c:out></td>
                <td><c:out value="${foodTruck.facilityType}"></c:out></td>
                <td><c:out value="${foodTruck.foodItems}"></c:out></td>
                <td><c:out value="${foodTruck.address}"></c:out></td>
                <td><c:out value="${foodTruck.status}"></c:out></td>
              
                <td>
                    <a href="/foodtruck/edit?foodTruckId=${foodTruck.foodTruckId}">
                        <button type="submit" class="btn btn-primary">Edit</button>
                    </a>

                    <a href="/foodtruck/delete?foodTruckId=${foodTruck.foodTruckId}">
                        <button type="submit" class="btn btn-danger"
                                onclick="alert(' !! Warning !! Food Trunk record will be deleted.')">Delete
                        </button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div><br></div>






<jsp:include page="footer.jsp"></jsp:include>