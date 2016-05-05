### SpringMVC的学习例子(包含以下学习例子)
- Servlet,Listener,Filter,Interceptor.
- JavaMail,排序(冒泡,快速).
- 整合Spring.


###Filter
```java
<filter>
        <filter-name>helloFilter</filter-name>
        <filter-class>com.springmvc.filter.HelloFilter</filter-class>
</filter>

<filter-mapping>
        <filter-name>helloFilter</filter-name>
        <url-pattern>/*</url-pattern>
        <dispatcher>REQUEST</dispatcher>
        <!--default is REQUEST-->
</filter-mapping>
```
> The dispatcher has four legal values: FORWARD, REQUEST, INCLUDE, and ERROR.
> A value of FORWARD means the Filter will be applied under RequestDispatcher.forward() calls.
> A value of REQUEST means the Filter will be applied under ordinary client calls to the path or servlet.
> A value of INCLUDE means the Filter will be applied under RequestDispatcher.include() calls.
> A value of ERROR means the Filter will be applied under the error page mechanism.
> The absence of any dispatcher elements in a filter-mapping indicates a default of applying filters only under ordinary client calls to the path or servlet.

1. ContextLoadListener的作用:①创建IOC容器对象;②将其放入application域对象中.
2. Thread.currentThread().getStackTrace()    找到当前代码的调用路径
