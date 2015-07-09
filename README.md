# l2l3-monitoring

A reusable Monitoring Library with AOP

An easily integrable, but configurable solution to monitor application's beans with an @Monitoring annotation.

The gathered information will be saved into an arbitrary elasticsearch cluster.
The information will be the following:
- runttime with timestamp
- parameters
- return value
- class and method name

The solution will not have an influence on the existing application.
