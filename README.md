# servlet-filter
## source video https://www.youtube.com/watch?v=w5GfmTUHAnM 

This is a demo project on how to use Servlet Filters.
We have to use Web.xml or Configuration annotated class to define the beans for Servlets and Filters as shown in the WebConfig.java
The filters will intercept the HttpRequest before it reaches the resource Servlet.
The FilterChain will be created upon context initialization according to the order defined in each Filter bean definition (WebConfig.java)

We can also create Filters using annotations but they will intercept every request to a resource as we can't provide urlPatterns.
InterceptAllFilter Filter in this project will intercept every request to any URL.