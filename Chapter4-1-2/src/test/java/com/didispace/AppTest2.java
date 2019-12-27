package com.didispace;

import com.didispace.async.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.rmi.ServerError;
import java.util.concurrent.Future;

/**
 * description: AppTest2 <br>
 * date: 2019/12/27 14:13 <br>
 *
 * @author: Zhangdi <br>
 * version: 1.0 <br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class AppTest2 {
    @Autowired
    Task task;

    @Test
    public void test() throws Exception {
        long start = System.currentTimeMillis();
        Future<String> taskOne = task.doTaskOne();
        Future<String> taskTwo = task.doTaskTwo();
        Future<String> taskThree = task.doTaskThree();

        Thread thread = Thread.currentThread();
        long id = thread.getId();
        String name = thread.getName();
        ClassLoader contextClassLoader = thread.getContextClassLoader();
        int priority = thread.getPriority();
        ThreadGroup threadGroup = thread.getThreadGroup();

        Thread.State state = thread.getState();


        while (true) {
            if (taskThree.isDone() && taskThree.isDone() && taskTwo.isDone()) {
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        System.err.println("全部任务完成！用时：" + (end - start) + "毫秒");
    }
}
