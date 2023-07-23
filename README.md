# Custom Spring Boot Starter Example

Spring Boot starters are specialiced packages for your Spring Boot applications. 
They consist of pre-configured dependencies, configurations, and beans tailored to address specific functionality or features. 
When you include a starter in your project's build file, such as Maven or Gradle, it automatically brings in all the necessary components related to that specific task.
It is a great way to easily add for example a database connection with minimal effort and configuration.

In order to for developers to avoid copy-pasting tons of boiler-plate code when between project it is easy to create your own custom starters.
These will pull in the necessary dependencies, add default configurations and instansiate beans for you.

This repository contains a bare-minimum Spring Boot 3 compatible starter ready to be extended.

## Components of a starter
Besides pom.xml we only have four files, two of them which are very important.
```
src/
|– main/
   |- java/
   |  |- CustomAutoConfiguration.java
   |  |- CustomBean.java
   |   
   |- resources/
      |- META-INF/
         |- spring.factories (optional)
         |- spring/
            |- org.springframework.boot.autoconfigure.AutoConfiguration.imports


```

Let's go through them one by one.

### org.springframework.boot.autoconfigure.AutoConfiguration.imports
This file must be located in the `src/main/resources/spring` folder.  
It specifies all the configuration classes you would like Spring to automatically load.
The format is very simple, put each class on a separate line.
In our case it only references our `CustomAutoConfiguration` class.
```
com.github.moezzie.customstarterexample.CustomAutoConfiguration
```
> ⚠️ The class names must be **fully qualified**, meaning it contains **both the package and the class name**, eg. `com.github.moezzie.customstarterexample.CustomAutoConfiguration`.


### spring.factories
This is the deprecated equivalent of `org.springframework.boot.autoconfigure.AutoConfiguration.imports`.
If you want to support Spring Boot versions less than 2.7 you will need to include this file as well.
It works the same way but has a slightly different format.
The file will always start with `org.springframework.boot.autoconfigure.EnableAutoConfiguration=\`, followed by a comma separated list of fully qualified (package name + class name) class names you would like to include in Spring Boot's auto configuration.


### CustomAutoConfiguration.java and CustomBean.java
Say we want our Spring Boot application to automatically instanciate our CustomBean bean.
We can set up an *AutoConfiguration*, just as we would do in our parent application.
Just make sure to annotate the class with @Configuration to help Spring Boot will pick it up.

Here you can load all the beans, configurations and anything else your integration needs.

If you need a refresher on Autoconfiguration, I can recommend [this article from Baeldung](https://www.baeldung.com/spring-boot-custom-auto-configuration)

