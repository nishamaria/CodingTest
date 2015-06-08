#Coding Assessment Guidelines

To validate a candidates skills in developing for mobile applications, we would like you to create a small application. We anticipate this challenge should take no more that 1-2 hours.

The task we would like you to complete is to create a basic app that makes a call to a RESTful web service, and display the data that is returned in the response on the screen of the mobile app, changing the interface (UI) according to the forecast being returned (clear, sunny, raining, etc.). The app only needs to make a single call at launch, and design skills are not being assessed. 

Some key elements we will be looking for in the application are:
*	Use of suitable design patterns, and a strict separation of concerns when developing a mobile application. 
*	UI interaction and data binding principals.
*	Management of User Interface.
*	Correct use of the application life cycle, management of the UI thread, and async development principals when displaying data and making network calls. 
*	Unit tests/mocks to demonstrate the code is testable. 

##Getting Started
*	Register for a free API key at: https://developer.forecast.io/
*	The API to query is https://api.forecast.io/forecast/{Your API key here}/{latitude},{longitude}. We would like you to obtain the geolocation using the API’s available from the mobile operating system. 
*	The use of frameworks, libraries, and open-source code is allowed – but please reference their use in comments in the code. Please use package management for open source dependencies where suitable. 
*	When complete, please fork this repository, commit your code via the GIT tools, and send us a pull request. 
