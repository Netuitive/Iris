Iris
=====

Iris is a Java library that allows communication with CloudWisdom's Rest API. If you have a [CloudWisdom](https://www.virtana.com/products/cloudwisdom/) account and you want to explore CloudWisdom's REST API and test some requests, go [here](https://us.cloudwisdom.virtana.com/api/external.html).

See our [API docs](https://docs.virtana.com/en/api.html) for more information, or contact CloudWisdom support at [cloudwisdom.support@virtana.com](mailto:cloudwisdom.support@virtana.com).

Building Iris
--------------

    ./gradlew build


Testing Iris
-------------

    ./gradlew -Dusername='{username}' -Dpassword='{password}' -DapiKey='{apiKey}' -Demail='{email}' clean test
