# CinnamonCinemas
Cinnamon Cinemas Seat Allocation Tech Returner Project

<p>User Story</p>
<p>As a Cinnamon Cinemas Movie Theatre Manager
I want to allocate seats to customers
So that I can control reserved seating for the theatre
GIVEN a customer wants to request some tickets
WHEN they request a number of seats between 1 and 3 for a movie
THEN the customer should be allocated the required number of seats
from the available seats on the seating plan
AND the seats should be recorded as allocated</p>

<p>Acceptance Criteria and Assumptions
Write a program that allocates seats based on a random integer “number of seats” between 1 and 3
Your program should allocate the required number of seats from the available seats starting from seat A1 and filling the auditorium from 
left to right, front to back
All of the seats are available for sale when the program starts
The program should continue to allocate a random number of seats until it finds there are not enough seats left to complete the request
Once there are not enough seats available to be allocated then the program can halt.</p>

<p>UML </p>
<p>Class diagram contains objects for seat, cinema, seat allocation, and seat request validation. To separate concerns.</p>

<p>Testing Strategy</p>

<p>2 Tests for seat request validator to validate the request for number of seats, validate that number requested between 1-3</p>
<p>2 Tests to allocate a seat and multiple seats</p>

<p>Future implementation</p>
<p>Seat request validator - to check there is seat availability</p>
<p>Stub a test helper method for random number input</p>
<p>Implement main application</p>
