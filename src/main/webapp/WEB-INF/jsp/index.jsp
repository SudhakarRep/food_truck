<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head>
  
    <title>Food Truck</title>
  
    <style type="text/css">
        .circle {
            width: 130px;
            height: 130px;
            border-radius: 50%;
            float: left;
            margin-right: 50px;
        }        
        .rounded {
            width: 330px;
            height: 230px;
            border-radius: 10%;
            float: left;
            margin-right: 5px;
            text-align:justify;

        }
        .square {
            width: 130px;
            height: 130px;
            border-radius: 0%;
            float: left;
            margin-right: 5px;
        }        
        #circle {
            background-color: #196F3D;
        }
        #rounded {
            background-color: #faf4e3;
        }        
        #square {
            background-color: #58D68D;
        }
    </style>
</head>
  
<body>
<div class="container-fluid bg-light myBorder">
    <form action="/home/search" method="post">
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
    <h4>Food Truck</h4>
    
    
    <c:forEach items="${list}" var="foodTruck">
	    
	     <div class="rounded" id="rounded">
		    &nbsp;</br> 
		    <ul>
		    <li><b><c:out value="${foodTruck.applicant}"></c:out></b></li>
		    <li>Food Items: <c:out value="${foodTruck.foodItems}"></c:out></li>		    
		    <li>Description: <c:out value="${foodTruck.locationDescription}"></c:out> </li>
		    <li>Facility Type: <c:out value="${foodTruck.facilityType}"></c:out></li>
		    <li>Address: <c:out value="${foodTruck.address}"></c:out> </li>
		    <li>Zipcode: <c:out value="${foodTruck.zipCodes}"></c:out> </li>
		    <li>Status: <c:out value="${foodTruck.status}"></c:out> </li>
		    
		    </ul>
	    </div>
	    
	              
        </c:forEach>
        
</div>

<div><br></div>
    
</body>
</html>

<jsp:include page="footer.jsp"></jsp:include>