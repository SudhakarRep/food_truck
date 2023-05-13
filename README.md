# Food Truck
Spring framework with a UI, API, and Database that can load it from CSV and display and do search for Food Truck.
● Database used H2. 
● Food Truck table will gets create and dump the data from the CSV file placed in the "resources" folder and the file name is Mobile_Food_Facility_Permit.csv
● Application UI with a header, footer, index, manage page and search box etc. 
● Application allows user to see the list of food truck and can do search and also manage it.
● Provided REST END Points to search the Food Trucks based on the Food Items and Address
  curl -X POST http://localhost:8080/api/v1/foodtruck/search -H "Content-Type: application/json" -d '{"address": "ST", "foodItems":"taco" }' 
