使用springdatajpa
1）maven导入依赖
    <!-- mysql driver -->
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.15</version>
    </dependency>
    <!-- junit -->
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
    </dependency>
    <!-- lombok -->
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.6</version>
    </dependency>
    <!-- spring data jpa -->
    <dependency>
      <groupId>org.springframework.data</groupId>
      <artifactId>spring-data-jpa</artifactId>
      <version>2.1.5.RELEASE</version>
    </dependency>
    <!-- hibernate-core -->
    <dependency>
      <groupId>org.hibernate</groupId>
      <artifactId>hibernate-core</artifactId>
      <version>5.4.1.Final</version>
    </dependency>

2) 创建beans.xml
    1. 配置dataSources
    2. 配置jpa
    3. 配置事务管理器
    4. 配置springdata扫描的包

3) 编码
    1. 创建实体类, 添加注释  @Entity
                            @Table(name="SPRING_DATA_JPA")
    2. 创建接口并继承Repository<表类名, 主键>
    3. 写junit单元测试，通过实体生成表

4) springdata按照方法名命名规则测试
    对于按照方法名命名规则来使用的弊端：
        1. 方法名比较长： 约定大于配置
        2. 对于一些复杂的查询很难实现

    @Query注解使用
        1. 在Repository方法中使用, 不需要遵循查询方法命名规则
        2. 只需要将@Query定义在Repository中的方法之上即可
        3. 命名参数及索引参数的使用
        4. 本地查询
    更新和删除操作整合事务的使用
        1. @Modifying注解使用
        2. @Modifying结合@Query注解执行更新操作
        3. @Transactionnal在Spring Data中的使用

5) 事务在Spring Data中的使用
    1. 事务一般是在Service层
    2. @Query @Modifying @Transactionnal组合使用

注：
    Repository类的定义：public interface Repository<T, ID> {

                   }
    1. Repository时一个空接口, 标记接口，没有包含方法声明的接口
    2. 如果我们定义的接口没有 extends Repository，运行时会报错
    3. 添加注解能达到不用 extends Repository的功能
        @RepositoryDefinition(domainClass = Emp.class, idClass = Integer.class)


Repository的子接口
    CrudRepository：继承Repository, 实现了CRUD相关的方法
    PagingAndSortingRepository：继承CrudRepository, 实现了分页排序相关的方法
    JpaRepository：继承PagingAndSortingRepository, 实现JPA规范相关的方法


spring data jpa、jpa规范、hibernate三者的关系:

    java代码 ---> spring data jpa
                           |
                           |
                           |
                           V
                         jpa规范
                            |
                            |
                            |
                            V           封装jdbc操作
                        hibernate -------------------
                                                    |
                                                    |
                                                    |
                                                    V
                                                  数据库