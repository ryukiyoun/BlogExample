package com.junit.testdouble.common;

public interface MemberRepository {
    void save(String name);
    Member findById(long id);
}
