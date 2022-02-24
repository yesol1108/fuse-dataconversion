package org.mycompany.processors;

import java.util.Random;

import org.mycompany.model.Student;
import org.mycompany.processors.MyBean.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyBean {

    private static final Logger logger = LoggerFactory.getLogger(MyBean.class);

    public Student process(Student student) throws Exception {

        student.setStatus(Status.getRandomStatus().toString());
        student.setRoom("jboss-fuse-7");

        return student;
    }

    enum Status {
        Registered,
        Follow,
        Certified,
        Canceled;

        public static Status getRandomStatus() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }

    }
    
}
