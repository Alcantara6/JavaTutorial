package com.yanjing.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;

/**
 * @author yanjing
 * @date 2021/8/21
 * 在任何通知中，参数都是可选的，需要使用时直接填写即可，不需要使用时，可以完成不用声明出来
 */
@Aspect
public class AnnotationPointCut implements Ordered {

    /**
     * 采用与ApectJ中使用pointcut关键字类似的方式定义切入点表达式
     */
    @Pointcut("execution(* com.yanjing.service.UserServiceImpl3.*(..))")
    private void specifiedClassPointCut() {
    }

    /**
     * 1. Before
     */
    @Before("execution(* com.yanjing.service.UserServiceImpl3.*(..))") // 直接把execution已定义匹配表达式作为值传递给通知类型
    public void before(JoinPoint joinPoint) {
        System.out.println("---------注解方式方法执行前，方法参数是：" + joinPoint.getArgs()[0] + "---------");
    }

    /**
     * 2. After
     * 该通知有点类似于finally代码块，只要应用了无论什么情况下都会执行
     */
    @After("specifiedClassPointCut()") // 应用切入点函数
    public void after(JoinPoint joinPoint) {
        System.out.println("---------注解方式方法执行后，方法参数是：" + joinPoint.getArgs()[0] + "---------");
    }

    /**
     * 3. AfterReturning
     */
    // @AfterReturning(value = "args(a, b)", argNames = "joinPoint,returnVal,a, b", returning = "returnVal")
    // 或， 注意a，b的类型、顺序、数量必须和目标方法一致
    @AfterReturning(value = "execution(* com.yanjing.service.UserServiceImpl3.*(..)) && args(a,b,..)", returning = "returnVal")
    public void afterReturning(JoinPoint joinPoint, Object returnVal, int a, int b) {

        System.out.println("---------注解方式方法执行后，方法参数是：" + a
                + ", and: " + b
                + "，返回值---------" + returnVal
                + "---------");
    }

    /**
     * 4. Around
     * @param jp 第一个参数必须是ProceedingJoinPoint
     * 尽量以最简单的方式满足需求，在仅需在目标方法前执行时，应该采用前置通知而非环绕通知
     * 同时AfterReturning和Around, AfterReturning的returnValue会有问题，是null
     */
    // @Around("specifiedClassPointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("---------注解方式方法Around执行前，方法参数是：" + jp.getArgs()[0] + "---------");
        // 执行方法
        Signature signature = jp.getSignature();
        jp.proceed();
        System.out.println("---------注解方式方法Around执行后，方法参数是：" + jp.getArgs()[0] + "---------");
    }

    /**
     * 5. AfterThrowing
     */
    // 抛出通知
    @AfterThrowing(value = "specifiedClassPointCut()", throwing = "e")
    public void afterThrowable(JoinPoint joinPoint, Throwable e) {
        System.out.println("抛出异常：msg=" + e.getMessage() + ", 方法参数是：" + joinPoint.getArgs()[0]);
    }

    // ============================切入点指示符验证===============================================

    /**
     * + 匹配给定类的任意子类
     */
    @Pointcut("within(com.yanjing.service.sub.AopTargetService+)")
    // @Pointcut("execution(* com.yanjing.service.sub.AopTargetService.*(..))")
    private void specifiedInterfacePointCut() {
    }

    @Before("specifiedInterfacePointCut()")
    public void beforeOfInterfaceMethod() {
        System.out.println("------before, 切入到接口的方法中---------");
    }

    /**
     * .. ：匹配类定义中的任意数量包，此外还可以匹配方法定义中的任意数量的参数
     */
    @Pointcut("within(com.yanjing.service.sub..*)")
    private void packageServicePointCut() {
    }

    @Before("packageServicePointCut()")
    public void beforeOfWithinPackage() {
        System.out.println("------before, 切入到包内的实现类中---------");
    }

    /**
     * *通配符：匹配任意数量的字符
     */
    @Pointcut("execution(* run*(int))")
    private void regPointCut() {
    }

    @After("regPointCut()")
    public void beforeOfRegPointCut() {
        System.out.println("------after, 切入run开头的方法中---------");
    }

    /**
     * 类型签名表达式: within(<type name>)
     * 方法签名表达式: execution(<scope> <return-type> <fully-qualified-class-name>.*(parameters))
     */

    /**
     * 其它指示符
     * bean：Spring AOP扩展的，AspectJ没有对于指示符，用于匹配特定名称的Bean对象的执行方法；
     */
    @Pointcut("bean(*Service)")
    private void beanPointcut1() {
    }

    /**
     * this ：用于匹配当前AOP代理对象类型的执行方法；请注意是AOP代理对象的类型匹配，这样就可能包括引入接口也类型匹配
     */
    @Pointcut("this(com.yanjing.service.sub.AopTargetService)")
    // @Pointcut("this(com.yanjing.service.sub.AopTargetServiceImpl)"),这样不行，因为运行时getBean是代理的对象，imple是被代理的目标对象
    private void proxyObjectPointCut() {
    }

    /**
     * target ：用于匹配当前目标对象类型的执行方法；
     */
    @Pointcut("target(com.yanjing.service.sub.AopTargetService)")
    private void actualObjectPointCut() {
    }

    /**
     * @within：用于匹配所以持有指定注解类型内的方法；请注意与within是有区别的， within是用于匹配指定类型内的方法执行；
     */
    @Pointcut("@within(com.yanjing.AutoLog)")
    private void classAnnotationPointCut() {
    }

    @After("classAnnotationPointCut()")
    public void afterOfClassAnnotationPointCut() {

        System.out.println("---------after, 切入含有@Autolog注解的类----------");
    }

    /**
     * @annotation : 根据所应用的注解进行方法过滤
     */
    @Pointcut("@annotation(com.yanjing.AutoLog)")
    private void methodAnnotationPointCut() {
    }

    /**
     * 定义这个切面的优先级,如果有多个切面，值越低的切面,优先级越高（前置通知先执行，后置通知后执行）
     * 同一个切面内，按通知声明先后的顺序决定优先级
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }


    /**
     * and、or、not（或者&&、||、！）
     */

    /**
     * 通知传递参数
     * arg，见@afterReturning
     */


}
