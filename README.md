Iris
=====

Iris is a Java library that allows communication with Netuitive's Rest API. If you have a [Netuitive](https://www.netuitive.com) account and you want to explore Netuitive's REST API and test some requests, go [here](https://app.netuitive.com/api/external.html).

See our [API docs](https://docs.virtana.com/en/api.html) for more information, or contact Netuitive support at [support@netuitive.com](mailto:support@netuitive.com).

Building Iris
--------------

    ./gradlew build


Testing Iris
-------------

    ./gradlew -Dusername='{username}' -Dpassword='{password}' -DapiKey='{apiKey}' -Demail='{email}' clean test
