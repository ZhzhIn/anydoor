package com.testpackage.suite;


import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/*
@RunWith(Suite.class)
@Suite.SuiteClasses({
//        xxx.class,
//        xxx.class
})
*/
@RunWith(Categories.class)
@Categories.IncludeCategory(SlowGroup.class)
@Categories.ExcludeCategory(FastGroup.class)
@Suite.SuiteClasses({
//        xxx.class,
//        xxx.class
        TestDemo.class
})

public class FeatureTestSuite {
}
