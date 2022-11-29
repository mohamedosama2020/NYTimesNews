
# NYTimesNews App
This is Android Application for retrieving NewYork Times news 

## Installation
Just Clone this repository and import into **Android Studio**

## Package structure
* data
	* ApiService
	* Repostory 	
* entities
	* remote
	* ui
* ui
	* news_list
	* news_details 	
* usecases	
* di

## Technolgies Used
* Clean Architecture
* Dagger Hilt
* Jetpack components (LiveData and ViewBinding)
* Retrofit and GSON
* Unit test and code coverage

## Configuration
### API KEY:
In your `local.properties` file add a property with the following info (without the qoutes):
```gradle
api_key='YOUR_API_KEY_FROM_NYTIMES'
```
And this is link for creating API KEY  [NYTimes](https://developer.nytimes.com/)

After adding the property you can Build the app

## Unit Test Scope
There is an example of unit testing the **ViewModel** 
You will find ```NewsViewModelTest``` Under the test folder


## Create Unit Test Report
* Test Report is created using ```JaCoCo```
* Just Type this command in the terminal of the Android Studio Project 
```
./gradlew testDebugUnitTestCoverage
```
* Then after the terminal finish the unit test coverage you will find the report html file under the following directory:
 ``` \app\build\reports\jacoco\testDebugUnitTestCoverage\html\index.html ```
