# MVVM BluePrint

This application is just MVVM Blueprint.
It uses some Architecture Components like ViewModel, LiveData, and other lifecycle-aware classes. In the MVVM architecture, Views react to changes in the ViewModel without being explicitly called.

## Components used

Before exploring this, you should familiarize yourself with the following topics:

* [Livedata](https://developer.android.com/topic/libraries/architecture/livedata)
    + Live data is life-cycle data holder class. It ensures updating app component observers that are in state of active life cycle.
* [MVVM](https://developer.android.com/topic/libraries/architecture/viewmodel)
    + Model–view–viewmodel is designed to store & manage UI related data in a lifecycle consious way.
* [MVVM-databinding](https://developer.android.com/topic/libraries/data-binding/)
    + It allows to bind UI components in the layout to data sources in the app using a declerative format rather than programatically. For eg. 
    >*TextView textView = findViewById(R.id.sample_text);
    textView.setText(viewModel.getUserName());*
 **will be replaced by**
*<TextView
    android:text="@{viewmodel.userName}" />*
* [Dagger](https://google.github.io/dagger/)
    + Its a fully static, compile time dependency injection framework. Dagger 2.x eliminates all reflection, and improves code clarity by removing the traditional ObjectGraph/Injector in favor of user-specified @Component interfaces.
* [Retrofit](https://square.github.io/retrofit/)
* [Volley](https://developer.android.com/training/volley/index.html)
    + Retrofit and Volley both are the REST client libraries that makes networking for Android apps easier and faster.
    + Retrofit aims to make it easier to consume RESTful web services where as the goal of Volley is to handle all your networking needs for Android specifically.
* [RX Java](https://github.com/ReactiveX/RxJava)
* [RX Android](https://www.androidhive.info/RxJava/android-getting-started-with-reactive-programming/)
    + RxJava is a Java based implementation of Reactive Programming.
    + RxAndroid is specific to Android platform which utilises some classes on top of the RxJava library.
* [Room](https://developer.android.com/topic/libraries/architecture/room)
    + Room persistence library provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite

## Other Essential Components

* [Fabric](https://developer.android.com/topic/libraries/architecture/livedata)
    + Fabric is a platform that assist in powering apps for Crash Reporting & Analytics.
* [WatchDog](https://developer.android.com/topic/libraries/architecture/livedata)
    + WatchDog is library that can be added in any project, so as to get basic device details in which the app is installed.

## Step by step implementation guide & references for different components

### WatchDog
1. Add these lines in your project level gradle file:
    >allprojects {
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;repositories {			
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;maven { url 'https://jitpack.io' }
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;		}
	}

2. Add this in dependencies in you app level gradle:
	>*debugImplementation 'com.github.ashishjohn1908:watchdog:1.0.1'*

3. Register your package name to get the key.

4. Pass context & appKey as parameter.
	>WatchDog.watch({context}, {key});

---
### Fabric
1. Add these lines in your project level gradle file:
    >buildscript {
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;repositories {
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;maven { url 'https://maven.fabric.io/public' }
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dependencies {
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;classpath 'io.fabric.tools:gradle:1.+'
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}
}
2. Add this in plugin in you app level gradle:
    >*apply plugin: 'io.fabric'*

3. Add this in dependencies in you app level gradle:
	>*compile('com.crashlytics.sdk.android:crashlytics:2.9.9@aar') {
    transitive = true;
  }*

4. Add Your API Key in manifest file.
      ><meta-data
          android:name="io.fabric.ApiKey"
          android:value="<FABRIC_API_KEY>"
      />

5. Pass context to initialize Fabric.
	>Fabric.with(this, new Crashlytics());

---
### Rx Java / Rx Android
  + **Reactive Programming** is a programming paradigm oriented around data flows and the propagation of change i.e. it is all about responding to value changes.
  + **Reactive Extensions** is a library that follows Reactive Programming principles to compose asynchronous and event-based programs by using observable sequence.
  + **RxJava** is a Java based implementation of Reactive Programming.
  + **RxAndroid** is specific to Android platform which utilises some classes on top of the RxJava library.
   
 + The building blocks of RxJava are:
    + **Observable**: class that emits a stream of data or events. i.e. a class that can be used to perform some action, and publish the result.
	+ **Observer**: class that receivers the events or data and acts upon it. i.e. a class that waits and watches the Observable, and reacts whenever the Observable publishes results.
 + More detailed information can be gathered (but not limited to) from below mentioned links:
   + [Github Page](https://github.com/ReactiveX/RxAndroid)
   + [Proandroiddev Website](https://proandroiddev.com/exploring-rxjava-in-android-e52ed7ef32e2)
   + [Medium Blog](https://medium.com/@kevalpatel2106/code-your-next-android-app-using-rxjava-d1db30ac9fcc)
  
---
### Dagger Dependency Injection
  + Dagger is a fully static, compile-time dependency injection framework for both Java and Android.
 + Detailed information with demo examples can be gathered (but not limited to) from below mentioned links:
   + [Google Github Page](https://google.github.io/dagger/)
   + [Medium Blog](https://medium.com/@harivigneshjayapalan/dagger-2-for-android-beginners-dagger-2-part-i-f2de5564ab25)

---
### Architecture Components
 + [Architecture components](https://developer.android.com/topic/libraries/architecture/) help you design robust, testable and maintainable apps.

  + [Data Binding](https://developer.android.com/topic/libraries/data-binding/)
Declaratively bind observable data to UI elements
  + [Lifecycles](https://developer.android.com/topic/libraries/architecture/lifecycle)
Manage your activity and fragment lifecycles
  + [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
Notify views when underlying database changes
  + [Navigation](https://developer.android.com/guide/navigation/)
Handle everything needed for in-app navigation
  + [Paging](https://developer.android.com/topic/libraries/architecture/paging/)
Gradually load information on demand from your data source
  + [Room](https://developer.android.com/topic/libraries/architecture/room)
Fluent SQLite database access
  + [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
Manage UI-related data in a lifecycle-conscious way
  + [WorkManager](https://developer.android.com/topic/libraries/architecture/workmanager)
Manage your Android background jobs

