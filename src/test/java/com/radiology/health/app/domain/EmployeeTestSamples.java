package com.radiology.health.app.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class EmployeeTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static Employee getEmployeeSample1() {
        return new Employee().id(1L).his("his1").serviceNo("serviceNo1").name("name1").technician(1);
    }

    public static Employee getEmployeeSample2() {
        return new Employee().id(2L).his("his2").serviceNo("serviceNo2").name("name2").technician(2);
    }

    public static Employee getEmployeeRandomSampleGenerator() {
        return new Employee()
            .id(longCount.incrementAndGet())
            .his(UUID.randomUUID().toString())
            .serviceNo(UUID.randomUUID().toString())
            .name(UUID.randomUUID().toString())
            .technician(intCount.incrementAndGet());
    }
}
