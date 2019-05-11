package com.example.employee.repository;

import com.example.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //以下所有的*都代表变量

    //1.查询名字是*的第一个employee

    Employee findByName(String name);


    //2.找出Employee表中第一个姓名包含`n`字符的雇员所有个人信息并且薪资大于*

    @Query(value = "select * from Employee where name like %:name% and salary>:sal",nativeQuery = true)
    Employee findByContainsName(@Param("name") String name,@Param("sal") int salary);


    //3.找出一个薪资最高且公司ID是1的雇员以及该雇员的name
    @Query(value = "select * from employee join (select max(salary) maxsal from employee where companyId=?1) m where salary=m.maxsal;",nativeQuery = true)
    Employee findByCompanyIdAndMaxSalary(int CompanyId);

    //4.实现对Employee的分页查询，每页两个数据

    //5.查找**的所在的公司的公司名称
    @Query(value = "select companyName from company where id=(select companyId from employee where name=:sname);",nativeQuery = true)
    String findCompanyNameByName(@Param("sname") String sname);

    //6.将*的名字改成*,输出这次修改影响的行数
    @Modifying
    @Query(value = "update employee set name=:newName where name=:oldName",nativeQuery = true)
    int updateEmployeeByName(@Param("newName") String newName,@Param("oldName") String oldName);

    //7.删除姓名是*的employee
    void deleteByName(String name);
}
