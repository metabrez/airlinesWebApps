# airlinesWebApps
# BaseUrl : http://localhost:8080/airlinesWebApp/rs/

#AirLineService: 1.To get list of Airline Method: GET URL : http://localhost:8080/airlinesWebApp/rs/airline/list Response : [{"id":2,"name":"SkyTeam"},{"id":10,"name":"oneworld"},{"id":17,"name":"North Star"},{"id":4251,"name":"Prawez"},{"id":4351,"name":"Tabrez"}]

2.To get Airline by flight Method: GET URL :http://localhost:8080/airlinesWebApp/rs/airline/flight/9 Response : {"id":10,"name":"oneworld"}
3 To Create Airline Method: POST URL : http://localhost:8080/airlinesWebApp/rs/airline/create Parameter : {"name": "Rizwan"} {"id":4401,"name":"Rizwan"}
 
  4 To Update Airline Method: PUT URL : http://localhost:8080/airlinesWebApp/rs/airline/update Parameter : {"id": 4401,"name": "Meraj"} Response : {"id": 4401,"name": "Meraj"}

4 To Delete Airline Method: DELETE URL : http://localhost:8080/airlinesWebApp/rs/airline/delete Parameter : {"id": 4401,"name": "Meraj" Response : 200

5 To get List of by Airline name Method : GET URL : http://localhost:8080/airlinesWebApp/rs/airline/flight/oneworld Response : [{"id":10,"name":"oneworld"},{"id":10,"name":"oneworld"},{"id":10,"name":"oneworld"},{"id":10,"name":"oneworld"}]

#AirPlaneService: #AirPortService: #FlightService: These all are similar to airport service

JSF Screenshot in my google drive
https://drive.google.com/drive/folders/0B2aUhALI67TtV2hmUjRCUG8tc2s
