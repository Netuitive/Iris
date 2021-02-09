Iris
=====

Iris is a Java library that allows communication with Netuitive's Rest API. If you have a [Virtana](https://www.virtana.com/products/cloudwisdom/) account and you want to explore Netuitive's REST API and test some requests, go [here](https://try.cloudwisdom.virtana.com/).

See our [API docs](https://docs.virtana.com/en/api.html) for more information, or contact Netuitive support at [cloudwisdom.support@virtana.com](mailto:cloudwisdom.support@virtana.com).

Building Iris
--------------

    ./gradlew build


Testing Iris
-------------

    ./gradlew -Dusername='{username}' -Dpassword='{password}' -DapiKey='{apiKey}' -Demail='{email}' clean test
