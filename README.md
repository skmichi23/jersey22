jersey22
========

Example Java Jersey project

there are two POST methods:

http://localhost:8080/jersey22/app/myresource/working
- accepts String and then parses it using ObjectMapper to Reservation object

http://localhost:8080/jersey22/app/myresource/notworking
- accepts JSON and should parse it automatically to Reservation object


JSON used for testing:
{   
  "name":"john",
  "params":{
    "foo":"bar",
    "title":"anything"
  }
}


What I expect is to get object of Reservation class with property "name" set to "john"
and HashMap "params" containing keys "foo" and " with value "bar" and key "title" containing value "anything"
