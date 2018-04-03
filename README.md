# reactive-thymeleaf


Example application to display real-time data to screen.

Thanks to project Reactor (Spring's reactive streams), we can subscribe to an even Publisher and display the data whenever is broadcasted down to the Subscribers.

This example spring-boot app, shows a page that changes overtime:

---Title

-- Empty Table

-- A message



After 1 second



---Title

-- 1 ROW

-- A message



After 2 second


---Title

-- 2 ROWS

-- A message


... and so on
